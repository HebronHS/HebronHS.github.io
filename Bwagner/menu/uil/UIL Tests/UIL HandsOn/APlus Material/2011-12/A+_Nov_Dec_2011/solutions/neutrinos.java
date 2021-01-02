//Solution - HeadLine News Packet - John Owen - 2011
//Neutrinos

import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class neutrinos
{
	public void run()throws Exception
	{
		Scanner f=new Scanner(new File("neutrinos.dat"));
		int reps = f.nextInt();
		f.nextLine();
		for(int q=0; q<reps; q++)
		{
			double miles = f.nextInt();
			double speed1 = miles*5280*12/39.37/299792458*1000000000;
			double speed2=speed1*1.000025;
			out.printf("%.2f\n",speed2-speed1);
		}
	}
	public static void main(String[] args)throws Exception
	{
		neutrinos a=new neutrinos();
		a.run();
	}
}