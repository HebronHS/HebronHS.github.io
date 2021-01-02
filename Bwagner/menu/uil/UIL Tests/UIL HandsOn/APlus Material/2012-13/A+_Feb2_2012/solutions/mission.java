import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class mission {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc = new Scanner(new File("mission.in"));
		int inp = sc.nextInt();
		sc.nextLine();
		while(inp-- > 0){
			String x = sc.nextLine();
			String[] arr = x.split(":");
			String curr = arr[0];
			for(int i=0;i<arr.length;i++){
				if(i==arr.length-1 || len(arr[i])>=8 || arr[i].substring(arr[i].length()-1).matches("[0-9]")){
					System.out.println(curr);
					break;
				}else{
					curr = curr + ":" + arr[i+1];
				}
			}
		}
	}
	public static int len(String s){
		return s.replaceAll(" +", "").length();
	}
}
