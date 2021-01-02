import java.io.*;
import java.util.*;

class Bridge
{
	public static void main(String [] args) throws IOException
	{
		Scanner f = new Scanner(new File("bridge.dat"));
		HashMap<String, String> knowledge = new HashMap<String, String>();
		for(int x= 0; x<50; x++)
		{
			String temp = f.nextLine();
			int mark = temp.indexOf("?");
			String question = temp.substring(0,mark+1);
			String answer = temp.substring(mark+2);
			knowledge.put(question,answer);
		}
		int N = f.nextInt();f.nextLine();
		while(N-->0)
		{
			int k = 0;
			while(k++<3)
			{
				String question = f.nextLine();
				String answer = knowledge.get(question);
				if(answer == null)
				{
					System.out.println("Sir Robin gets thrust into the pit.");
					while(k++<3)
						f.nextLine();
					continue;
				}
				System.out.println(answer+".");
				if(k == 3)
					System.out.println("Sir Robin can cross the bridge.");
			}
			System.out.println();
		}
	}
}