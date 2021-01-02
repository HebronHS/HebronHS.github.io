import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr01
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr01.dat"));
      int times = Integer.parseInt(kb.nextLine().trim());
      for(int z = 0; z < times; z++) {
      	String[] s = kb.nextLine().trim().split(" ");  	// *2
      	int sum = 0;
      	for(int i=0; i<4; i++)
      		sum += Integer.parseInt(s[i]);    		// *3
      	out.println("PERIMETER = " + sum);
      }
   }
}
