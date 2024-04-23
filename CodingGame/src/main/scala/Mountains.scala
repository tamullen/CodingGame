object Mountains {

  import math._
  import scala.util._
  import scala.io.StdIn._

  /**
   * The while loop represents the game.
   * Each iteration represents a turn of the game
   * where you are given inputs (the heights of the mountains)
   * and where you have to print an output (the index of the mountain to fire on)
   * The inputs you are given are automatically updated according to your last actions.
   * */
  object Player extends App {

    // val list: List[Int] = List(readLine.toInt, readLine.toInt, readLine.toInt, readLine.toInt, readLine.toInt, readLine.toInt, readLine.toInt, readLine.toInt)
    // game loop
    def getMountainMax(): Int = {
      val m = List(readLine.toInt, readLine.toInt, readLine.toInt, readLine.toInt, readLine.toInt, readLine.toInt, readLine.toInt, readLine.toInt)

      def helper(list: List[Int], current: Int, prev: Int, max: Int, acc: Int): Int = {
        // if (current > max && acc < list.length - 1) helper(list(acc + 1), current, current, acc + 1)
        // else if (current <= max && acc < list.length - 1) helper(list(acc + 1), current, max, acc + 1)
        // else acc
        // if (acc > 0) {
        //     val m = list
        // } else {

        // }
        val newMax = list.max
        val newList = list.filter(_ != newMax)
        //println(acc)
        if (acc < list.length - 1 && acc >= 0) {
          // println(current)
          current match {
            case x if (x == newMax && acc > 0) => acc
            case x if (x < max && acc < list.length - 1) => helper(newList, newList(acc + 1), newList(acc), newMax, acc + 1)
            case _ => helper(list.filter(_ != list.max), m(acc + 1), m(acc), newMax, acc + 1)
            //case x if x < prev => helper(list.indexOf(prev) + 1, list(acc), max, acc + 1)
          }
          // helper(m(acc + 1), m(acc), m.max, acc + 1)
        } else {
          acc
        }
        // if (acc > 0) {
        //     helper(list(acc - 1), list(acc), max, acc - 1)
        // } else {
        //     acc
        // }
        // helper(m(acc), m(acc), m.max, acc)
      }

      helper(m, m(0), 0, m.max, 0)
      //list.map((x: Int, y: Int) => x.compareTo(y))
    }

    println(getMountainMax())
  }
}
