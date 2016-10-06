package com.github.words

import org.junit.Test
import scala.collection.mutable.HashMap
import scala.collection.mutable.ListBuffer
import org.junit.Assert.assertTrue
import java.util.Date

class WordzTest {
  
  def testData = makeData()
  
  def makeData() = { 
    val testData = new HashMap[String, List[String]]();

    val w1 = ListBuffer[String]();
    w1 += "queen" ;
    w1 += "question" ;

    testData += ( "qwertyuytresdftyuioknn" -> w1.toList )

    val w2 = ListBuffer[String]();
    w2 += "gaeing" 
    w2 += "garring" 
    w2 += "gathering"
    w2 += "gating" 
    w2 += "geeing" 
    w2 += "gieing" 
    w2 += "going" 
    w2 += "goring" 

    testData += ( "gijakjthoijerjidsdfnokg" -> w2.toList )
    
    testData
    
  }
  
  @Test
  def test_scala() : Unit = {
    
    testData.foreach(
      ( entry ) => {
    
        val start = ( new Date() ).getTime()
        val matches = Solver.findWords(entry._1)
        val end = ( new Date() ).getTime()

        Console.println( end - start );

        assertTrue( "should find matches", ( matches != null ) && ( matches.size == entry._2.size ) )

        entry._2.foreach( (s) => { assertTrue( "should contain " + s, matches.contains( s ) ) } )
    })
  }
  
}