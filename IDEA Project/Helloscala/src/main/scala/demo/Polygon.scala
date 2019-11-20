package demo

trait Shape {
  def color:String

}

abstract class Polygon {
  def area:Double

}

object Polygon{
  def main(args:Array[String]): Unit ={
    var rect=new Rectangle(55.2,20.8)
    printArea(rect)
    println(rect.color)
    var tri=new Triangle(20.2,40.5)
    printArea(tri)

    println(tri.color)
  }
  def printArea(p:Polygon): Unit ={
    println(p.area)
  }
}
