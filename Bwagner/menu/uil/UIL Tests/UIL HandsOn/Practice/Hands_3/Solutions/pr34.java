import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr34
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr34.dat"));
      String[] s = kb.nextLine().trim().split(" ");
      int times = s.length;  
      for(int z = 0; z < times; z++) {
      	int start = Integer.parseInt(s[z]); // number for outside box
		int size = 2*start + 1;				// size of matrix
      	int m[][] = new int[size][size];
      	for(int row = 0; row < size; row++) {
      		for(int col = 0 + row; col < size - row; col++){
   				m[row][col] = start;   			// top
   				m[col][row] = start;   			// left
   				m[col][size-row-1] = start;     // right
   				m[size-row-1][col] = start;		//bottom
	   		}		
	   		start--;
   		}			  
      	
       	for(int r = 0; r < size; r++) {
      		for(int c = 0; c < size; c++)		
      			out.print(m[r][c]);     
      		out.println();
      	}
      	out.println();
      }
   }
}

