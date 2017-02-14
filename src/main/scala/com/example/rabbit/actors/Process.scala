package com.example.rabbit.actors

import akka.actor.{Props, ActorSystem, Actor}
import com.example.rabbit.actors.Process.{ActorMsg}
import com.example.rabbit.app.MainActors

import scala.concurrent.ExecutionContext

/**
 * Created by abelmeos on 2017/02/14.
 */

class ProcessSupervisor extends Actor {

  implicit val ec:ExecutionContext = MainActors.executionContext
  implicit val system:ActorSystem = MainActors.system

  val processActor = system.actorOf(Props[Process], "process-actor")

  def receive = {

    case msg:ActorMsg => processActor forward msg

  }

}

object Process {


  case class ActorMsg(id:Int)


}

class Process extends Actor {

  def receive = {

    case msgActor:ActorMsg =>
      println("actor msg from rabbitmq: " + msgActor.id )
  }

}
