import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr72
{
	public static void main (String[] args) throws IOException
	{
		Scanner kb = new Scanner(new File("pr72.dat"));
		int times = Integer.parseInt(kb.nextLine().trim());
		for(int z = 0; z < times; z++)  {  
			StringBuffer s = new StringBuffer(kb.nextLine().trim());
			int len = s.length();
 			int spot = 0; 
			while(!isPalindrome(s)) {
				s.insert(len, s.charAt(spot)); 
				spot++;
			}
			out.println(s);
	   	}	
	}
	private static boolean isPalindrome(StringBuffer p) {
	  	int i = 0;  
	  	while(i<p.length()/2) {
	  	  	if(p.charAt(i) != p.charAt(p.length()-i-1))
	  	  	  	return false;		// found non-matching letters
	  	  	i++;
	  	}
	  	return true;
	}
}

