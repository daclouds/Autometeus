package pis.chap25

import java.io.BufferedReader
import java.io.FileReader

import scala.collection.immutable.HashMap

import com.codahale.jerkson.Json.stream

object Autometeus extends App {
  override def main(args: Array[String]) = {

    val reader = new BufferedReader(new FileReader("movies.json"))

    //    Le jour avant le lendemain
    var input: String = "Le      avant    lendemain"
    var output = HashMap[String, Int]()
    
    var minDistance:Int = Int.MaxValue
    for (movie <- stream[Movie](reader)) {
      var distance = StringDistance.stringDistance(input, movie.Title)
      if (distance < minDistance) {
        output += (movie.Title -> distance)
        output.toSeq.sortBy(_._2)
        if (output.toSeq.sortBy(_._2).first._2 < minDistance) {
          minDistance = output.toSeq.sortBy(_._2).first._2
          println(output.toSeq.sortBy(_._2).first._1)
        }
      }
    }
  }
}