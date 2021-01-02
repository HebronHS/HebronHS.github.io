import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr36
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr36.dat"));
      int times = Integer.parseInt(kb.nextLine().trim());
      for(int z = 0; z < times; z++) {
      	String t[] = kb.nextLine().trim().split(" ");
      	int rows = Integer.parseInt(t[0]); 	// get number of rows and cols
      	int cols = Integer.parseInt(t[1]);	
      	char m[][] = new char[rows][cols];	
      	int r;
      	for(r = 0; r < rows; r++) {		// add rows to matrix
      		String s = kb.nextLine().trim();
      		m[r] = s.toCharArray();
      	}
      	r = 0;	
      	int c = 0; 
      	int steps = 0;  
     	while(m[r][0] != '.') 		// find starting point
     		r++;
     	m[r][c] = '*';				// add * for first spot
     	steps++;
     	while(c<cols-2 || m[r][cols-1] != '.') {
     		
     		if(r+1<rows && m[r+1][c] == '.') {			// check down
     			r++;
     		}
     		else if(c+1 < cols && m[r][c+1] == '.') {	// check right
     			c++;
     		}
     		else if(r-1 > 0 && m[r-1][c] == '.') {		// check up
     			r--;
     		}
     		else if(c-1 > 0 && m[r][c-1] == '.') {		// check left
     			c--;
     		}
     		m[r][c] = '*';		// add *
     		steps++;
      	}
      	m[r][cols-1] = '*';		// add * to last spot
      	steps++;
      	for(r = 0; r < rows; r++) {				// output matrix
      		for(c = 0; c < cols; c++)			
      			out.print(m[r][c]);     
      		out.println();
      		
      	}
      	out.println("PATH IS OF LENGTH " + steps);
      	out.println();
      }
   }
}

