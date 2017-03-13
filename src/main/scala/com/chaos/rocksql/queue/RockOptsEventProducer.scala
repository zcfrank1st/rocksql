package com.chaos.rocksql.queue

import com.chaos.rocksql.model.RockOpts
import com.lmax.disruptor.RingBuffer

/**
  * Created by zcfrank1st on 13/03/2017.
  */
class RockOptsEventProducer(ringBuffer: RingBuffer[RockOptsEvent]) {

  def onData(rockOpts: RockOpts) {
    val sequence = ringBuffer.next();  // 获取下一个序列号
    try {
      val event: RockOptsEvent = ringBuffer.get(sequence); // 根据序列号获取预分配的数据槽
      // 向数据槽中填充数据
      event.set(rockOpts)
    } finally {
      ringBuffer.publish(sequence)
    }
  }
}
