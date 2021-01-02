import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr59
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr59.dat"));
      int times = Integer.parseInt(kb.nextLine().trim());
      for(int z = 0; z < times; z++)  {
	      String[] s = kb.nextLine().trim().split(" ");
	      int rows = Integer.parseInt(s[0]);
	      int cols = Integer.parseInt(s[1]);
	      for(int i = 0; i < rows; i++) {
	      	int [] r = new int[cols];
	      	String[] t = kb.nextLine().trim().split(" ");
	      	for(int j = 0; j < cols; j++)  	// row into array
	      		r[j] = Integer.parseInt(t[j]);
	      	Arrays.sort(r);					// sort the row
		    for(Integer c : r) 				// print the row
		   	    out.printf("%4d",c);
		    out.println();
		  }
		  out.println();
	  }
   }
}

