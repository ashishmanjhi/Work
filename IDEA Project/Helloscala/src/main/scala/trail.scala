
import scala.io.Source

object trail {

  def main(args:Array[String]) {

    println(Source.fromFile("D:\\IDEA Project\\Helloscala\\trail.txt"))
    val s1 = Source.fromFile("trail.txt").mkString
    println(s1)

    val counts = s1.split("\\s+").groupBy(x=>x).view.mapValues(x=>x.length).toMap
    val sentences=s1.split("\\.").groupBy(x=>x).view.mapValues(x=>x.length).toMap

    println(counts)

   println(sentences)
    for (v <- sentences) {
      println(v)
    }
    println("Count of Data word:"+counts("Data"))

//    println(Source.fromFile("trail.txt").getLines())
//    Source.fromFile("trail.txt").getLines.foreach { x => println(x) };
  }

}