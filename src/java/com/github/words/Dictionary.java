import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {
	
	private static final List<String> words ;
	private static final Map<Character,List<String>> wordIndex ;

	static {
		words = load("./resources/enable1.txt");
		wordIndex = index(words);
	}
	
	public static List<String> dictionary(){
		return new ArrayList<String>(words);
	}
	
	public static List<String> lookup( Character c ){
		List<String> words = wordIndex.get(c);
		
		if( words == null ){
			return new ArrayList<String>();
		}
		
		return words;
	}


	private static List<String> load(String file) {
		
		List<String> words = new ArrayList<String>();

		// open the file
		File f = new File("./resources/enable1.txt");

		if (!f.exists()) {
			String msg = "file not found:" + f;
			System.out.println(msg);
			throw new IllegalStateException(msg);
		}

		try {
			BufferedReader br = new BufferedReader(new FileReader(f));

			for (String line = br.readLine(); line != null; line = br.readLine()) {
				words.add(line);
			}

			br.close();

		} catch (Exception e) {
			String msg = "Unepected error reading file:" + e.getMessage();
			System.out.println(msg);
			throw new IllegalStateException(msg);
		}
		
		return words;
	}
	
	private static Map<Character,List<String>> index( List<String> words ) {
		
		Map<Character,List<String>> wordIndex = new HashMap<Character,List<String>>();
		
		for( String word : words ){
			
			Character c = Character.valueOf( word.charAt(0)) ;
			
			List<String> list = wordIndex.get(c);
			if( list == null ){

				list = new ArrayList<String>();
				wordIndex.put(c, list);
			}
			
			list.add(word);
			
		}
		
		return wordIndex ;
		
	}

}
