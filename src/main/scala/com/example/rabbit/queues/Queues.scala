package com.example.rabbit.queues

import com.spingo.op_rabbit.Queue

/**
 * Created by abelmeos on 2017/02/14.
 */
object Queues {

  val demoQueue = Queue("demo", durable = true, autoDelete = true)


}
