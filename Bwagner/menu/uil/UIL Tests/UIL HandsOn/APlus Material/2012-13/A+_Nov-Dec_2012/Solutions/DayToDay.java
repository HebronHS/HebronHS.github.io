//Sample Solution to Day To Day
import java.util.*;
import java.io.*;
public class DayToDay
{
	public static void main(String [] args) throws IOException
	{
		Scanner file = new Scanner(new File("daytoday.dat"));
		int n = file.nextInt();
		while(n-->0)
		{
			int m1,d1,y1,m2,d2,y2;
			double days=0;
			m1=file.nextInt();
			d1=file.nextInt();
			y1=file.nextInt();
			m2=file.nextInt();
			d2=file.nextInt();
			y2=file.nextInt();
			Date one = new Date (y1,m1,d1);
			Date two = new Date (y2,m2,d2);
			long diff = two.getTime() - one.getTime();
			days = diff/(1000.0*60*60*24)-1;
			System.out.printf("%.0f\n",days);
		}
	}
}