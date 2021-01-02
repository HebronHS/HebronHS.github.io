import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr79 {
	private static char [][]m;
	public static void main (String[] args) throws IOException 	{
		Scanner kb = new Scanner(new File("pr79.dat"));
		String [] censor = kb.nextLine().trim().split(" ");
		String stars = "****************************************";
		for(int i=0; i<censor.length; i++)
			censor[i] = censor[i].length() + censor[i];	// concatenate length to front of string
		Arrays.sort(censor);							// sort from low to high by length
		for(int i=0; i<censor.length; i++)
			censor[i] = censor[i].substring(1);			// remove length from front of string
		while(kb.hasNext()) 	{
			StringBuffer line = new StringBuffer(kb.nextLine().trim());
			for(int i = censor.length-1; i>=0; i--)	{	// start with longest censored word
				String c = censor[i].toString().toLowerCase();   // change to lowercase Strings
				String ln = line.toString().toLowerCase();
				boolean done = false;
				int start = 0;
				while(!done) {									// check for repeated words
					int index = ln.indexOf(c, start); 
					if(index >= 0){								// replace censored word with *'s
						int len = censor[i].length();
						line.replace(index, index+len, stars.substring(0,len));
						start = index+len;
					}
					else				// no more instances of that word
						done = true;
				}
			}
		out.println(line);	
	   	}
	   		
	}
}

