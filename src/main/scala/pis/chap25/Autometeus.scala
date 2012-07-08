package pis.chap25

import java.io.BufferedReader
import java.io.FileReader
import scala.collection.immutable.HashMap
import com.codahale.jerkson.Json.stream

object Autometeus extends App {
  
  def getTarget(input:String, title:String):String = {
    var tokens = input.split(" ")
    for (token <- tokens) {
    	val idx = title.indexOf(token)
    	if (idx != -1) return title.substring(title.indexOf(token))
    }
    return title
  }
  
  override def main(args: Array[String]) = {

    val reader = new BufferedReader(new FileReader("movies.json"))
    if (args.length == 0) {
      println("영화 제목을 입력해 주세요.")
      exit()
    }
    var input: String = args.mkString(" ")
    var output = HashMap[String, Int]()
    
    var minDistance:Int = Int.MaxValue
    for (movie <- stream[Movie](reader)) {
      
      var title = movie.Title.toLowerCase
      var target = getTarget(input, title)
      
      var distance = StringDistance.stringDistance(input, target)
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
