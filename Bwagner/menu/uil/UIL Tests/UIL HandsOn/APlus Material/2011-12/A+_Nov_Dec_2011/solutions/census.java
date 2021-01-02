//Solution - HeadLine News Packet - John Owen - 2011
//Census

import java.io.*;
import java.util.*;
import static java.lang.System.*;
import static java.lang.Math.*;

public class census
{
	public void run()throws Exception
	{
		Scanner f=new Scanner(new File("census.dat"));
		int reps = f.nextInt();
		f.nextLine();
		for(int q=0; q<reps; q++)
		{
			int num1 = f.nextInt();
			int num2 = f.nextInt();
			int num3 = num2/num1;
			if(num2%num1>0)
				num3++;
			out.println(num3);
		}
	}
	public static void main(String[] args)throws Exception
	{
		census a=new census();
		a.run();
	}
}