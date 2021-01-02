import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr77
{
	public static void main (String[] args) throws IOException
	{
		Scanner kb = new Scanner(new File("pr77.dat"));
		int times = Integer.parseInt(kb.nextLine().trim());
		for(int z = 0; z < times; z++)  {  
			String s = kb.nextLine().trim();
			String first="", second="";
			for(int i=0; i<s.length(); i++) {
				char ch = s.charAt(i);
				if(ch >= 'A' && ch < 'N') {    // letters less than N
					first+=ch;
					second+=' ';
				}
				else if(ch > 'M' && ch <= 'Z') { // letters greater than N
					first+=' ';
					second+=ch; 
				}
				else {							// non-letters
					first+=ch;
					second+=ch;	
				}
			}
			out.println(first);
			out.println(second);
			out.println();
	   	}	
	}
}

