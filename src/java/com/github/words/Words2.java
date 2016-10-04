import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/*
 * https://dzone.com/articles/java-code-challenge-wandering-fingers?utm_medium=feed&utm_source=feedpress.me&utm_campaign=Feed:%20dzone%2Fjava
 */
public class Words2 {


  public static void main( String[] args ){
    System.out.println( "words..." );
    // qwertyuytresdftyuioknn
    // gijakjthoijerjidsdfnokg
    
    String word1 = "qwertyuytresdftyuioknn" ;
    String word2 = "gijakjthoijerjidsdfnokg" ;
    
    // get the first and last char
    
    long start = (new Date()).getTime();
    
    Stream<String> possibles = findPossibles(word2);
    Stream<String> words = findWords(possibles, word2 );
    
    long stop = (new Date()).getTime();
    
    words.forEach( (w) -> { System.out.println(w); });

    System.out.println( stop - start );
  }
  
  public static Stream<String> findPossibles( String word ){
	  
	  return Dictionary.dictionary().stream().filter(
	    (p) -> {
	    	return matchEnds( word.charAt(0), word.charAt(word.length()-1), p);
	    }
	  );
  }
  
  public static boolean matchEnds( char begin, char end, String w ){
      return ( begin == w.charAt(0)) && ( end == w.charAt(w.length()-1) && w.length() >= 5); 
  }
  
  public static Stream<String> findWords( Stream<String> possibles, String word ){
	  return possibles.filter( (p) -> { return matchWord( word, p ); });
  }
  
  public static boolean matchWord( String word, String possible ){
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
