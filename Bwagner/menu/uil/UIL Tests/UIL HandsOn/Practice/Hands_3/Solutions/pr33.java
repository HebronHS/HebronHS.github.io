import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr33
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr33.dat"));
      String[] s = kb.nextLine().trim().split(" ");
      int times = s.length;  
      for(int z = 0; z < times; z++) {
      	int size = Integer.parseInt(s[z]);
      	char ch = (char)('0' + size) ;   // char to be used
      	size = 2*size + 1;		// size of matrix
      	char m[][] = new char[size][size];
      	for(int row = 0; row < size; row++) {
   			m[row][row] = ch;			  // left to right diagonal
   			m[size - row - 1][row] = ch;  // right to left diagonal
   			m[size/2][row] = ch;	  // horizontal middle
   			m[row][size/2] = ch;	  // vertical middle
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

