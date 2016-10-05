
public class SBTest {
	
	public static void main( String[] args ){
		
		StringBuffer sb = new StringBuffer( "0123456789");
		sb.delete(0, 4);
		System.out.println(sb.toString());
	}

}
