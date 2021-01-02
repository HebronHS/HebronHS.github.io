import java.io.*;
import java.util.*;
import java.math.*;

class Black
{
	public static void main(String [] args) throws IOException
	{
		Scanner f = new Scanner(new File("black.dat"));
		int N = f.nextInt();f.nextLine();
		while(N-->0)
		{
			String knights_strength = f.next();
			BigInteger strength = new BigInteger(knights_strength);
			strength = strength.multiply(new BigInteger("190"));
			System.out.println("The Black Knight's strength is "+strength+".");
		}
	}
}