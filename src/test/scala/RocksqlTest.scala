import com.chaos.rocksql.model.{Delete, Operation}

/**
  * Created by zcfrank1st on 13/03/2017.
  */
object RocksqlTest {
  def main(args: Array[String]): Unit = {
    import com.chaos.rocksql.RocksqlExecutor._


    Operation(Delete, Nil, Nil)
  }
}
