import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class Quantum
{
	public static void main(String[] args) throws IOException
	{
		int i,a,v,n,pe,se;
		
		String s;
		String[] t;
		
		Scanner input = new Scanner(new File("quantum.dat"));
		PrintWriter output = new PrintWriter(new File("quantum.out"));
		s=input.nextLine().trim();
		a=Integer.parseInt(s);
		
		for( i=0;i<a;i++)
		{
			s=input.nextLine().trim();
			t=s.split("\\s+");
			n=Integer.parseInt(t[0]);
			v=Integer.parseInt(t[1]);
			if(v>=2)
			{
				se=2;
				pe=v-2;
			}
			else
			{
				se=1;
				pe=0;
			}
			
			
			if(pe==0)
			{
				out.println(n+"s"+se);
				output.println(n+"s"+se);
			}
			else
			{
				out.println(n+"s"+se+"p"+pe);
				output.println(n+"s"+se+"p"+pe);
			}			
		
		}
	
	input.close();
	output.close();	
	}
}