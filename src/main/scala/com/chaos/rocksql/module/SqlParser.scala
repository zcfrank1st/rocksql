package com.chaos.rocksql.module

import com.chaos.rocksql.model._
import net.sf.jsqlparser.parser.CCJSqlParserUtil
import net.sf.jsqlparser.statement.create.table.CreateTable

/**
  * Created by zcfrank1st on 13/03/2017.
  */
trait SqlParser {
  def transform(sql: String)(implicit opt: Opt): RockOpts = {
    val stmt = CCJSqlParserUtil.parse(sql)
    opt match {
      // TODO parse sql to RockOpts
      case Create =>
        val createStmt = stmt.asInstanceOf[CreateTable]
      case Drop =>
        val dropStmt = stmt.asInstanceOf[net.sf.jsqlparser.statement.drop.Drop]

      case Update =>
        val updateStmt = stmt.asInstanceOf[net.sf.jsqlparser.statement.update.Update]
      case Insert =>
        val insertStmt = stmt.asInstanceOf[net.sf.jsqlparser.statement.insert.Insert]
      case Delete =>
        val deleteStmt = stmt.asInstanceOf[net.sf.jsqlparser.statement.delete.Delete]
      case Select =>
        val selectStmt = stmt.asInstanceOf[net.sf.jsqlparser.statement.select.Select]

      case _ => throw new RuntimeException("wrong opt !!!")
    }
    ???
  }
}
