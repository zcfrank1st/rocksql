package com.chaos.rocksql.queue

import com.lmax.disruptor.EventFactory

/**
  * Created by zcfrank1st on 13/03/2017.
  */
class RockOptsFactory extends EventFactory[RockOptsEvent]{
  override def newInstance(): RockOptsEvent = new RockOptsEvent
}
