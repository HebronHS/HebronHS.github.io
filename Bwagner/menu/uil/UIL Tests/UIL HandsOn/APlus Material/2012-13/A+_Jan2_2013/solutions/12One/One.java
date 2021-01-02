import java.io.*;
import java.util.*;

class One
{
	public static void main(String [] args) throws IOException
	{
		Scanner f = new Scanner(new File("one.dat"));
		int N = f.nextInt();f.nextLine();
		while(N-->0)
		{
			int m = f.nextInt();
			for(int x = 1; x<=m; x++)
			{
				if(x == m && m%3 == 0)
				{
					System.out.print(5);
					break;
				}
				else if(x==m)
				{
					System.out.print(m);
					break;
				}
				if(x%3 == 0)
					System.out.print(5+", ");
				else
					System.out.print(x+", ");
			}
			System.out.println();
		}
	}
}