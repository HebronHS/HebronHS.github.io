import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr35
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr35.dat"));
      int times = Integer.parseInt(kb.nextLine().trim());
      for(int z = 0; z < times; z++) {
      	String t[] = kb.nextLine().trim().split(" ");
      	int rows = Integer.parseInt(t[0]) + 1; // increase rows and cols to hold sums
      	int cols = Integer.parseInt(t[1]) + 1;	
      	int m[][] = new int[rows][cols];	
      	for(int r = 0; r < rows-1; r++) {
      		String s[] = kb.nextLine().split(" ");   // get one row
     		int sum = 0;
      		for(int c = 0; c < cols-1; c++) { 		 // add elements in that row
      			m[r][c] = Integer.parseInt(s[c]);	 // convert to ints
      			sum += m[r][c];						 
 			}
 			m[r][cols-1] = sum;	
      	}
      	for(int c = 0; c < cols; c++) {
      		int sum = 0;
      		for(int r = 0; r < rows-1; r++) {		 // add elements in that col
       			sum += m[r][c];						
 			}
 			m[rows-1][c] = sum;	
      	}	
      	for(int r = 0; r < rows; r++) {
      		for(int c = 0; c < cols; c++)			// right justify in 4 chars
      			out.printf("%4d", m[r][c]);     
      		out.println();
      	}
      	out.println();
      }
   }
}

