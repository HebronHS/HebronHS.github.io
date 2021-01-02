import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class CoolColors
{
	public static void main(String[] args) throws IOException
	{
		int i,a;
		
		String s;
		
		Scanner input = new Scanner(new File("coolcolors.dat"));
		PrintWriter output = new PrintWriter(new File("coolcolors.out"));
		
		while(input.hasNextLine())
		{
			s=input.nextLine().trim();
			for(i=0;i<s.length();i++)
			{
				if(s.charAt(i)=='b')
				{
					out.print(s.charAt(i));
					output.print(s.charAt(i));
					
				}
				 
				else
				{
					out.print(" "); 
					output.print(" ");
				}
				
				 
			}
			out.println();
			output.println();			
			
		
		}
	
	input.close();
	output.close();	
	}
}