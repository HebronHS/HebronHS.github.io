//Solution - HeadLine News Packet - John Owen - 2011
//Summation

import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class summation
{
	public void run()throws Exception
	{
		Scanner f=new Scanner(new File("summation.dat"));
		int reps = f.nextInt();
		f.nextLine();
		for(int q=0; q<reps; q++)
		{
			int k=f.nextInt(),n=f.nextInt();
			int sum = 0;
			for(int x=k;x<=n;x++)
				sum+=x*(x+1)/2;
			out.println(sum);
		}
	}
	public static void main(String[] args)throws Exception
	{
		summation a=new summation();
		a.run();
	}
}