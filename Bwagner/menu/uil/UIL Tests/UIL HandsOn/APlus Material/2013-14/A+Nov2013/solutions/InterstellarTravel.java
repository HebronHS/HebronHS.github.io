import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//Dijkstra's shortest path algorithm

public class InterstellarTravel {
	public static void main(String [] args) throws FileNotFoundException {
		Scanner f = new Scanner(new File("interstellartravel.dat"));
		int N = f.nextInt(); f.nextLine();
		while(N-- > 0) {
			//keep locations in a map to get vertices by name for edge building
			String locations = f.nextLine();
			Scanner temp = new Scanner(locations);
			HashMap<String,Node> map = new HashMap<String,Node>();
			
			//vertex building
			while(temp.hasNext()) {
				String name = temp.next();
				map.put(name, new Node(name));
			}
			temp.close();
			
			//edge building
			int edges = f.nextInt(); f.nextLine();
			while(edges-- > 0) {
				String startV = f.next();
				String endV = f.next();
				int distance = f.nextInt();
				map.get(startV).neighbors.add(map.get(endV)); 
				map.get(startV).weights.add(distance);
			}
			
			//start and end locations
			Node start = map.get(f.next());
			Node destination = map.get(f.next());
			
			//scanners being silly
			if(f.hasNextLine())
				f.nextLine();
			System.out.println(start +" to "+destination+":"+dijkstra(start, destination));
		}
		f.close();
	}
	
	/*
	 * Keep a queue of all nodes to visit, beginning with the starting node. 
	 * 		Distance from starting node starting node is 0.
	 * Remove the first node from the queue, popped. Update all of popped's 
	 * 		neighbors distances with their distances from the start node,
	 * 		then append them to the end of the queue.
	 * Mark popped as visited. 
	 * Once the finishing node has been visited, a path has been found, and it 
	 * 		will be the shortest (line 67).
	 * If the nodes queue becomes empty before destination node is visited, then
	 * 		there exists no path from the start to the destination.
	 */
	public static int dijkstra(Node start, Node end) {
		ArrayList<Node> nodes = new ArrayList<Node>();
		start.dist = 0;
		nodes.add(start);
//		System.out.println("start "+nodes+" neighbors "+start.neighbors);
		while(!nodes.isEmpty()) {
			if(end.visited == true)
				break;
			Node popped = nodes.remove(0);
//			System.out.println("popped "+popped+" neighbors "+popped.neighbors);
		
			for(int i = 0; i<popped.neighbors.size(); i++) {
				Node current = popped.neighbors.get(i);
				current.dist = Math.min(current.dist, popped.weights.get(i) + popped.dist);
				nodes.add(current);
			}
			popped.visited = true;
		}
//		System.out.println(nodes);
		return end.dist;
	}
	
}
class Node {
	public ArrayList<Node> neighbors;	//list of all vertices this node is connected to
	public ArrayList<Integer> weights;  //parallel list of edge weights for this node to neighbors
	public boolean visited;				//boolean for dijkstra algorithm
	public String name;					//name of this location, completely unnecessary
	public int dist = Integer.MAX_VALUE;//distance to this node from the start node
	
	//Multiple constructors for convenience not necessity
	public Node() {
		neighbors = new ArrayList<Node>();
		weights = new ArrayList<Integer>();
	}
	public Node(String name, ArrayList<Node> neighbors, ArrayList<Integer> weights) {
		this.neighbors = neighbors;
		this.weights = weights;
		this. name = name;
	}
	
	public Node(String name) {
		neighbors = new ArrayList<Node>();
		weights = new ArrayList<Integer>();
		this.name = name;
	}
	public String toString()
	{
		return name;
	}
}

/*
Judge's data
8
M-87 XN385 Jupiter SiriusB
5
M-87 XN385 4
Jupiter M-87 5
Jupiter SiriusB 700
M-87 SiriusB 50
XN385 SiriusB 8
M-87 SiriusB
CenA CenB CX8 D-Galaxy Nebulae
6
CenA CenB 1
CenA CX8 7
CenA Nebulae 3
CenB Nebulae 6
CX8 Nebulae 2
Nebulae D-Galaxy 3
CenA D-Galaxy
Earth Theroc Ildira Llaro Rheindic
6
Earth Theroc 1
Earth Ildira 3
Earth Rheindic 4
Rheindic Llaro 4
Ildira Rheindic 1
Theroc Ildira 1
Earth Llaro
A B C D E
5
A A 1
A B 1
B A 1
C A 1 
D E 1
C A
A B C D E
2
A A 1
A B 1
A B
A B C D E F
5
A B 1 
B C 5 
C D 3
D E 7 
E F 9
C E
A B C D E F
10
A B 1 
B C 5 
C D 3
D E 7 
E F 9
F E 9
E D 7
D C 3
C B 5
B A 1
F A
A B
1
A B 1
A B

Expected output
M-87 to SiriusB:12
CenA to D-Galaxy:6
Earth to Llaro:7
C to A:1
A to B:1
C to E:10
F to A:25
A to B:1
*/
