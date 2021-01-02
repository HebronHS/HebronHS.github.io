import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr37
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr37.dat"));
      int times = Integer.parseInt(kb.nextLine().trim());
      for(int z = 0; z < times; z++) {
      	String t[] = kb.nextLine().trim().split(" ");
      	int rows = Integer.parseInt(t[0]); // increase rows and cols to hold sums
      	int cols = Integer.parseInt(t[1]);	
      	int m[][] = new int[rows][cols];	// first matrix
      	int n[][] = new int[rows][cols];	// second matrix
      	int a[][] = new int[rows][cols];	// answer matrix
      	for(int r = 0; r < rows; r++) {				// fill matrix m
      		String s[] = kb.nextLine().split(" ");   
      		for(int c = 0; c < cols; c++)  		 
      			m[r][c] = Integer.parseInt(s[c]);	 
      	}
      	for(int r = 0; r < rows; r++) {				// fill matrix n
      		String s[] = kb.nextLine().split(" ");   
      		for(int c = 0; c < cols; c++) 		 
      			n[r][c] = Integer.parseInt(s[c]);	 					 
      	}
      	for(int r = 0; r < rows; r++) {			// fill matrix a with sum of corresponding elements
      		for(int c = 0; c < cols; c++) 	
       			a[r][c] = m[r][c] + n[r][c];						
      	}	
      	for(int r = 0; r < rows; r++) {			// print matrix a
      		for(int c = 0; c < cols; c++)		// right justify in 4 chars
      			out.printf("%4d", a[r][c]);     
      		out.println();
      	}
      	out.println();
      }
   }
}

