import net.sf.jsqlparser.parser.CCJSqlParserUtil
import net.sf.jsqlparser.statement.Statement
import net.sf.jsqlparser.statement.create.table.CreateTable
import net.sf.jsqlparser.statement.delete.Delete
import net.sf.jsqlparser.statement.drop.Drop
import net.sf.jsqlparser.statement.insert.Insert
import net.sf.jsqlparser.statement.select.{PlainSelect, Select}
import net.sf.jsqlparser.statement.update.Update
import net.sf.jsqlparser.util.TablesNamesFinder

/**
  * Created by zcfrank1st on 13/03/2017.
  */
object RocksqlTest {
  def main(args: Array[String]): Unit = {
//    val createTableStat = CCJSqlParserUtil.parse("create table a (name string)").asInstanceOf[CreateTable]
//
//    println(createTableStat.getColumnDefinitions.get(0).getColumnName)
//    println(createTableStat.getTable.getName)
//
//    val dropTableStat = CCJSqlParserUtil.parse("drop table a").asInstanceOf[Drop]
//    println(dropTableStat.getName)
//
//    val insertStat = CCJSqlParserUtil.parse("insert into a (name, value) values ('hahaha', '1231232')").asInstanceOf[Insert]
//    println(insertStat.getColumns.get(0))
//    println(insertStat.getItemsList) // TODO insert
//
//    val updateStat = CCJSqlParserUtil.parse("update a set name='jsdsadd' where key = '1'").asInstanceOf[Update]
//
//    println(updateStat.getWhere) // TODO where
//    println(updateStat.getColumns.get(0))
//    println(updateStat.getTables.get(0))
//    println(updateStat.getExpressions.get(0))
//
//    val deleteStat = CCJSqlParserUtil.parse("delete from a where key = 1").asInstanceOf[Delete]
//    println(deleteStat.getTable)
//    println(deleteStat.getWhere) // TODO where
//
//    val commonStat = CCJSqlParserUtil.parse("select * from a where key = '3'")
//    val selectStat = commonStat.asInstanceOf[Select].getSelectBody.asInstanceOf[PlainSelect]
//
//    println(selectStat.getWhere)
//    println(selectStat.getSelectItems.get(0))
//
//    val tableFinder = new TablesNamesFinder
//    println(tableFinder.getTableList(commonStat).get(0))

    println("key = '3'".split("=")(1).replaceAll("\"?+'?+\\s?+", ""))
    println("key = 'hello world'".split("=")(1))
  }
}
