import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeMap;

// Dynamic Programming Solution to Bounded Knapsack (via reduction to 0-1 Knapsack).

public class FullShip {
	public static void main(String [] args) throws FileNotFoundException {
		Scanner f = new Scanner(new File("fullship.dat"));
		int N = f.nextInt(); f.nextLine();
		while(N-- > 0) {
			int items = f.nextInt(); f.nextLine();
			ArrayList<String> names = new ArrayList<String>();
			ArrayList<Integer> values = new ArrayList<Integer>();
			ArrayList<Integer> weights = new ArrayList<Integer>();
			//In normal DP, the first row of the matrix is filled with zeros. To avoid with problems with indexing and zeros, with
			// KnapObj, the first element of each list is a dummy that will be ignored. This is algorithmically 
			// equivalent to padding the dp matrix with zeros
			names.add(null);
			values.add(0);
			weights.add(Integer.MAX_VALUE);
			
			for(int i = 0; i<items; i++) {
				String name = f.next();
				int quantity = f.nextInt();
				int value = f.nextInt();
				int weight = f.nextInt();
				
				//does the reduction from bounded to 0-1 knapsack by introducing multiple identical items
				//based up quantity. This does lead to a slower solution, and is not scalable to large data sets.
				for(int j = 0; j<quantity; j++) {
					names.add(name);
					values.add(value);
					weights.add(weight);
				}
			}
			int maxWeight = f.nextInt();
			if(maxWeight == 0) {
				System.out.println(transformOutput("", names));
				continue;
			}
			String ans = knapsack(values, weights, names, names.size(), maxWeight);
			System.out.println(transformOutput(ans, names));
		}
		f.close();
	}
	
	/*
	 * Each element m[i][j] contains a solution to the subproblem of including the first i-1 elements (in n) and the lesser weight W. 
	 * From this subproblem, the addition of an item i is just the added weight of i and if this is an increase in value, then it should
	 * be recorded. 
	 */
	public static String knapsack(ArrayList<Integer> v, ArrayList<Integer> w, ArrayList<String> n, int q, int W) { 
		KnapObj [][] m = new KnapObj[q][W+1];
		
		for(int j = 0; j<m[0].length; j++) {
			m[0][j] = new KnapObj("", 0);
		}
		
		for(int i = 1; i<m.length; i++) {
			for(int j = 0; j<m[0].length; j++) {
				//To keep from double counting, we look at only subproblems where this ith item couldn't be located
				if(j >= w.get(i)) {
					//does adding this item increase this subproblems value?
					if(m[i-1][j].maxV < m[i-1][j-w.get(i)].maxV+v.get(i)) {
						//add the item and update the value
						m[i][j] = new KnapObj(m[i-1][j-w.get(i)].items + " " + n.get(i), m[i-1][j-w.get(i)].maxV+v.get(i));
					}
					else {
						//keep the old value
						m[i][j] = new KnapObj(m[i-1][j].items, m[i-1][j].maxV);
					}
				}
				else {
					//keep the value of the last iteration
					m[i][j] = new KnapObj(m[i-1][j].items, m[i-1][j].maxV);
				}
			}
		}
		
		/*for(int i = 0; i<q; i++) {
			for(int j = 0; j<m[0].length; j++) {
				System.out.print(m[i][j] + " ");
			}System.out.println();
		}*/
		
		//this solution has the best solutions of subproblems of lesser weights and various combinations 
		//items, so will therefore be the best solution of all items and entire weight.
		return m[q-1][W].items;
	}
	public static String transformOutput(String ans, ArrayList<String> items) {
		items.remove(0);
		TreeMap<String, Integer> out = new TreeMap<String, Integer>();
		HashSet<String> set = new HashSet<String>(items);
		for(String item: set) {
			out.put(item, 0);
			while(ans.contains(item)) {
				if(out.containsKey(item)) {
					out.put(item, out.get(item) + 1);
				}
				ans = ans.substring(0, ans.indexOf(item)) + ans.substring(ans.indexOf(item) + item.length());
			}
		}
		
		String ret = "";
		for(String item: out.keySet()) {
			ret+=item+": " + out.get(item) + " ";
		}
		return ret;
	}
}

//this class is convenient for keeping up with components of solution.
class KnapObj {
	public int maxV;
	public int curW;
	public String items;
	public KnapObj(String items, int maxV) {
		this.maxV = maxV;
		this.items = items;
	}
	
	public String toString() {
		return items + ": " + maxV;
	}
}