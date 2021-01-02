import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class Taxation
{
	public static void main(String[] args) throws IOException
	{
		int i,a,b,c;	
		double x,total=0.0;
		
		String s,s1;
		String[] t;
		
		Scanner input = new Scanner(new File("taxation.dat"));
		PrintWriter output = new PrintWriter(new File("taxation.out"));	
				
		a=Integer.parseInt(input.nextLine().trim());
			
		for(i=0;i<a;i++)
		{
			s=input.nextLine().trim();
			t=s.split("\\s+");
						
			if(s.charAt(0)=='T')
			{
				
				x=Double.parseDouble(t[1]);
				total+=(x*1.0825);			
				
			}
			else
			{
				total+=Double.parseDouble(t[0]);
			}
			
					
		}	
		
		out.printf("The total is $%.2f\n",total);
		output.printf("The total is $%.2f",total);output.println();
	
	input.close();
	output.close();	
	}
	

}