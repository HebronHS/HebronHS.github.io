import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr26
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr26.dat"));
      int times = Integer.parseInt(kb.nextLine());
      for(int z = 0; z < times; z++) {
      	String code = kb.nextLine();			// code key
      	String s = kb.nextLine();				// line to decode
      	for(int i = 0; i < s.length(); i++) {
       		if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')  // check range
      			out.print(('A' + code.indexOf(s.charAt(i)))); 
			else
				out.print(s.charAt(i));
      	}
      	out.println();
      }	
   }
}

