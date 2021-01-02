import java.io.*;
import java.util.*;
import static java.lang.System.*;		// don't need System before in or out.println

public class Ex1_Scanner_Keyboard {
	public static void main(String args[]) throws IOException {
		Scanner kb = new Scanner(in); 
		System.out.print("Enter an integer: ");
		int a = kb.nextInt(); 	// reads an integer from keyboard
		System.out.println(a);
		
		System.out.print("Enter a double: ");
		double d = kb.nextDouble();	// reads a double from keyboard
		System.out.println(d);

		System.out.print("Enter a word: ");
		String s = kb.next();	// reads one string with no spaces from keyboard		
		System.out.println(s);	
	}
}


