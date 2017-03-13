package com.chaos.rocksql

import com.chaos.rocksql.module.{RocksOperator, SqlParser}
import org.rocksdb.{Options, RocksDB}

/**
  * Created by zcfrank1st on 13/03/2017.
  */
object RocksqlExecutor extends SqlParser with RocksOperator {

  RocksDB.loadLibrary()
  implicit val options: Options = new Options().setCreateIfMissing(true)

  // only for one select
  def select[F[_], A](sql: String)(implicit options: Options): F[A] = {
    // TODO parse sql
    // TODO contain execute vocabulary
    // TODO execute option

    ???
  }

  def insert(sql: String)(implicit options: Options): Unit = ???

  def update(sql: String)(implicit options: Options): Unit = ???

  def delete(sql: String)(implicit options: Options): Unit = ???

  // for table manipulate
  def create(sql: String)(implicit options: Options): Unit = {
    // TODO add meta info
  }

  def drop(sql: String)(implicit option: Options): Unit = ???
}
