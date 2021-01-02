import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class SOOPSerSize
{
	public static void main(String[] args) throws IOException
	{
		int i,a,amount;
		double price;
		String s,s1,s2;
		String[] t;
		
		Scanner input = new Scanner(new File("soopsersize.dat"));
		PrintWriter output = new PrintWriter(new File("soopsersize.out"));
		s=input.nextLine().trim();
		a=Integer.parseInt(s);	
		
		for( i=0;i<a;i++)
		{
			s=input.nextLine().trim();
			t=s.split("\\s+");
			price=2.0*Double.parseDouble(t[0]);
			amount=Integer.parseInt(t[1]);
			amount*=amount;
		
			out.printf("$%.2f %d\n",price,amount);
			output.printf("$%.2f %d",price,amount);output.println();			
		}
		
				
	
	input.close();
	output.close();	
	}
}