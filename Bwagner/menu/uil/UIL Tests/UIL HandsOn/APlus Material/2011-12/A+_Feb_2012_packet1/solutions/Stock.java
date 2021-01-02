import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class Stock
{
	public static void main(String[] args) throws IOException
	{
		int i,a,b,c,total1,total2;
		double x,y,z,previous,current;
		ArrayList<Double> prices = new ArrayList<Double>();
		String s,s1;
		String[] t;
		boolean trend1,trend2,trend3,trend4,done=false;
		trend1=trend2=trend3=trend4=false;
		
		
		Scanner input = new Scanner(new File("stock.dat"));
		PrintWriter output = new PrintWriter(new File("stock.out"));
		s=input.nextLine().trim();
		a=Integer.parseInt(s);
		
		for( i=0;i<a;i++)
		{
			s=input.nextLine().trim();
			//out.println(s);
			t=s.split("\\s+");
			prices.clear();
			
			for(String aa:t)
			{
				prices.add(Double.parseDouble(aa));
			}
			total1=total2=1;
			done=false;
			previous=prices.get(0);
			for(b=1;b<prices.size()&&!done;b++)
			{
				current=prices.get(b);
				
				if(current>previous)
				 total1++;
				else
				 total1=1; 
				 
				if(current<previous) 
				 total2++;
				else 
				 total2=1; 
				
				//out.println("b="+b+" "+total1+" -- "+total2);
				
				if(b>=10)
				{
					if(total1>10)
					{
						//maximum value
						out.printf("sell at %.2f\n",current);
						output.printf("sell at %.2f",current);output.println();
						done=true;
						break;
						
					}
					
					if(total2>10)
					{
						//minimum value
						out.printf("buy at %.2f\n",current);
						output.printf("buy at %.2f",current);output.println();
						done=true;
						break;
						
					}
					
					if(current>=1.20*prices.get(b-10))
					{
						// 20%increase!
						//out.println("---"+current+" "+prices.get(b-10));
						out.printf("sell at %.2f\n",current);
						output.printf("sell at %.2f",current);output.println();
						done=true;
						break;
						
					}
					if(current<=0.80*prices.get(b-10))
					{
						// 20%decrease!
						//out.println("-----"+current+" "+prices.get(b-10));
						out.printf("buy at %.2f\n",current);
						output.printf("buy at %.2f",current);output.println();
						done=true;
						break;
						
					}
					if(b==19)
					{
						out.println("hold");
						output.println("hold");
						
					}					
				}
				
				previous=current;
			}			 			
					
		}
	
	input.close();
	output.close();	
	}
}