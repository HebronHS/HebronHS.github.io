//Solution - HeadLine News Packet - John Owen - 2011
//Full Body Scanner

import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class scanner
{
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("scanner.dat"));
		int reps = file.nextInt();
		file.nextLine();
		for(int q=0; q<reps; q++)
		{
			String name = file.nextLine();
			char first = name.split(" ")[0].charAt(0);
			String last = name.split(" ")[1];
			out.printf("%s, %c.\n",last,first);
		}
	}
	public static void main(String[] args)throws Exception
	{
		scanner a=new scanner();
		a.run();
	}
}