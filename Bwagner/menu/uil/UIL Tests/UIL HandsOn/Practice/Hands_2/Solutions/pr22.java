import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr22
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr22.dat"));
      String [] s = kb.nextLine().split(" ");
      int times = s.length;
      for(int z = 0; z < times; z++) {
      	int num = Integer.parseInt(s[z]);
      	out.print("0");
       	for(int i = 1; i <= num; i++)
      		if(i % 10 == 0)	
      			out.print("0");
      		else if (i % 5 == 0)	
      			out.print("5");
      		else
      			out.print("-");
      	out.println();
      }	
   }
}

