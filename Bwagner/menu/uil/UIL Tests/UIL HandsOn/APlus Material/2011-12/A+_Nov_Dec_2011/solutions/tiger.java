//Solution - HeadLine News Packet - John Owen - 2011
//Tiger

import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class tiger
{
	public void run()throws Exception
	{
		Scanner f=new Scanner(new File("tiger.dat"));
		int reps = f.nextInt();
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<Boolean> t = new ArrayList<Boolean>();
		ArrayList<Boolean> v = new ArrayList<Boolean>();

		for(int q=0; q<reps; q++)
		{
			list.add(f.next());
			t.add(false);
			v.add(false);
		}
		t.set(0,true);

		for(int q=0; q<reps; q++)
		{
			f.next();//read name of interviewee
			int n = f.nextInt();//read number of names mentioned by interviewee
			for(int x=0;x<n;x++)//loop through names mentioned by interviewee
			{
				String name = f.next();//get mentioned name
				int i = list.indexOf(name);//get position in list of mentioned name
				if(v.get(i)==true&&t.get(i)==false)//if mentioned name has been mentioned before and is false, set interviewee to be a truthteller
					t.set(q,true);
				if(t.get(q)==true)//if interviewee is a truthteller, set mentioned name as a liar, and mark it as visited.
					t.set(i,false);
				else		//else set mentioned name as a truthteller
					t.set(i,true);
				v.set(i,true);//set mentioned name as visited
			}
		v.set(q,true);

		}
		TreeSet<String>ts = new TreeSet<String>();//add all truthtellers to TreeSet for alpha output
		for(int q=0; q<reps; q++)
			if(t.get(q))
				ts.add(list.get(q));
		for(String s:ts)		//output all truth tellers
			out.println(s);




	}
	public static void main(String[] args)throws Exception
	{
		tiger a=new tiger();
		a.run();
	}
}