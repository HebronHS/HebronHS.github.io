import java.io.*;
import java.util.*;

class Witch
{
	public static void main(String [] args) throws IOException
	{
		Scanner f = new Scanner(new File("witch.dat"));
		int N = f.nextInt();f.nextLine();
		while(N-->0)
		{
			double duck = f.nextDouble();
			double witch = f.nextDouble();
			if(duck == witch)
				System.out.println("WITCH!");
			else
				System.out.println("NOT A WITCH!");
		}
	}
}