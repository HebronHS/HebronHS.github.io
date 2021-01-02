import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr15
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr15.dat"));
      int times = Integer.parseInt(kb.nextLine());
      for(int z = 0; z < times; z++) {
      	String s[] = kb.nextLine().split(" "); 
      	int len = Integer.parseInt(s[0]) * 12;  // convert feet to inches
      	int width = Integer.parseInt(s[1]) * 12;
      	int depth = Integer.parseInt(s[2]) * 12;
      	long gallons = Math.round(len * width * depth / 231.);
      	out.println(gallons + " GALLONS");
      }	
   }
}

