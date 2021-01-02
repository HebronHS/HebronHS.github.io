import java.io.*;
import java.util.*;
import static java.lang.System.*;  
public class Ex4_printf {
	public static void main(String args[]) throws IOException  {

      String name = "Java is fun";
		int id = 1111;
		double gpa = 4.15;

		// %s is where to print the variable name
		out.printf("%s is a wonderful person\n", name); // args can be variables or literals
		out.printf("ID number %d, name %s has GPA: %f \n\n", id, name, gpa);  
		out.printf("ID number %d, name %s has GPA: %f \n\n", 222, "Liberace", 3.2);  

		double sam = 234.56789;
		out.printf("1 decimal:   %.1f \n\n", sam);	// round to one decimal
		out.printf("Left justify in 6 columns%-6.0frounded to integer\n", sam);
		// 8.3 means right justified in 8 spaces with a decimal and 3 decimal digits
		out.printf("3 decimals:   %8.3f \n\n", sam);

		// output in scientific notation 
		out.printf("\nScientific notation:   %e \n\n", sam); //floating point output

		// output in chars
		out.printf("\nThese are A's %c %c \n\n", 'a', 65); // can be a variable or ASCII

		int num = 640;

		// print in different bases
		out.printf ("  base 10: %d \n", num);   // decimal - base 10
		out.printf("  base  8: %o \n", num);	// octal - base 8
		out.printf("  base 16: %x \n\n", num);	// hexadecimal - base 16

		// format String output
		out.printf("%10d%s \n", 111, "Right justify in 10 columns");
		out.printf("%010d%s \n", 111, "Right justify and fill with 0's");
		out.printf("%-10d%s \n", 111, "Left justify in 10 columns");
	}
}


