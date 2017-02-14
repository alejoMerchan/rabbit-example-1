package com.example.rabbit.app

import com.example.rabbit.rabbitmq.Subscribe

/**
 * Created by abelmeos on 2017/02/14.
 */
trait Api {

  val suscription = new Subscribe().suscription

}
