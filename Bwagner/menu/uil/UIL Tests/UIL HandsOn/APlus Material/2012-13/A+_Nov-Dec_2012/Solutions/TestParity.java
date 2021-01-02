//Sample solution to Test Parity
import java.util.*;
import java.io.*;
public class TestParity
{
	//data files need to be listed
	//test scores be integers?
	public static void main(String [] args) throws IOException
	{
		Scanner file = new Scanner(new File("testparity.dat"));
		while(file.hasNext())
		{
			double score = file.nextDouble();
			if(50<score && score<=75)
				score*=1.25;
			if(25<score && score<=50)
				score*=1.5;
			if(0<score && score<=25)
				score*=2;
			if(100<score && score<=120)
				score*=.9;
			System.out.printf("%.0f ",score);
		}
		System.out.println();
	}
}
