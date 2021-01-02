import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr17
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr17.dat"));
      int times = Integer.parseInt(kb.nextLine());
      for(int z = 0; z < times; z++) {
      	String s[] = kb.nextLine().split(" ");
      	double dd = Double.parseDouble(s[7]);   // degree of difficulty
      	double max = Double.parseDouble(s[0]);
      	double min = Double.parseDouble(s[0]);
      	double sum = Double.parseDouble(s[0]);
      	for(int i = 1; i < 7; i++) {
      		double temp = Double.parseDouble(s[i]);
      		sum += temp;
      		max = Math.max(max, temp);
      		min = Math.min(min, temp);
      	}
      	double average = (sum - max - min) * dd / 5;	 
      	out.printf("%.3f\n", average);
      }	
   }
}

