package com.chaos.rocksql.module

import com.typesafe.config.{Config, ConfigFactory}

/**
  * Created by zcfrank1st on 14/03/2017.
  */
trait ConfigModule {
  val conf: Config = ConfigFactory.load()
}
