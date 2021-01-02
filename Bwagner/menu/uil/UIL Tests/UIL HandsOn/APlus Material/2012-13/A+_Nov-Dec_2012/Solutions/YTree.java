//Solution to YTree
import java.util.*;
import java.io.*;
import static java.lang.System.*;
public class YTree
{
	public static void main(String [] args) throws IOException
	{
		String stars = "****************";
		String spaces = "                ";
		Scanner f = new Scanner(new File("ytree.dat"));
		
		while(f.hasNext())
		{
			int N = f.nextInt();
			int y;
			for(y = 0;y<N-1;y++)
				out.printf("%s%s%s%s\n",spaces.substring(0,y),stars.substring(0,3),spaces.substring(0,2*N-y*2-3),stars.substring(0,3));
			out.printf("%s%s\n",spaces.substring(0,y),stars.substring(0,5));
			for(int z = 0;z<N;z++)
				out.printf("%s%s\n",spaces.substring(0,N),stars.substring(0,3));
			
		}
	}
}