import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class MixEmUp
{
	public static void main(String[] args) throws IOException
	{
		int i,a,b,c,d,tot1,tot2,hand1,hand2;
		
		String s,s1;
		String[] t;
		ArrayList<String> p1, p2;
		p1 = new ArrayList<String>();
				
		Scanner input = new Scanner(new File("mixemup.dat"));
		PrintWriter output = new PrintWriter(new File("mixemup.out"));		
			
		s=input.nextLine().trim();
		a=Integer.parseInt(s);
		
		for( i=0;i<a;i++)
		{
			
			s=input.nextLine().trim();	
			t=s.split("\\s+");
			for(String s2:t)
			 p1.add(s2);
			
			b=p1.size(); 
			for(c=1;c<b;c++)
			{
				if(p1.get(c).equals(p1.get(c-1)))
				 {
				 	p1.add(p1.remove(c));
				 	c--;
				 }			
			}
			
			//out.println(p1);
			for(String s2:p1)
			{
				out.print(s2+" ");
				output.print(s2+" ");
			}
			out.println();output.println();
			p1.clear();
		}
	
	input.close();
	output.close();	
	}
}