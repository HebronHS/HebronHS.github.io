import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class Refraction
{
	public static void main(String[] args) throws IOException
	{
		int i,a,b,c,d,x,y,z;
		double n1,n2,theta1,theta2,temp;
		temp=theta1=theta2=n1=n2=0.0;
				
		String s,s1;
		String[] t;
	
		Scanner input = new Scanner(new File("refraction.dat"));
		PrintWriter output = new PrintWriter(new File("refraction.out"));		
			
		s=input.nextLine().trim();
		a=Integer.parseInt(s);
		
		for( i=0;i<a;i++)
		{			
			s=input.nextLine().trim();	
			t=s.split("\\s+");
			
			n1=Double.parseDouble(t[0]);
			theta1=Math.toRadians(Double.parseDouble(t[1]));
			if(t[2].equals("n"))
			{
				theta2=Math.toRadians(Double.parseDouble(t[3]));
				n2=n1*Math.sin(theta1)/Math.sin(theta2);
				out.printf("n = %.3f%n",n2);
				output.printf("n = %.3f%n",n2);
			}
			else
			{
				n2=Double.parseDouble(t[2]);
				temp=Math.asin(n1*Math.sin(theta1)/n2);
				theta2=Math.toDegrees(temp);
				out.printf("angle = %.0f %n",theta2);
				output.printf("angle = %.0f %n",theta2);
			}			
								  
		}
		
	input.close();
	output.close();	
	}
}