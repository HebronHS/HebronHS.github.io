//Owen - Breaking Bad - 
//Solution 

import static java.lang.System.*;
import java.io.*;
import java.util.*;

public class bad
{
	static ArrayList<String> el = new ArrayList<String>();
	static String A(String s)
	{
		int k=s.length();
		int i = k;
		String aa = null;
		
		for(String a:el)
		{
			if(s.toLowerCase().contains(a.toLowerCase()))
			{
				int j = s.toLowerCase().indexOf(a.toLowerCase());
				if(j<i)
				{
					i=j;
					aa=a;
				}
			}
		}
		if(i<k)
			return s.substring(0,i)+aa+"_"+s.substring(i+aa.length());
		return s;
	}
	public static void main(String [] args) throws IOException
	{
		Scanner f = new Scanner(new File("bad.dat"));
		Scanner ff = new Scanner(new File("elements.dat"));
		
		while(ff.hasNext())
		{
			String s = ff.nextLine();
			String abr = s.split(" - ")[1];
			el.add(abr);
		}
		Collections.sort(el);
//		out.println();
		while(f.hasNext())
		{
			args = f.nextLine().split(" ");
			out.println(A(args[0])+" "+A(args[1]));
		}

	}
			
}
/* Input
Brian Cranston
Aaron Paul
RJ Mitte
Anna Gunn
Dean Morris
Bod Odenkirk
Giancarlo Esposito
Jonathan Banks
Betsy Brandt
George Flex
Uutor Zing
Xenon Ybarro
Rheindic Co
King Peter
Geassr Tzmammnm

Output
B_rian C_ranston
AAr_on P_aul
RJ MI_tte
AN_na GU_nn
DeaN_ Mo_rris
B_od O_denkirk
GI_ancarlo Es_posito
JO_nathan B_anks
B_etsy B_randt
Ge_orge F_lex
U_utor ZI_ng
Xe_non Y_barro
Rh_eindic C_o
K_ing P_eter
Ge_assr TzmAm_mnm
Press any key to continue...
 **/