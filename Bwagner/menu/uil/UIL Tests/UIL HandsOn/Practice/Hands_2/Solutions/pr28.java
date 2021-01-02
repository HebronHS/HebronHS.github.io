import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr28
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr28.dat"));
      int times = Integer.parseInt(kb.nextLine());
      for(int z = 0; z < times; z++) {
      	String []s = kb.nextLine().split(" ");	
      	char a = s[0].charAt(0);
      	int n = Integer.parseInt(s[1]);		
      	for(int i = 0; i < n; i++)  
       		out.print((char)('A' + (a - 'A' + i) % 26 ));
       	out.println();
      }	
   }
}

