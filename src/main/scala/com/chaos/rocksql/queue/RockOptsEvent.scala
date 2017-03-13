package com.chaos.rocksql.queue

import com.chaos.rocksql.model.RockOpts

/**
  * Created by zcfrank1st on 13/03/2017.
  */
class RockOptsEvent {
  private var rockOpts: RockOpts = _

  def set(rockOpts: RockOpts): Unit = {
    this.rockOpts = rockOpts
  }

  def get: RockOpts = rockOpts
}
