package com.chaos.rocksql


import com.chaos.rocksql.model._
import com.chaos.rocksql.module.{RocksOperator, SqlParser}

/**
  * Created by zcfrank1st on 13/03/2017.
  */
//for only one statement
object Rocksql extends SqlParser with RocksOperator {
  // TODO return
  def select(sql: String): Unit = {
    implicit val opt = Select
    execute(transform(sql))
  }

  def insert(sql: String): Unit = {
    implicit val opt = Insert
    execute(transform(sql))
  }

  def update(sql: String): Unit = {
    implicit val opt = Update
    execute(transform(sql))
  }

  def delete(sql: String): Unit = {
    implicit val opt = Delete
    execute(transform(sql))
  }

  // for table manipulate
  def create(sql: String): Unit = {
    implicit val opt = Create
    execute(transform(sql))
  }

  def drop(sql: String): Unit = {
    implicit val opt = Drop
    execute(transform(sql))
  }
}
