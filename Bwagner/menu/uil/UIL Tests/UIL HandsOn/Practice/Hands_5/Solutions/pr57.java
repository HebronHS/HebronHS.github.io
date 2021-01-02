import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr57
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr57.dat"));
      int times = Integer.parseInt(kb.nextLine().trim());
      String[] t = new String[times];
      for(int z = 0; z < times; z++)  {
	      String s = kb.nextLine().trim();
	      int space = s.lastIndexOf(" ");
	      String name = s.substring(space+1) + ", " + s.substring(0,space);
	      t[z] = name;	
	  }	
	  	  Arrays.sort(t);			// sorts list
	      for(String i : t) 		// prints names
	      	 out.println(i);
	}
}

