import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr75
{
	public static void main (String[] args) throws IOException
	{
		Scanner kb = new Scanner(new File("pr75.dat"));
		String s = kb.nextLine().trim();
		String v = "AEIOUaeiou";
		String c = "BCDFGHJKLMNPQRSTVWXYZbcdfghjklmnpqrstvwxyz";
		int vowels=0, consonants=0, spaces=0, other=0;
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (v.indexOf(ch) >= 0)
				vowels++;
			else if(c.indexOf(ch) >= 0)
				consonants++;
			else if(ch == ' ')
				spaces++;
			else
				other++;
		}
		String [] t = s.split(" ");
		int max=t[0].length(), min=t[0].length();
		int numWords = t.length;
		double sum = 0;
		for(int i = 1; i < t.length; i++) {
			int len = t[i].length();
			sum+=len;
			if(len>max)
				max = len;
			if(len<min)
				min = len;
		}
		double average = sum/numWords;
		out.println("VOWELS CONSONANTS SPACES OTHER WORDS LONGEST SHORTEST AVERAGE");	  	  
		out.printf("%6d%11d%7d%6d%6d%8d%9d%8.1f\n",vowels,consonants,spaces, other, numWords,max, min,average);
	}
}

