import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr42
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr42.dat"));
      String []s = kb.nextLine().split(" ");	
      int times = Integer.parseInt(s[0]);
      for(int z = 0; z < times; z++) {
      	int rows = Integer.parseInt(s[z+1]);
      	String blanks = "                                ";
      	int numSpaces = rows - 1;
      	char a = 'A';
      	for(int i = 0; i < rows; i++) {	
      		out.print(blanks.substring(0,numSpaces--));  // decrease for next iteration
      		for(int j = 0; j < 2*i+1; j++)  
       			out.print(a);
       		out.println();
       		a++;
       	}
       	out.println();
      }	
   }
}

