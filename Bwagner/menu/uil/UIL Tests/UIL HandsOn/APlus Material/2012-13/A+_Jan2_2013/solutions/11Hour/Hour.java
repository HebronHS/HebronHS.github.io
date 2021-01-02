import java.io.*;
import java.util.*;

class Hour
{
	public static void main(String [] args) throws IOException
	{
		Scanner f = new Scanner(new File("hour.dat"));
		int N = f.nextInt();f.nextLine();
		while(N-->0)
		{
			String date = f.next();
			int month = Integer.parseInt(date.substring(0,date.indexOf("/")));
			date = date.substring(date.indexOf("/")+1);
			int day = Integer.parseInt(date.substring(0,date.indexOf("/")));
			date = date.substring(date.indexOf("/")+1);
			int year = Integer.parseInt(date);
			Calendar cal = Calendar.getInstance();
			cal.set(year, month-1, day);
			int psychic = f.nextInt();
			cal.add(Calendar.DAY_OF_MONTH,psychic);
			
			String day_of_week = (cal.getTime()+"").substring(0,3)+"";
			String calc_day = cal.get(Calendar.DAY_OF_MONTH)+"";
			String calc_year =cal.get(Calendar.YEAR)+"";
			String calc_month = cal.get(Calendar.MONTH)+1+"";
			System.out.println(day_of_week+" "+calc_month+"/"+calc_day+"/"+calc_year);
		}
	}
}