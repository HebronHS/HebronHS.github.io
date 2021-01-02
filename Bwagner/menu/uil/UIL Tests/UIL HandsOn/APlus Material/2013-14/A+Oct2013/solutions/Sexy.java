import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class Sexy
{
	public static void main(String[] args) throws IOException
	{
		int i,a,b,c,d,x,y,z,max;
		
		String s,s1;
		String[] t;
		ArrayList<Integer> list = new ArrayList<>();
		Scanner input = new Scanner(new File("sexy.dat"));
		PrintWriter output = new PrintWriter(new File("sexy.out"));		
		
		
		//max = (int)Math.sqrt(Integer.MAX_VALUE);
		max=30000;
		for(i=2;i<max;i++)
		{
			b=0;
			for(c=2;c<=i;c++)
			{
				if(i%c==0)
				 b++;
			}
			if(b==1)
			 list.add(i);
			 
			//if(list.size()>=10000)
			 // break;
		}
		
		//out.println(list+" "+list.size());	
	
		while(input.hasNextLine())
		{			
			s=input.nextLine().trim();	
			t=s.split("\\s+");
			
			b=Integer.parseInt(t[0]);
			c=Integer.parseInt(t[1]);
			
			if(list.contains(b) && list.contains(c)&& (c-b)==6)
			{
				out.println("SEXY");
				output.println("SEXY");
			}
			else
			{
				out.println("NOT");
				output.println("NOT");
			}
										  
		}
		
	input.close();
	output.close();	
	}
}