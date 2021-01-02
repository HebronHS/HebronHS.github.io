import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr76
{
	public static void main (String[] args) throws IOException
	{
		Scanner kb = new Scanner(new File("pr76.dat"));
		String s = kb.nextLine().trim(); 
		int i = s.length();
		int lastSpace = 0;			// last space in substring t
		int lettersUsed = 0;		// number of letters used from s
		out.println("1234567890123456789012345678901234567890");
		while(i - lettersUsed > 40) {
			// get first group of 40 characters
			String t = s.substring(lettersUsed,lettersUsed + 40);
			lastSpace = t.lastIndexOf(" ");		// find last space
			lettersUsed += lastSpace+1;			// count the letters used
			t = t.substring(0,lastSpace);		// trim letters after the last space from t
			StringBuffer sb = new StringBuffer(t);
			int sp = 0;	
			while(sb.length() < 40) {			// insert spaces between words as necessary
				sp = sb.indexOf(" ",sp);		
				sb.insert(sp+1 ,' ');
				sp+=2;	
			}
			out.println(sb);	
		}
		out.println(s.substring(lettersUsed));	
	}
}

