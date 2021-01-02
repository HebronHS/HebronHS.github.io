import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr18
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr18.dat"));
      String s[] = kb.nextLine().trim().split(" ");
      int times = Integer.parseInt(s[0]);
      for(int z = 0; z < times; z++) {
      	int count = Integer.parseInt(s[z+1]);
      	out.println("ROUNDING IS FUN");
      	for(int i = 1; i <= count; i++) 
      		// %3d is i right justified in 3 columns
      		// %6.1f is Math.pow(i,.5) right justified in 6 columns with 1 decimal place
      		// %8.2f is Math.pow(i,1/3) right justified in 8 columns with 2 decimal places
      		out.printf("%3d%6.1f%8.2f\n",i,Math.pow(i,.5),Math.pow(i,1/3.0));
      out.println();
      }	
   }
}

