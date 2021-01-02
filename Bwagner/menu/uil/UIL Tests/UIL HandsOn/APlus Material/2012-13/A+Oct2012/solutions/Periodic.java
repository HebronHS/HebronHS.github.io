import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class Periodic
{
	public static void main(String[] args) throws IOException
	{
		int i,a,b,c,d,tot1,tot2,hand1,hand2;
		boolean done=true;
		
		String s,s1;
		String[] t;
		
		ArrayList<String> m1 = new ArrayList<String>();
		ArrayList<String> m2 = new ArrayList<String>();
		
		Scanner input = new Scanner(new File("periodic.dat"));
		PrintWriter output = new PrintWriter(new File("periodic.out"));		
		 
		for( i=0;i<4;i++)
		{
			s=input.nextLine().trim().toLowerCase();	
			t=s.split("\\s+");
			for(String s2:t)
			{
				if(s2.length()==1)
				 m1.add(s2);
				else
				 m2.add(s2); 
			}			
		}
		
		//out.println(m1);
		//out.println(m2);
		
		s=input.nextLine().trim();
		a=Integer.parseInt(s);
		
		for( i=0;i<a;i++)
		{			
			s=input.nextLine().trim();			
			done=true;			
			//out.println(s);
			
			b=s.length();
			for(c=0;c<b;c++)
			{
				if(m1.contains(s.substring(0,1)))
				{
					s=s.substring(1);					
				}
				else if(s.length()>1 && m2.contains(s.substring(0,2)))
				{
					s=s.substring(2);
					c++;
				}
				else
				{
					done=false;
					break;
				}
				//out.println(s);
				
			}
						
			if(done)
			{
				out.println("yes");
				output.println("yes");
			}
			else
			{
				out.println("no");
				output.println("no");
			}		
		
		}
	
	input.close();
	output.close();	
	}
}