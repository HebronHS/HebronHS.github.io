//Solution - HeadLine News Packet - John Owen - 2011
//Wimbledon

import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class wimbledon
{
	public void run()throws Exception
	{
		Scanner f=new Scanner(new File("wimbledon.dat"));
		int reps = f.nextInt();
		f.nextLine();
		for(int q=0; q<reps; q++)
		{
			String[]scores=f.nextLine().split("-");
			int first = Integer.parseInt(scores[0]);
			int second = Integer.parseInt(scores[1]);
			if(first==second)
				out.println(word(first)+" all");
			else
			if((first>=6||second>=6)&&Math.abs(first-second)>=2)
				out.println("set");
			else
			out.println(word(first)+" - "+word(second));
		}
	}
	public static String word(int x)
	{
		switch(x)

		{
			case 0:return "love";
			case 1:return "one";
			case 2:return "two";
			case 3:return "three";
			case 4:return "four";
			case 5:return "five";
			case 6:return "six";
			case 7:return "seven";
			case 8:return "eight";
			case 9:return "nine";
		}
		return "";
	}
	public static void main(String[] args)throws Exception
	{
		wimbledon a=new wimbledon();
		a.run();
	}
}