//class Lazy {
//  lazy val l={
//    println("lazy")
//    9
//  }
//}
//
//class strict {
//  val e={
//    println("strict")
//    9
//  }
//}

object Demo1{
  def main(args:Array[String]): Unit ={
//    val x=new strict
//    val y=new Lazy
//    println(x.e)
//    println(y.l)
    def meth1(n:Int): Unit ={
  println("meth1")
  println(n)
}
    def meth2(n:Int): Unit ={
      println("meth2")
      println(n)
    }

    val add=(a:Int,b:Int)=>a+b
    println("add")

meth1(add(5,6))

    meth2(add(2,6))
  }
}