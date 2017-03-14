package com.chaos.rocksql.module

import com.chaos.rocksql.model._
import org.rocksdb.{Options, RocksDB}
import resource._
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
    }
  }

  def query[F[_], A](rockOpts: RockOpts): F[A] = this.synchronized {
    for(db <- managed(RocksDB.open(options, ""))) {
      // TODO
    }
    ???
  }

  private def put(rockOpts: RockOpts): Unit = this.synchronized {
    for(db <- managed(RocksDB.open(options, ""))) {
      // TODO
    }
  }

  private def delete(rockOpts: RockOpts): Unit = this.synchronized {
    for(db <- managed(RocksDB.open(options, ""))) {
      // TODO
    }
  }
}
