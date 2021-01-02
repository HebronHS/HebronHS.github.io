import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class RightStuff
{
	public static void main(String[] args) throws IOException
	{
		int i,a,b,c,d;
		double accepted, high, low, range, avg,temp,accu,prec,sum;	
				
		//ArrayList<Double> list = new ArrayList<Double>();
		//ArrayList<String> matches = new ArrayList<String>();
		
		String s,s1;
		String[] t;
		
		Scanner input = new Scanner(new File("rightstuff.dat"));
		PrintWriter output = new PrintWriter(new File("rightstuff.out"));	
		
		a=Integer.parseInt(input.nextLine().trim());
							
		for(i=0;i<a;i++)
		{
			s=input.nextLine().trim();
			t=s.split("\\s+");
			sum=0;
			accepted=Double.parseDouble(t[0]);
			high=low=Double.parseDouble(t[1]);
						
			for(b=1;b<t.length;b++)
			{
				temp=Double.parseDouble(t[b]);
				low=Math.min(temp,low);
				high=Math.max(temp,high);
				sum+=temp;
				
			}
			range=high-low;
			avg=sum/(t.length-1);
			prec=range/avg;
			accu=Math.abs(accepted-avg)/accepted;
			
			//out.println("accuracy = "+accu +" precision = "+prec);
			
			if(prec<=0.10 && accu<=0.05)
			{
				out.println("Both");
				output.println("Both");
				
			}
			else if(prec<=0.10)
			{
				out.println("Precise");
				output.println("Precise");
			}
			else if(accu<=0.05)			
			{
				out.println("Accurate");
				output.println("Accurate");
			}
			else
			{
				out.println("Neither");
				output.println("Neither");
			
			}					
		}			
		
	input.close();
	output.close();	
	}
	

}