import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr53
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr53.dat"));
      int times = Integer.parseInt(kb.nextLine());
      for(int z = 0; z < times; z++) {
      	String []s = kb.nextLine().split(" ");	
      	TreeSet<String>	a = new TreeSet<String>();		
      	for(int i = 0; i < s.length; i++)  
       		if(s[i].length() == 4)      // found a four letter word
      			a.add(s[i]);
			else						// not a four letter word
				out.print(s[i] + " ");
		out.println();		
		for(String k : a)
			out.println(k);
      	out.println();
      }	
   }
}

