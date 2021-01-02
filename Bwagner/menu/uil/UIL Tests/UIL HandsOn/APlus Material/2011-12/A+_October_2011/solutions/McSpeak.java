import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class McSpeak
{
	public static void main(String[] args) throws IOException
	{
		int i,a;
		
		String s;
		
		Scanner input = new Scanner(new File("mcspeak.dat"));
		PrintWriter output = new PrintWriter(new File("mcspeak.out"));
		s=input.nextLine().trim();
		a=Integer.parseInt(s);
		
		for( i=0;i<a;i++)
		{
			s=input.nextLine().trim();
						
			out.println("Mc"+s);
			output.println("Mc"+s);
		
		}
	
	input.close();
	output.close();	
	}
}