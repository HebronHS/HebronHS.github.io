//Sample solution to Crazy Conversions
import java.util.*;
import java.io.*;
public class Conversions
{
	public static void main(String [] args) throws IOException
	{
		Scanner file = new Scanner(new File("conversions.dat"));
		int n = file.nextInt();
		while(n-->0)
		{
			
			double a = file.nextDouble();
			double b = file.nextDouble();
			double c = file.nextDouble();
			double d = file.nextDouble();
			System.out.printf("%.02f\n",crash(a,b));
			System.out.printf("%.02f\n",dash(a,b));
			System.out.printf("%.02f\n",mash(a,b));
			System.out.printf("%.02f\n",trash(a,b,c,d));
			System.out.println();
		}
	}
	public static double crash(double a, double b)
	{
		return (a/4.0) + (7*b);
	}
	public static double dash(double a, double b)
	{
		return (a+Math.pow(b,2))/(a+(1.0/b))+(a/b);
	}
	public static double mash(double a, double b)
	{
		return (1.0/(1.0/a - 1.0/b));
	}
	public static double trash(double a, double b, double c, double d)
	{
		return (4.0/a/b)*Math.sqrt((1+(5.0/(c+d)))/a) - a/(c+d);
	}
}