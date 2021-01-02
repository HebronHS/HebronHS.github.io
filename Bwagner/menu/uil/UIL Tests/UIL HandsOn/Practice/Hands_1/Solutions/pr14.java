import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr14
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr14.dat"));
      int times = Integer.parseInt(kb.nextLine());
      for(int z = 0; z < times; z++) {
      	String s[] = kb.nextLine().split(" "); 
      	int index = 0;
      	for(int grade = 9; grade <= 12; grade++) {
      		double total = Double.parseDouble(s[index++]);
      		double present = total - Double.parseDouble(s[index++]);
      		out.printf("%.1f", present / total * 100);
      		out.println("% PRESENT IN GRADE " + grade);
      	}
      	out.println();
      }	
   }
}

