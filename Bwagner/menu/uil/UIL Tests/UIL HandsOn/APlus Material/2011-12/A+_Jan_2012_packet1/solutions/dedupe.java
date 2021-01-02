import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class dedupe {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc = new Scanner(new File("dedupe.in"));
		int cs = sc.nextInt();
		while(cs-- > 0){
			String x = sc.next();
			for(char c = 'A'; c <= 'Z'; c++){
				x = x.replaceAll(c+"+", c+"");
			}
			System.out.println(x);
		}
	}
	public static String key(int num){
		String s = num+"";
		char[] c = s.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
}
