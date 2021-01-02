import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr49
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr49.dat"));
      int times = Integer.parseInt(kb.nextLine().trim());
      for(int z = 0; z < times; z++)  {     	
      	  String[] s = kb.nextLine().trim().split(" "); 
      	  int rows = Integer.parseInt(s[0]);			  
      	  int cols = Integer.parseInt(s[1]);
      	  int size = cols - rows + 1;
      	  int [][] m = new int[size][size];
      	  for(int i = 0; i < size; i++) {
      	  	int c = i;
      	  	for(int j = i; j < size; j++) {
      	  		m[i][j] = rows;
      	  		m[j][c] = rows;
      	  		
      	  	}c++;
      	  	rows++;
      	  }
      	  for(int i=0; i<m.length; i++) {
      	  	for(int j=0; j<m.length; j++)
      	  		out.print(m[i][j]);
      	  	out.println();
      	  }
      	  out.println();
      }	
   }
}

