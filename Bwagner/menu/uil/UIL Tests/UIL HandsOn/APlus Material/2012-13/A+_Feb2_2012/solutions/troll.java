import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;


public class troll {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc = new Scanner(new File("troll.in"));
		int inp = sc.nextInt();
		while(inp-- > 0){
			String a = sc.next();
			String b = sc.next();
			System.out.println(doit(a,b)?"Yes":"No");
		}
	}
	public static boolean doit(String a, String b)
	{
		HashMap<Character, Character> m = new HashMap<Character, Character>();
		HashSet<Character> s = new HashSet<Character>();
		for(int i=0;i<a.length();i++){
			char ca = a.charAt(i), cb = b.charAt(i);
			if(m.containsKey(ca)){
				char x = m.get(ca);
				if(x != cb) return false;
			}else{
				if(s.add(cb)){
					m.put(ca, cb);
				}else{
					return false;
				}
			}
		}
		return true;
	}
}
