import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class Triple
{
	public static void main(String[] args) throws IOException
	{
		int i,a,b;
		
		String s,s1;
			
		Scanner input = new Scanner(new File("triple.dat"));
		PrintWriter output = new PrintWriter(new File("triple.out"));		
			
				
		for( i=0;i<3;i++)
		{			
			s=input.nextLine().trim();	
			b=Integer.parseInt(s);
			
			out.println(3*b);	
			output.println(3*b);
		
								  
		}
		
	input.close();
	output.close();	
	}
}