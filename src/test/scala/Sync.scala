

/**
  * Created by zcfrank1st on 14/03/2017.
  */
trait Sync {
  var rest = 1

  def demo(): Unit = this.synchronized {
    Thread.sleep(100)
    rest = rest + 1
    Thread.sleep(100)
    println(rest)
  }

}
