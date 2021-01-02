import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr48
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr48.dat"));
      int times = Integer.parseInt(kb.nextLine().trim());
      for(int z = 0; z < times; z++) {
       	String[] s = kb.nextLine().trim().split(" ");
      	int rows = Integer.parseInt(s[1]);
      	int cols = Integer.parseInt(s[2]);
      	// top of ELL
       	for(int i = 0; i < rows; i++) {	
      		for(int j=0; j<cols; j++)
      			out.print(s[0].charAt(0));
      		out.println();
      	}
		// bottom of ELL 
       	for(int i = 0; i < cols; i++) {	
      		for(int j=0; j<rows+cols; j++)
      			out.print(s[0].charAt(0));
      		out.println();
      	}
       	out.println();
      }	
   }
}

