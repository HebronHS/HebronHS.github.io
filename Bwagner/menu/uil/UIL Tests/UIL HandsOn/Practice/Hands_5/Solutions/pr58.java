import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr58
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr58.dat"));
      int times = Integer.parseInt(kb.nextLine().trim());
      TreeMap<String, String> t = new TreeMap<String, String>();
      for(int z = 0; z < times; z++)  {
	      String s = kb.nextLine().trim();
	      String key = "" + s.charAt(1) + s.charAt(3);   // create key of 2nd and 4th chars
	      	      t.put(key, s);	// this will sort by key
	  }
	  Set<String> k = t.keySet();	// set of keys to iterate through
	  for(String i : k) 			// print TreeMap
	     	 out.println(t.get(i));
	}
}

