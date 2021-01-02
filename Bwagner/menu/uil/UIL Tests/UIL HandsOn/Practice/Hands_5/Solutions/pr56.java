import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr56
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr56.dat"));
      int times = Integer.parseInt(kb.nextLine().trim());
      for(int z = 0; z < times; z++)  {
	      String[] s = kb.nextLine().trim().split(" ");
	      int[] a = new int[s.length];
	      for(int i = 0; i < a.length; i++) // parse to ints
	      	 a[i] = Integer.parseInt(s[i]);
	      Arrays.sort(a);					// sort array

	      for(int i = 0; i < a.length; i+=2) // print even numbered elements
	      	 out.print(a[i]+" ");
		  int start = a.length-1;			// start at end
	      if(a.length % 2 == 1)
	      	 start--; 
	      for(int i = start; i > 0; i-=2) // print odd numbered elements reversed
	      	 out.print(a[i]+" ");
	      
	      out.println();
	   }
	}
}

