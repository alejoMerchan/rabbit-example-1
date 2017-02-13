package com.example.rabbit

import akka.actor.ActorSystem
import com.rabbitmq.client.ConnectionFactory
import com.thenewmotion.akka.rabbitmq.ConnectionActor

/**
 * Created by abelmeos on 2017/02/13.
 */
class PublishSubscribeExample extends App{

  implicit val system = ActorSystem()
  val factory = new ConnectionFactory
  val connection = system.actorOf(ConnectionActor.props(factory), "rabbitmq")

  val exchange = "amq.fanout"


}
