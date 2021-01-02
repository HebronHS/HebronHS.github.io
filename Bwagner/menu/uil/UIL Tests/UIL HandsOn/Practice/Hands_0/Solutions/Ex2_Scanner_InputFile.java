import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class Ex2_Scanner_InputFile {
	public static void main(String args[]) throws IOException {
		Scanner in = new Scanner(new File("Ex2.dat")); 
		// read a single integer from a dat file
		String s = in.nextLine().trim();	// reads the first line of the dat file, the 3, as a String
		int num = Integer.parseInt(s);	// convert s to an int

		// read several integers from a single line
		// reads a line of  dat file, the 5 6 as a String
		// splits the String around the spaces into the array {"48", "16"}
		String [] t = in.nextLine().trim().split(" ");	
		// convert the elements of the array to ints
		
		int x = Integer.parseInt(t[0]);	
		int y = Integer.parseInt(t[1]);
	// now you can use the integers as integers in formulas
	int sum = x + y;
		out.println("Sum = " + sum);
	}
}
