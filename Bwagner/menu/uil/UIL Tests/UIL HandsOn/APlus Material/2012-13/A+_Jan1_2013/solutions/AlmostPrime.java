import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class AlmostPrime
{
	public static void main(String[] args) throws IOException
	{
		int i,a,b,r,c,d,max;
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		String s,s1;
		
		Scanner input = new Scanner(new File("almostprime.dat"));
		PrintWriter output = new PrintWriter(new File("almostprime.out"));	
		
		max = (int)Math.sqrt(Integer.MAX_VALUE);
		
		for(i=4;i<max;i++)
		{
			b=0;
			for(c=2;c<=i;c++)
			{
				if(i%c==0)
				 b++;
			}
			if(b==2)
			 list.add(i);
			 
			if(list.size()>=40)
			  break;
		}
		
		//out.println(list);
		
		while(input.hasNextLine())
		{
			a=Integer.parseInt(input.nextLine().trim());
			out.println(list.get(a-1));
			output.println(list.get(a-1));
		}

				
			
			
	
	
	input.close();
	output.close();	
	}
	

}