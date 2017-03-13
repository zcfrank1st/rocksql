package com.chaos.rocksql.module

import com.chaos.rocksql.model._
import org.rocksdb.{Options, RocksDB}

/**
  * Created by zcfrank1st on 13/03/2017.
  */
trait RocksOperator {
  RocksDB.loadLibrary()
  val options: Options = new Options().setCreateIfMissing(true)

  def execute(rockOpts: RockOpts): Unit = {
    rockOpts.typ match {
      case Create | Update | Insert => put(rockOpts)
      case Drop | Delete => delete(rockOpts)
      case Select => selectWithSideEffect(rockOpts)
    }
  }

  // TODO rocksdb operation
  private def put(rockOpts: RockOpts): Unit = {}

  private def delete(rockOpts: RockOpts): Unit = {}

  private def selectWithSideEffect(rockOpts: RockOpts): Unit = {
    //
  }
}
