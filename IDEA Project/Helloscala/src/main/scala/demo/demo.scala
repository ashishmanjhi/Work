package demo

import java.util.jar.Attributes.Name

import scala.collection.mutable

//object demo {
//  def main(args:Array[String]){
//    val lst= List(1,2,3,4,5,33,22,6,5,4);
//    val res=for(i <- lst;if i<6)yield{
//      i*i
//    }
//    println("result"+res)
//  val age =24

//    age match {
//      case 20=> println(age);
//      case 18=> println(age);
//      case 30=> println(age);
//      case 24=> println(age);
//      case 11=> println(age);
//    }

//    object Math{
//      def add(x:Int=22,y:Int=11):Int=x+y
//
//      def square(x:Int): Int =x*x
//    }
//
//    def sub(x:Int,y:Int):Int=x-y
//
//    def mul(x:Int,y:Int):Int=x*y
//
//    def div(x:Int,y:Int)=x/y
//
//    println(Math.add(66))
//    println(sub(25,5))
//    println(mul(25,5))
//    println(div(25,5))
//    println(Math.square(5));1 to 10

//    def math(x: Double,y:Double,z:Double,f:(Double,Double)=>Double):Double=f(f(x,y),z)
//    val res=math(12,22,33,_+_)
//    println(res)

//    def log(date: Date,message: String): Unit ={
//      println(date+" "+message)
//    }
//    val sum=(a:Int,b:Int,c:Int)=>a+b+c
//    val f=sum(10,_:Int,_:Int)
//    println(f(30,59))
//
//    val date=new Date
//    val newLog =log(date,_:String)
//    newLog("the msg 1")
//    newLog("the msg 2")
//    newLog("the msg 3")

//def add1(x:Int)=(y:Int)=>x+y
//    println(add1(10)(20))
//    val sum11=add1(25)
//    println(sum11(21))

//    val myarray:Array[Int]=new Array[Int](4)
//    val myarray1=new Array[Int](5)
//    val myarray2=Array(99,88,77,66,55)
//myarray(0)=23
//    myarray(1)=12
//    myarray(2)=13
//    myarray(3)=32
//    //println(myarray)
//for (x<-myarray1){
//  println(x)
//}
//
//    for(i<-0 to (myarray.length-1)){
//      println(myarray(i))
//    }
//
//  val res= concat(myarray,myarray2)
//
//    for (x<-res){
//      println(x)
//    }

//    val mylist:List[Int]=List(1,2,3,45,6,8,8,7)
//     val name:List[String]=List("Ashish","Raj","John")
//    println(0::mylist)
//    println(name)
//
//    println(1::22::15::Nil)
//    println(mylist.head)
//    println(name.tail)
//    println(name.isEmpty)
//    var sum: Int = 0
//    mylist.foreach(sum+=_)
//    println(sum)

//    val myset: Set[Int]=Set(1,2,3,4,4,5,6,6,7,9)
//    //var myset1: mutable.Set[Int] = mutable.Set(1,1,2,2,3,3)
//    val names:Set[String]=Set("Ashish","Ashish","Raj","John")
//    println(myset)
//    println(names)
//    //println(myset1)
//    println(myset(9))


//    val mymap:Map[Int,String]=Map(101->"ashish",102->"Raj",103->"tom")
//    println(mymap.keys)
//    println(mymap.values)
//
//    mymap.keys.foreach{key=>
//    println("key "+key);
//    println("values "+mymap(key));

//val mytuple=(1,2,"Hello",true)
    ////    val mytuple1=new Tuple3(1,2,"Hi")
    ////    println(mytuple1._3)
    ////    println(mytuple._2)
    ////    mytuple.productIterator.foreach({
    ////      i=>println(i)
    ////    })
    ////println(1->"Ashish"->true)

//    val lst=List(1,2,3)
//    val map=Map(1->"Ashish",2->"Max",3->"Hon")
//     val opt:Option[Int]=Some(55)
//    println(lst.find(_>2).get )
//    println(lst.find(_>4).getOrElse(7) )
//
//    println(map.get(1).get)
//    println(map.get(4).getOrElse("No name"))
//    println(opt.get)



//    val lst=List(1,2,3,4,57,9,213)
//    val mymap=Map(1->"ashsi",2->"liss",3->"dddd")
//
//    println(lst.map(_*2))
//    println(lst.map("hi"+_*2))
//
//    println(mymap.view.mapValues(x=>"hi  "+x).toMap)
//    println("hell". map(_.toUpper))
//    println(List(List(1,2,3),List(3,4,5)).flatten)
//    println(lst.flatMap((x=>List(x,x+1))))
//
//    println(lst.filter(x=>x%2==0))

//    val lst=List(1,2,3,4,57,9,213)
//    val lst1=List("a","b","c")
//    println(lst.reduceLeft(_+_))
//
//    println(lst1.reduceLeft(_+_))
    //println(lst.reduceLeft((x,y)=>{println(x +"," + y);x+y}))
//
//    println(lst.reduceLeft(_-_))
//    println(lst.reduceLeft((x,y)=>{println(x +"," + y);x-y}))
//    println(lst.reduceRight(_-_))
//    println(lst.reduceRight((x,y)=>{println(x +"," + y);x-y}))

//    println(lst.foldLeft(100)(_+_))
//
//    println(lst.scanLeft(100)(_+_))
//
//    println(lst1.scanLeft("z")(_+_))

//  }
//}


class User(var name:String, val age:Int) {
//  def printName {
//    (println(name))
def this(){
  this("Jack",32)
  }
  def this(name:String){
    this(name,32)
  }
}
object Demo{
def main(args: Array[String]): Unit ={
  var user = new User("Ashish",28)
  var user1=new User()
  var user2=new User("Ram")
  println(user.name +"  "+ user.age)
  println(user1.name +"  "+ user1.age)
  println(user2.name +"  "+ user2.age)
 // println(user.name)
  //user.printName
  //println(user.age)
 // user.name="King"
//  user.age=100
  //println(user.name)
//  println(user.age)


}
}