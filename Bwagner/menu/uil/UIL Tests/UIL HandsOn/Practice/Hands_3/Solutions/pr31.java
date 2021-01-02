import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr31
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr31.dat"));
      int times = Integer.parseInt(kb.nextLine().trim());
      for(int z = 0; z < times; z++) {
      	int rows = Integer.parseInt(kb.nextLine().trim());
      	int m[][] = new int[rows][rows];

      	for(int r = 0; r < rows; r++) {
      		String s[] = kb.nextLine().split(" ");   // get one row
      		for(int c = 0; c < rows; c++)
      			m[r][c] = Integer.parseInt(s[c]);	 // convert to ints
      	}
      	
      	for(int r = 0; r < rows; r++) {
      		for(int c = 0; c < rows; c++)		// right justify in 3 chars
      			out.printf("%3d", m[c][r]);     // switch rows and cols
      		out.println();
      	}
      	out.println();
      }
   }
}

