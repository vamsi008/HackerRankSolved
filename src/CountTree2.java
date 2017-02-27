import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int nodes=sc.nextInt();
        Graph g=new Graph(nodes+1);
	    int[][] graph=new int[nodes+1][nodes+1];
        int quries=sc.nextInt();
         Map<Integer,List<Integer>> col=new HashMap<Integer,List<Integer>>();
        List<Integer> nodeValList=new ArrayList<Integer>();
        for(int i=1;i<nodes+1;i++){
           int tmp=sc.nextInt();
            nodeValList.add(tmp);
            if(col.get(tmp)==null){
                List<Integer> tempList=new LinkedList<Integer>();
                tempList.add(i);
                col.put(tmp,tempList);
            }else{
                List<Integer> temp1=col.get(tmp);
                temp1.add(i);
                
            }
            
        }
        
        
        for(int j=0;j<nodes-1;j++){
           // System.out.println("The j value is ::"+j);
            int node1=sc.nextInt();
            int node2=sc.nextInt();
            g.addEdge(node1, node2);
              graph[node1][node2]=1; 
            graph[node2][node1]=1;
           
            
        }
        
        ///The queries to iterate through.
        
        for(int p=0;p<quries;p++){
            
            int node1=sc.nextInt();
            int node2=sc.nextInt();
            int node3=sc.nextInt();
            int node4=sc.nextInt();
            //System.out.println("First The nodes btw ::"+node1+" , "+node2);
            List<Integer> list1=shortestPath(g,node1,nodes,node2);
            /*for(int listVal:list1){
                System.out.println(listVal);
            }
            System.out.println("-----------------------");
            System.out.println("First The nodes btw ::"+node3+" , "+node4);*/
            List<Integer> list2=shortestPath(g,node3,nodes,node4);
            /*System.out.println("The nodes btw ::"+node1+" , "+node2);
               System.out.println("The nodes btw ::"+node3+" , "+node4);
             for(int listVal:list2){
                System.out.println(listVal);
            }
            System.out.println("-----------------------");*/
            int maxCount=0;
            for(Integer tempVal:list1){
                int nodeVal=nodeValList.get(tempVal-1);
                List<Integer> nodeList1=col.get(nodeVal);
                
               // System.out.println("The node is ::"+tempVal+ "::The Node value is::"+nodeVal);
                for(Integer tempNode1:nodeList1){
                   // System.out.println("Nodes with same value are::"+tempNode1);
                    if(tempNode1!=tempVal){
                       
                        if(list2.contains(tempNode1)){
                             //System.out.println("The second list contains ::"+tempNode1);
                        maxCount=maxCount+1;
                        }
                    }
                }
                
            }
            
            System.out.println(maxCount);
            
        }
       
        //g.DFS(6,10);
        //Iterate through map.
         
        
    }
    
    
     static List<Integer> shortestPath(Graph graph,int rootNode,int vertices,int dest){
        
        int[] dist=new int[vertices+1];
         
        Map<Integer,Integer> path=new HashMap<Integer,Integer>();
         List<Integer> pathList=new ArrayList<Integer>();
         //pathList.add(rootNode);
        Boolean sptSet[] = new Boolean[vertices+1];
        for (int i = 0; i <=vertices; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
        
         dist[rootNode] = 0;
        
        for(int i=0;i<=vertices;i++){
            int u=minDistance(dist, sptSet);
            sptSet[u] = true;
            //traverse through all the edges that are connect to
            //System.out.println("This is the minimum distance from vetex::"+u);
             //System.out.println("The value in the distance value::"+dist[u]);
            for(int v=0;v<=vertices;v++){
                 if (!sptSet[v] && areConnected(graph,u, v) && dist[u] != Integer.MAX_VALUE &&  dist[u]+1 < dist[v]){
                    dist[v] = dist[u] + 1;
                     path.put(v,u);
                     if(v==dest){
                         break;
                     }
                   
                     //System.out.println("The nodes that is relateed to ::"+u +" ::coonected ::"+v);
                 }
                //System.out.println("The distance at v is ::"+v+" value ::"+dist[v]);
            }
        } 
         int value=dest;
         while(value!=rootNode){
             //System.out.println("The shorted path is ::"+value);
             pathList.add(value);
             value=path.get(value);
         
         }
         pathList.add(value);
        /* for(Integer pathVal: pathList) {
            System.out.print(" "+pathVal+"->"); 
         }
         System.out.println("");*/
              return pathList; 
    }
    static boolean areConnected(Graph graph,int u,int v){
        
         
        return graph.adj[u].contains(v);
    }
    
   static   int minDistance(int dist[], Boolean sptSet[])
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index=-1;
 
        for (int v = 0; v < sptSet.length; v++)
            if (sptSet[v] == false && dist[v] <= min)
            {
           // System.out.println("The minimum node is ::"+v);
                min = dist[v];
                min_index = v;
            }
 
        return min_index;
    }
}

 class Graph {

	private int V; 
	public LinkedList<Integer> adj[]; 
    
    public Graph(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}
    
    public void addEdge(int v, int w) {
		adj[v].add(w);
        adj[w].add(v);
	}
     
     
     	public void DFS(int s,int des){
		boolean visited[]=new boolean[V];
		Stack<Integer> st=new Stack<Integer>();
        Set<Integer> st_new=new HashSet<Integer>();
		visited[s] = true;
		st.push(s);
	    //int pushCount=0;
		while(!st.isEmpty()){
			s=st.pop();
            st_new.add(s);
			//System.out.print(s+" ");
            if(s==des){
                break;
            }
			Iterator<Integer> i = adj[s].listIterator();
            int pushCount=0;
			while(i.hasNext()){
				int n=i.next();
				if(!visited[n]){
					visited[n]=true;
                    pushCount=pushCount+1;
					st.push(n);
				}
			}
            //If pushCount is zero then the element is leaf if it is leaf then we have not reached out destination. If not you can push things into stack.
            if(pushCount==0){
                st_new.remove(s);
            }
            System.out.println("The number of elements pushed are ::"+pushCount);
			
		}
            
            //After all the shortes path is 
            
            for (Integer stemp : st_new) {
    System.out.println("The path elements are ::"+stemp);
}
	}
}