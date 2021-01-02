import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class lights{
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc = new Scanner(new File("lights.in"));
		List l = new ArrayList();
		while(sc.hasNextLine()){
			String x = sc.nextLine();
			String[] arr = x.split(" ");
			if(arr.length == 2){
				int s = Integer.parseInt(arr[0]);
				int e = Integer.parseInt(arr[1]);
				l.add(new int[]{s,e});
			} else{
				int q = Integer.parseInt(arr[0]);
				boolean on=false;
				for(Object o : l){
					int[] r = (int[])o;
					if(r[0] <= q && q <= r[1]) on = !on;
				}
				System.out.println(q+" "+(on?"On":"Off"));
			}
		}
	}
	
}
