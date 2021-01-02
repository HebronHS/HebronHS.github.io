import java.io.*;
import java.util.*;

class French
{
	public static void main(String [] args) throws IOException
	{
		Scanner f = new Scanner(new File("french.dat"));
		int N = f.nextInt();f.nextLine();
		while(N-->0)
		{
			double x = f.nextDouble();
			double y = f.nextDouble();
			double g = 9.81;
			double r = Math.sqrt(x*x + y*y);
			double v = Math.sqrt(r * g);
			double phi = Math.atan2(y,x);
			double theta =  phi * 180/Math.PI;
			System.out.printf("Velocity: %.5f m/s Angle: %.5f degrees \n", v, theta);
		}
	}
}