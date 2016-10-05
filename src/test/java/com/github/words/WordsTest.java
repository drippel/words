package com.github.words;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class WordsTest {
	
	public static final Map<String, List<String>> testData ;
	static {
		
		testData = new HashMap<String,List<String>>();
		
		List<String> w1 = new ArrayList<String>();
		w1.add("queen");
		w1.add("question");
		
		testData.put( "qwertyuytresdftyuioknn", w1 );
		
		List<String> w2 = new ArrayList<String>();
		w2.add("gaeing");
      w2.add("garring");
      w2.add("gathering");
      w2.add("gating");
      w2.add("geeing");
      w2.add("gieing");
      w2.add("going");
      w2.add("goring");
		
	  testData.put( "gijakjthoijerjidsdfnokg", w2 );
	}
	
	@Test
	public void test_words_old_school() {
		
		for( Entry<String,List<String>> entry : testData.entrySet() ){
		
			long start = (new Date()).getTime();
          List<String> matches = Words.findMatches(entry.getKey());
			long end = (new Date()).getTime();
			
			System.out.println( end - start);
      
          assertTrue( "should find matches", matches != null && matches.size() == entry.getValue().size() );
          
          for( String w : entry.getValue() ){
            assertTrue( "should contain " + w, matches.contains(w) );
          }
		}

	}

	@Test
	public void test_words_streamy() {
		
		for( Entry<String,List<String>> entry : testData.entrySet() ){
		
			long start = (new Date()).getTime();
          List<String> matches = Words2.findMatches(entry.getKey()).collect(Collectors.toList() );
			long end = (new Date()).getTime();
			
			System.out.println( end - start);
      
          assertTrue( "should find matches", matches != null && matches.size() == entry.getValue().size() );
          
          for( String w : entry.getValue() ){
            assertTrue( "should contain " + w, matches.contains(w) );
          }
		}

	}
	
}
