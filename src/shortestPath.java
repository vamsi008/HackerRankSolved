
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution.*/
        
        Scanner sc =new Scanner(System.in);
        
        int testCases=sc.nextInt();
        for(int j=0;j<testCases;j++){
        int vertices=sc.nextInt();
          //System.out.println("The vertices us  ::"+vertices);
        int edges =sc.nextInt();
        int[][] graph=new int[vertices+1][vertices+1];
     
        
        for(int i=0;i<edges;i++){
             
            int x=sc.nextInt();
            int y=sc.nextInt();
            graph[x][y]=6; 
             graph[y][x]=6;
            }
            
            int rootEdge=sc.nextInt();
           
           shortestPath(graph,rootEdge,vertices);
             System.out.println();
        }
    }
    
    static void shortestPath(int[][] graph,int rootNode,int vertices){
        
        int[] dist=new int[vertices+1];
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
            for(int v=0;v<=vertices;v++){
                 if (!sptSet[v] && graph[u][v]!=0 && dist[u] != Integer.MAX_VALUE &&  dist[u]+graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
                //System.out.println("The distance at v is ::"+v+" value ::"+dist[v]);
            }
        }
         
        for(int p=1;p<dist.length;p++){
           // System.out.println("Failing at the index ::"+p);
            int sample=dist[p];
            if(dist[p] == Integer.MAX_VALUE){
                sample=-1;
            }
            if(dist[p]!=0)
            System.out.print(sample+" ");
        }
               
    }
    
   static   int minDistance(int dist[], Boolean sptSet[])
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index=-1;
 
        for (int v = 0; v < sptSet.length; v++)
            if (sptSet[v] == false && dist[v] <= min)
            {
                min = dist[v];
                min_index = v;
            }
 
        return min_index;
    }
}