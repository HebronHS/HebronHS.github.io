//Sample solution for Baseball Bin Berry Berry Good To Me

import java.util.*;
import java.io.*;
public class Baseball
{
	public static void main(String [] args) throws IOException
	{
		Scanner file = new Scanner(new File("baseball.dat"));
		int[] bases = new int[4];
		while(file.hasNextLine())
		{
			String input_line = file.nextLine();
			//gets the 'type of hit the batter makes'
			int batter = input_line.charAt(6) - 48;
			input_line = "00001" + input_line.substring(0,6).replaceAll(" ","");
			String runners_on_base = input_line.substring(0,input_line.length()-batter);
			//removing zeros because zero's don't actually score
			String runners_scored = input_line.substring(input_line.length()-batter).replaceAll("0","");
			//format output
			for(int i = 3; i>0; i--)
			{
				System.out.print(runners_on_base.charAt(runners_on_base.length()-i)+" ");
			}
			//all 1's that crossed the base, thus, the length is the number of 1s
			System.out.println(runners_scored.length());
		}
	}
}