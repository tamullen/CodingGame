import math._
import scala.util._
import scala.io.StdIn._

/**
 * The while loop represents the game.
 * Each iteration represents a turn of the game
 * where you are given inputs (the heights of the mountains)
 * and where you have to print an output (the index of the mountain to fire on)
 * The inputs you are given are automatically updated according to your last actions.
 **/
object Player extends App {
  // game loop
  def getMountainMax(): Int = {
    def helper(current: Int, acc: Int): Int = {

      val newList = List(readLine.toInt, readLine.toInt, readLine.toInt, readLine.toInt, readLine.toInt, readLine.toInt, readLine.toInt, readLine.toInt)
      val newMax = newList.max
      if (acc < newList.length) {
        newList(current) match {
          case x if (x == newMax) => {
            println(newList.indexOf(newMax))
            helper(current + 1, acc + 1)
          }
          case x if (x < newMax && current >= 1) => {
            println(newList.indexOf(newMax))
            helper(current - 1, acc)
          }
          case _ => {
            println(newList.indexOf(newMax))
            helper(current + 1, acc + 1)
          }
        }
      } else {
        helper(newList.indexOf(newMax), acc)
      }
    }
    helper(0, 0)
  }
  getMountainMax()
}