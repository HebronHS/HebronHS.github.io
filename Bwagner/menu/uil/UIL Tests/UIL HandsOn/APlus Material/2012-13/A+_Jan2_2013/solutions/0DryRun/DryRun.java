import java.io.*;
import java.util.*;

class DryRun
{
	public static void main(String [] args) throws IOException
	{
		Scanner f = new Scanner(new File("dryrun.dat"));
		int N = f.nextInt();f.nextLine();
		while(N-->0)
		{
			System.out.println("I like "+f.next()+".");
		}
	}
}