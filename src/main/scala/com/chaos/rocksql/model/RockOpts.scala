package com.chaos.rocksql.model

/**
  * Created by zcfrank1st on 13/03/2017.
  */
sealed trait Opt
object Create extends Opt
object Drop extends Opt

object Delete extends Opt
object Insert extends Opt
object Update extends Opt
object Select extends Opt

case class RockOpts (typ: Opt, keys: List[String], values: Option[List[String]])