import java.io.*;
import java.util.*;

public class Solution {
   public static void main(String[] args) throws Exception{
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = bfr.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int I = Integer.parseInt(temp[1]);
      
        	Graph g = new Graph(N);
        for(int i = 0; i < I; i++){
            temp = bfr.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            g.addEdge(a,b);
              g.addEdge(b,a);
          // Store a and b in an appropriate data structure of your choice
        }

        List<Integer> countries=g.DFS(0);
       System.out.println("the no of countries::"+countries.size());
        long combinations = 0;
       
        int totalCount=g.count;
       int finalValue=0;
       if(countries.size()>1)
       for(Integer in:countries){
         //  System.out.println("The countires ppl are::"+in);
           totalCount=totalCount-in;
           finalValue=finalValue+(in*(totalCount));
       }
        System.out.println(finalValue);
            // Compute the final answer - the number of combinations
       
        //System.out.println(g.DFS(0).get(0));
        //System.out.println("The count at 1 is::"+g.DFS(0).get(1));
       //System.out.println("The count of the total vertices is ::"+g.count);

    }
}

 
class Graph {

	private int V; // No. of vertices
    public int count=0;
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
        this.count=0;
        
		boolean visited[] = new boolean[V];
        
		List<Integer> countryCount = new ArrayList<Integer>();

		while (s != null) {
            int sum=traverseCountry(visited, s);
            count=count+sum;
			countryCount.add(sum);
			s = checkVisited(visited);

		}
        //countryCount.add(count);
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
      //  System.out.println("**********The new graph started here *************");
		int count_temp = 0;
		Stack<Integer> st = new Stack<Integer>();
		visited[s] = true;
		st.push(s);
		while (!st.isEmpty()) {
			s = st.pop();
			// System.out.println("The popped node is :: "+s+" ");
			count_temp = count_temp + 1;
			Iterator<Integer> i = adj[s].listIterator();
            
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
                  //  System.out.println("The child nodes for node ::"+s+" ::"+n);
					st.push(n);
				}
			}

		}

		return count_temp;
	}

}

