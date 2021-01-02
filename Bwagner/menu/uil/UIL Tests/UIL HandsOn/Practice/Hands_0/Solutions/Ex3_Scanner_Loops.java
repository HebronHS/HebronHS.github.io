import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class Ex3_Scanner_Loops {
	public static void main(String args[]) throws IOException {
		Scanner in = new Scanner(new File("Ex3.dat")); 
		while(in.hasNext()) {
			String s = in.nextLine().trim();	//reads a string from input file		
			out.println(s);
		}
	}
}

