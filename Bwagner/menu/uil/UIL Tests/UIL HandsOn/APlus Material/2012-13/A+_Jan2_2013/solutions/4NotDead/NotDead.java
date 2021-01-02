import java.io.*;
import java.util.*;

class NotDead
{
	public static void main(String [] args) throws IOException
	{
		Scanner f = new Scanner(new File("notdead.dat"));
		int N = f.nextInt();f.nextLine();
		while(N-->0)
		{
			String said = f.nextLine();
			if(said.equals("<nothing>"))
				System.out.println("Accepted");
			else
				System.out.println("Rejected");
		}
	}
}