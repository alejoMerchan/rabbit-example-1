package com.example.rabbit.rabbitmq

import akka.actor.ActorSystem
import com.example.rabbit.actors.Process.ActorMsg
import com.example.rabbit.app.{MainActors, RabbitCore}
import com.example.rabbit.queues.Queues._
import com.spingo.op_rabbit.{PlayJsonSupport, Directives, Subscription, Queue}
import play.api.libs.json.Json

import scala.concurrent.ExecutionContext


/**
 * Created by abelmeos on 2017/02/14.
 */
case class Data(id: Int)

class Subscribe extends RabbitCore{

  implicit val ec:ExecutionContext = MainActors.executionContextRabbit

  val system:ActorSystem = MainActors.system

  val processActor = system.actorSelection(MainActors.processSupervisorPath)

  import PlayJsonSupport._

  implicit val dataFormat = Json.format[Data]

  val suscription = Subscription.run(rabbitControl){
    import Directives._
    channel(qos= 3){
      consume(demoQueue){
        body(as[Data]){

          data=>
            println(data)
            processActor ! ActorMsg(data.id)
            ack

        }
      }
    }

  }

}
