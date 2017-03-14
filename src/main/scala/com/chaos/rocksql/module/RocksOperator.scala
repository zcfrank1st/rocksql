package com.chaos.rocksql.module

import com.chaos.rocksql.model._
import org.rocksdb.{Options, RocksDB}
/**
  * Created by zcfrank1st on 13/03/2017.
  */
trait RocksOperator extends ConfigModule {
  val options: Options = new Options().setCreateIfMissing(true)
  val dbSource: String = conf.getString("rocksql.db.src")

  def execute(rockOpts: RockOpts): Unit = {
    rockOpts.typ match {
      case Create | Update | Insert => put(rockOpts)
      case Drop | Delete => delete(rockOpts)
      case _ =>
    }
  }

  def query[F[_], A](rockOpts: RockOpts): F[A] = this.synchronized {
    use (RocksDB.open(options, dbSource)) { db =>
      // TODO
    }
    ???
  }

  private def put(rockOpts: RockOpts): Unit = this.synchronized {
    use (RocksDB.open(options, dbSource)) { db =>
      (rockOpts.keys, rockOpts.values.get).zipped.foreach((key, value) => {
        db.put(key.getBytes(), value.getBytes())
      })
    }
  }

  private def delete(rockOpts: RockOpts): Unit = this.synchronized {
    use (RocksDB.open(options, dbSource)) { db =>
      rockOpts.keys.foreach(e => {
        db.delete(e.getBytes())
      })
    }
  }

  private def use[A <: { def close(): Unit }, B](resource: A)(code: A => B): B =
    try
      code(resource)
    finally
      resource.close()
}
