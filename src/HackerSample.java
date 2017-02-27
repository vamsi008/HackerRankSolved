
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class HackerSample {
	public static void main(String[] args) throws Exception {
	
		
		int[][] sample=new int[10][10];
		
		sample[9][9]=10;
		
		System.out.println("The value at sampel is ::"+sample[6][6]);
		

	}
	
	public static int partition(int[] arr){
		
		
		int i=0;
		//Taking the lasgt element as the pivot.
		int pivot=arr[arr.length-1];
		
		for(int j=1;j<arr.length-1;j++){
			
			if(arr[j]<=pivot){
				
				i=i+1;
				int temp=arr[j];
				arr[j]=arr[i];
				arr[i]=temp;
				
				
				
			}
		}
		
		int temp=arr[i+1];
		arr[i+1]=pivot;
		arr[arr.length-1]=temp;
		return i+1;
		
	}
}



	class Graph {
	
		private int V; // No. of vertices
		private LinkedList<Integer> adj[]; // Adjacency Lists
	
		// Constructor
		public Graph(int v) {
			V = v;
			adj = new LinkedList[v];
			for (int i = 0; i < v; ++i)
				adj[i] = new LinkedList();
		}
	
		// Function to add an edge into the graph
		public void addEdge(int v, int w) {
			adj[v].add(w);
		}
	
		public List<Integer> DFS(Integer s) {
			boolean visited[] = new boolean[V];
			List<Integer> countryCount = new ArrayList<Integer>();
	
			while (s != null) {
				countryCount.add(traverseCountry(visited, s));
				s = checkVisited(visited);
	
			}
			return countryCount;
		}
	
		public Integer checkVisited(boolean[] visited) {
			for (int i = 0; i < visited.length; i++) {
	
				if (!visited[i]) {
					return i;
				}
			}
	
			return null;
	
		}
	
		public int traverseCountry(boolean[] visited, int s) {
			int count = 0;
			Stack<Integer> st = new Stack<Integer>();
			visited[s] = true;
			st.push(s);
			while (!st.isEmpty()) {
				s = st.pop();
				// System.out.print(s+" ");
				count = count + 1;
				Iterator<Integer> i = adj[s].listIterator();
				while (i.hasNext()) {
					int n = i.next();
					if (!visited[n]) {
						visited[n] = true;
						st.push(n);
					}
				}
	
			}
	
			return count;
		}
	
	}
