import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class perm {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc = new Scanner(new File("perm.in"));
		int cs = sc.nextInt();
		while(cs-- > 0){
			int num = sc.nextInt();
			String nk = key(num);
			int ans = -1;
			for(int j = num+1; j <= 2000000; j++){
				String jk = key(j);
				if(nk.equals(jk)){
					ans = j;
					break;
				}
			}
			System.out.println(ans == -1 ? "USELESS" : ans);
		}
	}
	public static String key(int num){
		String s = num+"";
		char[] c = s.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
}
