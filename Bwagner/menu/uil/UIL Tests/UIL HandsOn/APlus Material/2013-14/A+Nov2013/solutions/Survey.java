import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

//Survey Says - Owen Solution

public class Survey{ 
	public static void main(String [] args) throws FileNotFoundException 
	{
		Scanner f = new Scanner(new File("survey.dat"));
		int N = f.nextInt(); 
			
		while(N-- > 0) 
		{
			int m = f.nextInt();//number of mailboxes
			int n = f.nextInt();//number of surveys
			args = new String[m];//create String array
			Arrays.fill(args,"");//fill String array with empty strings
			int total=0;//variable to count total surveys stuffed
			for(int x=0;x<n;x++) //loop through surveys
			{
				for(int y=x;y<m;y+=x+1)//place surveys in boxes as stipulated
				{
					args[y]+=(char)(65+x);//put survey in box
					total++;//increment total survey counter
				}
			}
			int most = 0;//variable to find the most number of surveys in a box
				for(int x=0;x<args.length;x++)
				{
//					out.print(args[x]+" ");
					most = (args[x].length()>most)?args[x].length():most;
				}
//				out.println();
				//Output #1
				out.print("Box that contains the most surveys: ");
				for(int x=0;x<args.length;x++)
				{
					if(args[x].length()==most)
						out.print(x+1+" ");
				}
				out.println();
				//Output #2
				out.println("Box "+n+" contains "+args[n-1].length()+" surveys.");
				//Output #3
				out.print("Boxes that contain only survey A: ");
				for(int x=0;x<args.length;x++)
				{
					if(args[x].equals("A"))
						out.print(x+1+" ");
				}
				out.println();
				//Output #4
				out.print("Boxes that contain exactly three surveys: ");
				for(int x=0;x<args.length;x++)
				{
					if(args[x].length()==3)
						out.print(x+1+" ");
				}
				out.println();
				//Output #5
				out.println("Total number of surveys stuffed: "+total);
				out.println();
		}
	}
	
}

/*
Judge's data
5
16 5
18 7
23 23
10 4
50 17

Expected output:
Box that contains the most surveys: 12
Box 5 contains 2 surveys.
Boxes that contain only survey A: 1 7 11 13
Boxes that contain exactly three surveys: 4 6 8 10 15 16
Total number of surveys stuffed: 36

Box that contains the most surveys: 12
Box 7 contains 2 surveys.
Boxes that contain only survey A: 1 11 13 17
Boxes that contain exactly three surveys: 4 8 10 14 15 16
Total number of surveys stuffed: 45

Box that contains the most surveys: 12 18 20
Box 23 contains 2 surveys.
Boxes that contain only survey A: 1
Boxes that contain exactly three surveys: 4 9
Total number of surveys stuffed: 76

Box that contains the most surveys: 4 6 8
Box 4 contains 3 surveys.
Boxes that contain only survey A: 1 5 7
Boxes that contain exactly three surveys: 4 6 8
Total number of surveys stuffed: 20

Box that contains the most surveys: 48
Box 17 contains 2 surveys.
Boxes that contain only survey A: 1 19 23 29 31 37 41 43 47
Boxes that contain exactly three surveys: 4 9 21 22 26 27 33 34 35 39
Total number of surveys stuffed: 166

*/

