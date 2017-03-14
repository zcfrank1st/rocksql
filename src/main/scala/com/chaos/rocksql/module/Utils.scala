package com.chaos.rocksql.module

/**
  * Created by zcfrank1st on 14/03/2017.
  */
trait Utils {
  def use[A <: { def close(): Unit }, B](resource: A)(code: A => B): B =
    try
      code(resource)
    finally
      resource.close()
}
