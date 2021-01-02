//Solution - HeadLine News Packet - John Owen - 2011
//Euros

import java.io.*;
import java.util.*;
import static java.lang.System.*;
import java.util.Formatter.*;

public class euros
{
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("euros.dat"));
		int reps = file.nextInt();

		for(int q=0; q<reps; q++)
		{
			double dollars = Double.parseDouble(file.next().substring(1));
			double euros = dollars * 0.7413;
			out.printf(Locale.GERMANY,"EUR %,.2f\n",euros);
		}
	}
	public static void main(String[] args)throws Exception
	{
		euros a=new euros();
		a.run();
	}
}