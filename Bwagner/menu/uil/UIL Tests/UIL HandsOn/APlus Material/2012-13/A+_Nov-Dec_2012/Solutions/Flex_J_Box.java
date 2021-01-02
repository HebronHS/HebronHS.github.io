//Sample Solution to Flex J Box
import java.util.*;
import java.io.*;
public class Flex_J_Box
{
	public static void main(String [] args) throws IOException
	{
		Scanner file = new Scanner(new File("flexjbox.dat"));
		int n = file.nextInt();
		while(n-->0)
		{
			int row = file.nextInt();
			int col = file.nextInt();
			int position_r = file.nextInt();
			int position_c = file.nextInt();
			for(int r = 0; r<row; r++)
			{
				for(int c = 0; c<col; c++)
				{
					if(r==position_r&&c==position_c)
						System.out.print('J');
					else
						System.out.print('*');
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}