package com.chaos.rocksql


import java.util.concurrent.Executors

import com.chaos.rocksql.model._
import com.chaos.rocksql.module.{QueueOperator, SqlParser}
import com.chaos.rocksql.queue.{RockOptsEvent, RockOptsEventHandler, RockOptsEventProducer, RockOptsFactory}
import com.lmax.disruptor.dsl.{Disruptor, ProducerType}
import com.lmax.disruptor.{RingBuffer, YieldingWaitStrategy}

import scala.concurrent.Future

/**
  * Created by zcfrank1st on 13/03/2017.
  */
//for only one statement
object Rocksql extends SqlParser with QueueOperator {
  val factory = new RockOptsFactory
  val ringBufferSize: Int = 1024 * 1024
  val disruptor = new Disruptor(factory,
    ringBufferSize, Executors.newSingleThreadScheduledExecutor(),
    ProducerType.SINGLE,
    new YieldingWaitStrategy())
  val handler = new RockOptsEventHandler
  disruptor.handleEventsWith(handler)
  disruptor.start()
  val ringBuffer: RingBuffer[RockOptsEvent] = disruptor.getRingBuffer

  implicit val producer = new RockOptsEventProducer(ringBuffer)

  def select(sql: String): Unit = {
    implicit val opt = Select
    putToQueue(transform(sql))
  }

  def insert(sql: String): Unit = {
    implicit val opt = Insert
    putToQueue(transform(sql))
  }

  def update(sql: String): Unit = {
    implicit val opt = Update
    putToQueue(transform(sql))
  }

  def delete(sql: String): Unit = {
    implicit val opt = Delete
    putToQueue(transform(sql))
  }

  // for table manipulate
  def create(sql: String): Unit = {
    implicit val opt = Create
    putToQueue(transform(sql))
  }

  def drop(sql: String): Unit = {
    implicit val opt = Drop
    putToQueue(transform(sql))
  }

  // for select result
  def selectResults (serial: String): Future[Map[String, String]] = ??? //  TODO 异步获取数据, 线程执行， side effect

}
