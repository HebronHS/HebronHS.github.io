import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr38
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr38.dat"));
      int times = Integer.parseInt(kb.nextLine().trim());
      for(int z = 0; z < times; z++) {
      	String t[] = kb.nextLine().trim().split(" ");
      	int rows = Integer.parseInt(t[0]); // increase rows and cols to hold sums
      	int cols = Integer.parseInt(t[1]);	
      	char m[][] = new char[rows][cols];		// original matrix
      	char a[][] = new char[rows][cols];	// answer matrix
      	for(int r = 0; r < rows; r++) {			// add rows to matrix
      		String s = kb.nextLine().trim();
      		m[r] = s.toCharArray();
      	}
      	int aCol = 0;
      	for(int c = 0; c < cols; c+=2) {				// get odd cols first
      		for(int r = 0; r < rows; r++) 		 
      			a[r][aCol] = m[r][c];
      		aCol++;	 					 
      	}
      	for(int c = 1; c < cols; c+=2) {				// get even cols last
      		for(int r = 0; r < rows; r++) 		 
      			a[r][aCol] = m[r][c];
      		aCol++;	 					 
      	}      	
      	for(int r = 0; r < rows; r+=2) {			// print odd rows first
      		for(int c = 0; c < cols; c++) 	
       			out.print(a[r][c]);	
       		out.println();						
      	}	
      	for(int r = 1; r < rows; r+=2) {			// print even rows next
      		for(int c = 0; c < cols; c++)		
      			out.print(a[r][c]);     
      		out.println();
      	}
      	out.println();
      }
   }
}

