package com.chaos.rocksql.module

import com.chaos.rocksql.model.{Opt, RockOpts}

/**
  * Created by zcfrank1st on 13/03/2017.
  */
trait SqlParser {
  def transform(sql: String)(implicit opt: Opt): RockOpts = {
    // TODO parse sql to RockOpts with uuid
    ???
  }
}
