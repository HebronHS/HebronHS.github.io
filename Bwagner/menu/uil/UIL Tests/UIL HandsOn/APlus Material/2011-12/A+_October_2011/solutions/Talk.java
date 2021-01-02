import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class Talk
{
	public static void main(String[] args) throws IOException
	{
		int i,a,b,r,c,d,e,tot,x1,y1,x2,y2;
		
		String s,s1,s2,s3;
		//StringBuffer u;
		String[] t;
		Scanner input = new Scanner(new File("talk.dat"));
		PrintWriter output = new PrintWriter(new File("talk.out"));
		s=input.nextLine().trim();
		a=Integer.parseInt(s);
		ArrayList<String> chart = new ArrayList<String>();
		
		for( i=0;i<a;i++)
		{
			tot=0;
			s=input.nextLine().trim();
			t=s.split("\\s+");
			r=Integer.parseInt(t[0]);
			b=Integer.parseInt(t[2]);
			
			for(c=0;c<r;c++)
			{
				chart.add(input.nextLine());
			}
			
			tot=0;
			
			for(d=0;d<b;d++)
			{
				x1=y1=x2=y2=-1;
				
				s=input.nextLine().trim();
				s1=s.substring(0,1);
				s2=s.substring(1,2);
				for(e=0;e<chart.size();e++)
				{
					s3=chart.get(e);
					if(s3.contains(s1))
					{
						y1=e;
						x1=s3.indexOf(s1);
					}
					if(s3.contains(s2))
					{
						y2=e;
						x2=s3.indexOf(s2);
					}
					
					
										
				}
				
				if(Math.abs(x1-x2)<=1 && Math.abs(y2-y1)<=1)
				{
					out.println(s);
					output.println(s);
					tot++;
				}			
				
			}
			
			if(tot==0)
			{
				out.println("OK");
				output.println("OK");
			}
			 
			
			out.println();
			output.println();		
		}
	
	input.close();
	output.close();	
	}
}