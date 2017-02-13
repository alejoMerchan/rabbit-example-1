package com.example.rabbit

import akka.actor.{Props, ActorSystem}
import com.rabbitmq.client.ConnectionFactory
import com.spingo.op_rabbit._
import com.thenewmotion.akka.rabbitmq.ConnectionActor
import  play.api.libs.json._

import scala.concurrent.ExecutionContext


/**
 * Created by abelmeos on 2017/02/13.
 */

case class Data(id: Int)

object PublishSubscribeExample extends App{

  import PlayJsonSupport._

  implicit val dataFormat = Json.format[Data]

  implicit val actorSystem = ActorSystem("such-system")
  val rabbitControl = actorSystem.actorOf(Props[RabbitControl])
  implicit val recoveryStrategy = RecoveryStrategy.nack(false)

  import ExecutionContext.Implicits.global

  val demoQueue = Queue("demo", durable = true, autoDelete = true)



  val suscription = Subscription.run(rabbitControl){
    import Directives._
    channel(qos= 3){
      consume(demoQueue){
        body(as[Data]){

          data=>
            println(data)
            ack

        }
      }
    }
  }




}
