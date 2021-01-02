import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr32
{
   public static void main (String[] args) throws IOException
   {
      Scanner kb = new Scanner(new File("pr32.dat"));
      int times = Integer.parseInt(kb.nextLine().trim());  
      for(int z = 0; z < times; z++) {
      	String[] s = kb.nextLine().trim().split(" ");
      	int max = 0;				// find longest word
      	for(int i = 0; i < s.length; i++)
      		if(s[i].length() > max)
      			max = s[i].length();
       	char m[][] = new char[max][s.length];  // create matrix[longest word][num words]
      	for(int col = 0; col < m[0].length; col++) {
      		int wordLength = s[col].length();
      		for(int row = 0; row < wordLength; row++)
      			m[row][col] = s[col].charAt(row);
      	}
      	
      	for(int r = 0; r < m.length; r++) {
      		for(int c = 0; c < m[0].length; c++)		
      			out.print(m[r][c] + " ");     
      		out.println();
      	}
      	out.println();
      }
   }
}

