import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Dictionary {
	
	private static final Dictionary instance ;
	
	static {
		instance = load("./resources/enable1.txt");
	}
	
	public static List<String> dictionary(){
		return new ArrayList<String>(instance.words);
	}

	public List<String> words = new ArrayList<String>();

	private static Dictionary load(String file) {
		
		Dictionary dict = new Dictionary();
		
		dict.words = new ArrayList<String>();

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
				dict.words.add(line);
			}

			br.close();

		} catch (Exception e) {
			String msg = "Unepected error reading file:" + e.getMessage();
			System.out.println(msg);
			throw new IllegalStateException(msg);
		}
		
		return dict;
	}

}
