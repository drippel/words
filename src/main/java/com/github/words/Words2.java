package com.github.words;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * https://dzone.com/articles/java-code-challenge-wandering-fingers?utm_medium=feed&utm_source=feedpress.me&utm_campaign=Feed:%20dzone%2Fjava
 */
public class Words2
{

  public static Stream<String> findMatches( String word )
  {

    return findWords( findPossibles( word ), word );
  }

  private static Stream<String> findPossibles( String word )
  {

    // return Dictionary.dictionary().stream()
    return Dictionary.lookup( Character.valueOf( word.charAt( 0 ) ) ).stream()
      .filter( ( p ) -> { return word.charAt( 0 ) == p.charAt( 0 ); } )
      .filter( ( p ) -> { return word.charAt( word.length() - 1 ) == p.charAt( p.length() - 1 ); } )
      .filter( ( p ) -> { return p.length() >= 5; } );
  }

  private static Stream<String> findWords( Stream<String> possibles, String word )
  {
    return possibles.filter( ( p ) -> { return matchWord( word, p ); } );
  }

  private static boolean matchWord( String w, String possible )
  {

    StringBuffer word = new StringBuffer( w );

    IntStream positions = possible.chars().map( ( c ) -> {

      int posInWord = word.toString().indexOf( c, 0 );
      if( posInWord == -1 )
      {
        return -1;
      }
      else
      {
        word.delete( 0, posInWord );
        return posInWord;
      }
    } );

    return !positions.filter( ( i ) -> { return i == -1; } ).findFirst().isPresent();

  }

}
