import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class Alliteration
{
	public static void main(String[] args) throws IOException
	{
		int i,a,b,total,this_total,max,line;
		String s;
		String[] t;
		char oldc, newc;
				
		Scanner input = new Scanner(new File("alliteration.dat"));
		PrintWriter output = new PrintWriter(new File("alliteration.out"));
		s=input.nextLine().trim();
		a=Integer.parseInt(s);	
		max=1;
		line=1;
		
		for( i=1;i<=a;i++)
		{
			s=input.nextLine().toLowerCase().trim();
			//b=s.length();
			t=s.split("\\s+");
			oldc=t[0].charAt(0);
			total=this_total=1;			
			for(b=1;b<t.length;b++)
			{
				newc=t[b].charAt(0);
				
				if(newc==oldc)
				{
					this_total++;
				}
				else
				{
					this_total=1;
				}
				
				if(this_total>total)
				{
					total=this_total;
				}
				
				oldc=newc;
			}
						
			if(total>max)
			{
				max=total;
				line=i;
			}
			
			//out.println("line="+line+" max"+max);
			if(total<2)
			{
				out.println("none");
				output.println("none");
				
			}
			else if(total==2)
			{
				out.println("accident");
				output.println("accident");
			}
			else if(total==3)
			{
				out.println("some alliteration");
				output.println("some alliteration");
			}
			else 
			{
				out.println("a lot of alliteration");
				output.println("a lot of alliteration");
			}	
						
		}
		out.println("Line "+line+" has "+max+" words in a row.");
		output.println("Line "+line+" has "+max+" words in a row.");
		
				
	
	input.close();
	output.close();	
	}
}