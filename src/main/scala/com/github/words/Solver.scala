package com.github.words

import scala.collection.JavaConversions._

object Solver {
  
  def main( args : Array[String] ) : Unit = {
    Console.println("solver...")
    
    val w = "qwertyuytresdftyuioknn"  
    findWords( w ).foreach( Console.println( _ ) ) 
  }
  
  
  def findWords( word : String ) = { 
    matchWords( word, findPossibles( word ) )
  }
  
  def findPossibles( word : String ) = {
    
    Dictionary.lookup( word(0) ).filter(
      (s) => { word.head == s.head && word.last == s.last && s.length >= 5 }
    ).toList
  }
  
  def matchWords( word : String, possibles : List[String] ) = {
    possibles.filter( (p) => { matchWord( word, p ) } )
  }
  
  def matchWord( w : String, possible : String ) : Boolean = {
    
    var word = new StringBuffer(w); 
    
    val ps = possible.map( (c) => {
      val pos = word.toString().indexOf(c)
      if( pos < 0 ){
        pos
      }
      else {
        word = word.delete(0, pos)
        pos
      }
    })
    
    ps.forall( (i) => { i >= 0 }) 
  }
}