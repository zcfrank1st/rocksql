package com.chaos.rocksql.module

import com.chaos.rocksql.model.RockOpts
import com.chaos.rocksql.queue.RockOptsEventProducer

/**
  * Created by zcfrank1st on 13/03/2017.
  */
trait QueueOperator {
  def putToQueue(rockOpts: RockOpts)(implicit producer: RockOptsEventProducer): Unit = {
    producer.onData(rockOpts)
  }
}
