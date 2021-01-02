//Solution - HeadLine News Packet - John Owen - 2011
//In The Red

import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class red
{
	public void run()throws Exception
	{
		Scanner f=new Scanner(new File("red.dat"));
		double balance = f.nextDouble();
		int reps = f.nextInt();
		out.println("        DEBIT        CREDIT       BALANCE");
		out.println("-------------*-------------*-------------*");
		out.printf("%28s$%,(12.2f\n","",balance);

		for(int q=0; q<reps; q++)
		{
			char a = f.next().charAt(0);
			double d = f.nextDouble();
			if(a=='C')
			{
				balance += d;
				out.printf("%14s$%,(12.2f $%,(12.2f\n","",d,balance);
			}
			else if(a=='D')
			{
				balance -= d;
				out.printf("$%,(12.2f%14s $%,(12.2f\n",d,"",balance);
			}

		}
				out.println("-------------*-------------*-------------*");


	}
	public static void main(String[] args)throws Exception
	{
		red a=new red();
		a.run();
	}
}