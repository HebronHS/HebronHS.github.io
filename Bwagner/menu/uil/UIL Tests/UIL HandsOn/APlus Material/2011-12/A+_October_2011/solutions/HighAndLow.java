import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class HighAndLow
{
	public static void main(String[] args) throws IOException
	{
		int i,a,b,c,min,max;
		
		String s;
		String[] t;
		
		Scanner input = new Scanner(new File("highandlow.dat"));
		PrintWriter output = new PrintWriter(new File("highandlow.out"));
		a=Integer.parseInt(input.nextLine().trim());
		
		for(i=0;i<a;i++)
		{
			s=input.nextLine().trim();
			t=s.split("\\s+");
			min=max=Integer.parseInt(t[0]);
			for(b=1;b<t.length;b++)
			{
				c=Integer.parseInt(t[b]);
				min=Math.min(min,c);
				max=Math.max(max,c);
				
				 
			}
			out.println("high = "+max+" low = "+min);
			output.println("high = "+max+" low = "+min);			
			
		
		}
	
	input.close();
	output.close();	
	}
}