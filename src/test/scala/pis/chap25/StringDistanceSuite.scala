/*
 * http://oldfashionedsoftware.com/2009/11/19/string-distance-and-refactoring-in-scala/
 */
package pis.chap25

import org.scalatest._

class StringDistanceSuite extends FunSuite with PrivateMethodTester {

  test("stringDistance should work on empty strings") {
    assert( StringDistance.stringDistance(   "",    "") == 0 )
    assert( StringDistance.stringDistance(  "a",    "") == 1 )
    assert( StringDistance.stringDistance(   "",   "a") == 1 )
    assert( StringDistance.stringDistance("abc",    "") == 3 )
    assert( StringDistance.stringDistance(   "", "abc") == 3 )
  }

  test("stringDistance should work on equal strings") {
    assert( StringDistance.stringDistance(   "",    "") == 0 )
    assert( StringDistance.stringDistance(  "a",   "a") == 0 )
    assert( StringDistance.stringDistance("abc", "abc") == 0 )
  }

  test("stringDistance should work where only inserts are needed") {
    assert( StringDistance.stringDistance(   "",   "a") == 1 )
    assert( StringDistance.stringDistance(  "a",  "ab") == 1 )
    assert( StringDistance.stringDistance(  "b",  "ab") == 1 )
    assert( StringDistance.stringDistance( "ac", "abc") == 1 )
    assert( StringDistance.stringDistance("abcdefg", "xabxcdxxefxgx") == 6 )
  }

  test("stringDistance should work where only deletes are needed") {
    assert( StringDistance.stringDistance(  "a",    "") == 1 )
    assert( StringDistance.stringDistance( "ab",   "a") == 1 )
    assert( StringDistance.stringDistance( "ab",   "b") == 1 )
    assert( StringDistance.stringDistance("abc",  "ac") == 1 )
    assert( StringDistance.stringDistance("xabxcdxxefxgx", "abcdefg") == 6 )
  }

  test("stringDistance should work where only substitutions are needed") {
    assert( StringDistance.stringDistance(  "a",   "b") == 1 )
    assert( StringDistance.stringDistance( "ab",  "ac") == 1 )
    assert( StringDistance.stringDistance( "ac",  "bc") == 1 )
    assert( StringDistance.stringDistance("abc", "axc") == 1 )
    assert( StringDistance.stringDistance("xabxcdxxefxgx", "1ab2cd34ef5g6") == 6 )
  }

  test("stringDistance should work where many operations are needed") {
    assert( StringDistance.stringDistance("example", "samples") == 3 )
    assert( StringDistance.stringDistance("sturgeon", "urgently") == 6 )
    assert( StringDistance.stringDistance("levenshtein", "frankenstein") == 6 )
    assert( StringDistance.stringDistance("distance", "difference") == 5 )
    assert( StringDistance.stringDistance("java was neat", "scala is great") == 7 )
  }

}