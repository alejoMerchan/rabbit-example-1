package com.example.rabbit.rabbitmq

import akka.actor.ActorSystem
import com.example.rabbit.actors.Process.ActorMsg
import com.example.rabbit.app.{MainActors, RabbitCore}
import com.example.rabbit.queues.Queues._
import com.spingo.op_rabbit._
import com.sura.trace.services.rabbitmq.mappers.Cotizacion
import play.api.libs.json.{JsValue, Json}

import scala.concurrent.ExecutionContext


/**
 * Created by abelmeos on 2017/02/14.
 */
case class Data(id: Int)

class Subscribe extends RabbitCore{

  implicit val cotizacionMarshaller =  new RabbitMarshaller[JsValue] with RabbitUnmarshaller[JsValue] {
    val contentType = "text/plain"
    val contentEncoding = Some("UTF-8")

    def marshall(value: JsValue) = {
      value.toString.getBytes
    }

    def unmarshall(value: Array[Byte], contentType: Option[String], charset: Option[String]) = {
      val firstJson = Json.parse(new String(value))
      val nodo = (firstJson \ "data").get
      val jsonCotizacion = (nodo \ "solicitudJson").get
      jsonCotizacion
    }
  }

  implicit val ec:ExecutionContext = MainActors.executionContextRabbit

  val system:ActorSystem = MainActors.system

  val processActor = system.actorSelection(MainActors.processSupervisorPath)

  import com.sura.trace.services.rabbitmq.mappers._

  implicit val dataFormat = Json.format[Data]

  val suscription = Subscription.run(rabbitControl){
    import Directives._
    channel(qos= 3){
      consume(demoQueue){
        body(cotizacionMarshaller){

          data=>
           //println(data)
            //val prueba = Json.toJson(data)
            val nuevo = Json.parse(data.toString().getBytes())

            val stringjson = data.toString()
            val string = stringjson.substring(1, stringjson.size-1)
            val prueba2 = stringjson.replaceAll("\\\\", "")
            //val prueba3 = Json.parse(string)

            //println(string)

            val cotizacion = data.as[Cotizacion]

            //println(prueba2)
            println("-----------------------------------------------------------------------------")
            println("-----------------------------------------------------------------------------")

            ack

        }
      }
    }

  }

}
