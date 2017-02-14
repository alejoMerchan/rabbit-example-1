package com.example.rabbit.app

import akka.actor.{Props, ActorSystem}
import akka.util.Timeout
import com.example.rabbit.actors.ProcessSupervisor
import com.spingo.op_rabbit.{RabbitControl, RecoveryStrategy}
import com.typesafe.config.{ConfigFactory, Config}
import scala.concurrent.duration._

/**
 * Created by abelmeos on 2017/02/14.
 */


object MainActors extends Core with CoreActors with RabbitCore

trait RabbitCore {

  lazy val systemRabbit = ActorSystem("rabbit-mq-system")
  lazy val executionContextRabbit = systemRabbit.dispatcher
  implicit lazy val recoveryStrategy = RecoveryStrategy.nack(false)


  val rabbitControl = systemRabbit.actorOf(Props[RabbitControl])

}

trait Core {

  lazy val system = ActorSystem("service-system")
  lazy val executionContext = system.dispatcher
  implicit lazy val conf:Config = ConfigFactory.load()
  implicit val timeout: Timeout = Timeout( 120 seconds )

}

trait CoreActors {

  this:Core =>

  private val processSupervisor = system.actorOf(Props[ProcessSupervisor], "process-supervisor")

  val processSupervisorPath = processSupervisor.path



}
