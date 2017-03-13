import net.sf.jsqlparser.parser.CCJSqlParserUtil
import net.sf.jsqlparser.statement.select.Select
import net.sf.jsqlparser.util.TablesNamesFinder
import org.rocksdb.{Options, RocksDB}

/**
  * Created by zcfrank1st on 13/03/2017.
  */
object RocksqlTest {
  def main(args: Array[String]): Unit = {
    val stat = CCJSqlParserUtil.parse("select * from item").asInstanceOf[Select]

    val table = new TablesNamesFinder

    val db = RocksDB.open(new Options().setCreateIfMissing(true), "")


  }
}
