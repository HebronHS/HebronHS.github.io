import java.io.*;
import java.util.*;

class Where
{
	public static void main(String [] args) throws IOException
	{
		Scanner f = new Scanner(new File("where.dat"));
		StringBuilder out = new StringBuilder();
		fill();
		while(f.hasNext())
		{
			String input = f.next().toUpperCase();
			input = translate(input.substring(0,input.length()-2));
			out.append(input+" ");
		}
		System.out.println(out);
	}
	public static String translate(String word)
	{
		if(word.length()>1)
		{
			if(word.substring(0,2).equals("SH") || word.substring(0,2).equals("GR"))
			{
				word = prefix.get(word.substring(0,2)) + word.substring(2);
				return word;
			}
		}
		if(word.length()>0)
		{
			word = prefix.get(word.charAt(0)+"") + word.substring(1);
			return word;
		}
		return prefix.get(word.charAt(0)+"");
	}
	public static void fill2()
	{
		prefix.put("A","V");
		prefix.put("B","U");
		prefix.put("C","W");
		prefix.put("D","T");
		prefix.put("E","X");
		prefix.put("F","R");
		prefix.put("G","Y");
		prefix.put("H","Q");
		prefix.put("I","Z");
		prefix.put("J","P");
		prefix.put("K","O");
		prefix.put("L","SH");
		prefix.put("M","N");
		prefix.put("N","M");
		prefix.put("O","H");
		prefix.put("P","I");
		prefix.put("Q","G");
		prefix.put("R","J");
		prefix.put("S","L");
		prefix.put("T","E");
		prefix.put("U","K");
		prefix.put("V","D");
		prefix.put("W","C");
		prefix.put("X","B");
		prefix.put("Y","A");
		prefix.put("Z","F");
		prefix.put("SH","GR");
		prefix.put("GR","S");
	}
	
	public static void fill()
	{
		prefix.put("V","A");
		prefix.put("U","B");
		prefix.put("W","C");
		prefix.put("T","D");
		prefix.put("X","E");
		prefix.put("R","F");
		prefix.put("Y","G");
		prefix.put("Q","H");
		prefix.put("Z","I");
		prefix.put("P","J");
		prefix.put("O","K");
		prefix.put("SH","L");
		prefix.put("N","M");
		prefix.put("M","N");
		prefix.put("H","O");
		prefix.put("I","P");
		prefix.put("G","Q");
		prefix.put("J","R");
		prefix.put("L","S");
		prefix.put("E","T");
		prefix.put("K","U");
		prefix.put("D","V");
		prefix.put("C","W");
		prefix.put("B","X");
		prefix.put("A","Y");
		prefix.put("F","Z");
		prefix.put("GR","SH");
		prefix.put("S","GR");
	}
	public static HashMap<String, String> prefix = new HashMap<String, String>();
}