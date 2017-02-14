package com.example.rabbit.app

/**
 * Created by abelmeos on 2017/02/14.
 */
object Boot extends App with Core with RabbitCore with Api{

  println("--- sistema iniciado ---")

}
