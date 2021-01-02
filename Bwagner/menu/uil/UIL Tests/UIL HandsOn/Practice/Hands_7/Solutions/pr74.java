import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr74
{
	public static void main (String[] args) throws IOException
	{
		Scanner kb = new Scanner(new File("pr74.dat"));
		int times = Integer.parseInt(kb.nextLine().trim());
		for(int z = 0; z < times; z++)  {  
			String[] s = kb.nextLine().trim().split(" ");
			for(int i = 0; i < s.length; i++) 
				if(i % 2 == 0)	{   // odd position word 1st, 3rd, ... words
					StringBuffer word = new StringBuffer(s[i]);
 					out.print(word.reverse() + " "); 	 
				}	  
			else {			        // even position word 2nd, 4th, ... words
				String word = s[i];
				int len = word.length();
	 			if(len==i)		// length is one more than the position
					word = word.substring(len-1) + word.substring(0,len-1);
				else if(len == i+1)  // length and position in sentence are the same
					word = word.substring(i+1) + word.substring(0,i+1);
				else if(len > i+1)  // length is greater than the position
					word = word.substring(len-i-1) + word.substring(0,len-i-1);
				// is length is less than positon, there is no change
				out.print(word + " ");
			}
			out.println();	  	  
		}
	}
}

