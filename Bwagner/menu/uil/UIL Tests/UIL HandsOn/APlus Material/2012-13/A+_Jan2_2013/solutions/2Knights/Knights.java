import java.io.*;
import java.util.*;

class Knights
{
	public static void main(String [] args) throws IOException
	{
		Scanner f = new Scanner(new File("knights.dat"));
		int N = f.nextInt();f.nextLine();
		while(N-->0)
		{
			ArrayList<Knight> characters = new ArrayList<Knight>();
			String nextLine = f.nextLine();
			while(!nextLine.equals("-"))
			{
				int index = nextLine.indexOf(':');
				String name = nextLine.substring(0,index);
				String sentence = nextLine.substring(index);
				Knight temp = null;
				for(int x = 0; x<characters.size(); x++)
				{
					if(characters.get(x).name.equals(name))
					{
						temp = characters.remove(x);
						break;
					}		
				}
				if(temp == null)
				{
					temp = new Knight();
					temp.name = name;
				}
				sentence = sentence.toUpperCase();
				sentence = sentence.replaceAll("[?!.;:\'\",]","");
				Scanner chop = new Scanner(sentence);
				int count = 0;
				while(chop.hasNext())
				{
					String check = chop.next();
					if(check.equals("NI"))
						count++;
				}
				temp.count += count;
				characters.add(temp);
				nextLine = f.nextLine();
			}
			Collections.sort(characters);
			for(int x = 0; x<characters.size(); x++)
			{
				Knight knight = characters.get(x);
				System.out.println(knight.getString());
			}
			System.out.println();
		}
	}
}
class Knight implements Comparable
{
	public int count = 0;
	public String name; 
	public String getString()
	{
		if(this.count == 0)
			return this.name + " does not say Ni.";
		if(this.count > 0 && this.count <17)
			return this.name +" is a fan of Knights Who Say Ni.";
		if(this.count >= 17)
			return this.name +" is a member of the Knights Who Say Ni.";
		return this.name +" has unknow count. >>> ";
	}
	public int compareTo(Object o)
	{
		Knight k = (Knight)o;
		return this.name.compareTo(k.name);
	}
}