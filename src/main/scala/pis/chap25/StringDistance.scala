/*
 * http://oldfashionedsoftware.com/2009/11/19/string-distance-and-refactoring-in-scala/
 */
package pis.chap25

object StringDistance {
  def stringDistance(s1: String, s2: String): Int = {
    val memo = scala.collection.mutable.Map[(List[Char], List[Char]), Int]()
    def min(a: Int, b: Int, c: Int) = Math.min(Math.min(a, b), c)
    def sd(s1: List[Char], s2: List[Char]): Int = {
      if (memo.contains((s1, s2)) == false)
        memo((s1, s2)) = (s1, s2) match {
          case (_, Nil) => s1.length
          case (Nil, _) => s2.length
          case (c1 :: t1, c2 :: t2) => min(sd(t1, s2) + 1, sd(s1, t2) + 1,
            sd(t1, t2) + (if (c1 == c2) 0 else 1))
        }
      memo((s1, s2))
    }

    sd(s1.toList, s2.toList)
  }
}