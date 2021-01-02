import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class Debt
{
	public static void main(String[] args) throws IOException
	{
		int i,a;
		double x,y,z;
		String s;
		String[] t;
		
		Scanner input = new Scanner(new File("debt.dat"));
		PrintWriter output = new PrintWriter(new File("debt.out"));
		
		while(input.hasNextLine())
		{
			s=input.nextLine().trim();
			t=s.split("\\s+");
			x=Double.parseDouble(t[0]);
			y=Double.parseDouble(t[1]);
			
			if(y/x > 0.9)
			{
				out.println("beater");
				output.println("beater");
				
			}
			else
			{
				out.println("fleece");
				output.println("fleece");
			}
			
						
			
		
		}
	
	input.close();
	output.close();	
	}
}