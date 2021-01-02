import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr16
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr16.dat"));
      int times = Integer.parseInt(kb.nextLine());
      for(int z = 0; z < times; z++) {
      	double cost = Double.parseDouble(kb.nextLine()); 
      	if(cost > 100)
      		cost *= .85;
      	else if (cost > 50)
      		cost *= 1.1;
      	else
      		cost += 5;
      	out.printf("$%.2f\n", cost);
      }	
   }
}

