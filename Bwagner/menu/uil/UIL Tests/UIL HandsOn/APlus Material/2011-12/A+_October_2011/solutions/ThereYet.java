import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class ThereYet
{
	public static void main(String[] args) throws IOException
	{
		int i,a,hr,min;
		
		String s;
		String[] t;
		Scanner input = new Scanner(new File("thereyet.dat"));
		PrintWriter output = new PrintWriter(new File("thereyet.out"));
		s=input.nextLine().trim();
		a=Integer.parseInt(s);
		
		for( i=0;i<a;i++)
		{
			s=input.nextLine().trim();
			t=s.split("\\s+");
			//out.println(t[0]);
			hr=Integer.parseInt(t[0]);
			min=Integer.parseInt(t[2])+30;
			
			if(min >=60)
			{
				hr++;
				min-=60;
			}			
						
			out.println(hr+" hours and "+min+" minutes");
			output.println(hr+" hours and "+min+" minutes");
		
		}
	
	input.close();
	output.close();	
	}
}