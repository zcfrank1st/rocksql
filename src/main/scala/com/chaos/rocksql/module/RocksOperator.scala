package com.chaos.rocksql.module

import com.chaos.rocksql.model._
import org.rocksdb.{Options, RocksDB}
import resource._
/**
  * Created by zcfrank1st on 13/03/2017.
  */
trait RocksOperator extends ConfigModule {
  RocksDB.loadLibrary()
  val options: Options = new Options().setCreateIfMissing(true)
  val dbSource: String = conf.getString("rocksql.db.src")

  def execute(rockOpts: RockOpts): Unit = {
    rockOpts.typ match {
      case Create | Update | Insert => put(rockOpts)
      case Drop | Delete => delete(rockOpts)
    }
  }

  def query[F[_], A](rockOpts: RockOpts): F[A] = this.synchronized {
    for(db <- managed(RocksDB.open(options, dbSource))) {
      // TODO
    }
    ???
  }

  private def put(rockOpts: RockOpts): Unit = this.synchronized {
    for(db <- managed(RocksDB.open(options, dbSource))) {
      (rockOpts.keys, rockOpts.values.get).zipped.foreach((key, value) => {
        db.put(key.getBytes(), value.getBytes())
      })
    }
  }

  private def delete(rockOpts: RockOpts): Unit = this.synchronized {
    for(db <- managed(RocksDB.open(options, dbSource))) {
      rockOpts.keys.foreach(e => {
        db.delete(e.getBytes())
      })
    }
  }
}
