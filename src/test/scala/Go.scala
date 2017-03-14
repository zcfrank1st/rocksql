import java.util.concurrent.{Executors, TimeUnit}

/**
  * Created by zcfrank1st on 14/03/2017.
  */
object Go extends App{
  val ex = Executors.newFixedThreadPool(10)
  val runner = new Runner

  ex.submit(new Runnable {
    override def run(): Unit = runner.demo()
  })
  ex.submit(new Runnable {
    override def run(): Unit = runner.demo()
  })
  ex.submit(new Runnable {
    override def run(): Unit = runner.demo()
  })
  ex.submit(new Runnable {
    override def run(): Unit = runner.demo()
  })
  ex.submit(new Runnable {
    override def run(): Unit = runner.demo()
  })


  ex.awaitTermination(10, TimeUnit.HOURS)
}
