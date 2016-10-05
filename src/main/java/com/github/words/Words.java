package com.github.words;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * https://dzone.com/articles/java-code-challenge-wandering-fingers?utm_medium=feed&utm_source=feedpress.me&utm_campaign=Feed:%20dzone%2Fjava
 */
public class Words {


  public static List<String> findMatches( String word ){
	  return findWords( findPossibles(word), word );
  }
  
  private static List<String> findPossibles( String word  ){
	  
    // get the first and last char
    char begin = word.charAt(0);
    char end = word.charAt(word.length() - 1);

    List<String> possibles = new ArrayList<String>(); 
    
    
    for( String w : Dictionary.lookup( Character.valueOf(begin) ) ){
    	if( ( begin == w.charAt(0)) && ( end == w.charAt(w.length()-1)) && w.length() >= 5 ){
    		possibles.add(w);
    	}
    }
    
    
    return possibles ;
  }
  
  
  private static List<String> findWords( List<String> possibles, String word ){
	  
    List<String> words = new ArrayList<String>();
	  
	for( String p : possibles ){
		if( matchWord( word, p )){
			words.add(p);
		}
	}
	  
	return words;

  }
  
  private static boolean matchWord( String word, String possible ){
	  // make sure the first and last match
	  
	  int posInWord = 0;
	  for( int posInPos = 0; posInPos < possible.length(); posInPos++ ){
		char c = possible.charAt(posInPos);
		
		posInWord = word.indexOf(c,posInWord);
		if( posInWord == -1 ){
			return false;
		}
	  }

	  return true;
  }

}
