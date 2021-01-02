import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr12
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr12.dat"));
      int times = Integer.parseInt(kb.nextLine());
      for(int z = 0; z < times; z++) {
      	String s[] = kb.nextLine().split(" ");
      	String color = s[0];
      	double sqFeet = (Double.parseDouble(s[1]) * Double.parseDouble(s[2]));
      	sqFeet -= Double.parseDouble(s[3]);
      	int gallons = (int)Math.ceil(sqFeet/300);
   		out.println(s[0] + " " + gallons + " GALLON(S)");
      }
      
   }
}

