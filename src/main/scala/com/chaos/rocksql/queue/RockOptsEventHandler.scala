package com.chaos.rocksql.queue

import com.chaos.rocksql.module.RocksOperator
import com.lmax.disruptor.EventHandler

/**
  * Created by zcfrank1st on 13/03/2017.
  */
class RockOptsEventHandler extends EventHandler[RockOptsEvent] with RocksOperator {
  override def onEvent(event: RockOptsEvent, sequence: Long, endOfBatch: Boolean): Unit = {
    execute(event.get)
  }
}
