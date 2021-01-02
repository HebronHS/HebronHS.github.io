import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr11
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr11.dat"));
      int times = Integer.parseInt(kb.nextLine());
      for(int z = 0; z < times; z++) {
      	String s[] = kb.nextLine().split(" ");
      	double gallons = Double.parseDouble(s[0]);
      	double difference = gallons * 
      						(Double.parseDouble(s[1]) - Double.parseDouble(s[2]));
      	if(difference < 0)
      		out.printf("SAVED: $%.2f\n", Math.abs(difference));
      	else if(difference > 0)
      		out.printf("PAID MORE: $%.2f\n", difference);
      	else 
      		out.println("PAID THE SAME");
      }
      
   }
}

