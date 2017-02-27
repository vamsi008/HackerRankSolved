import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
   static List<Integer> heap=new ArrayList<Integer>();

    public static void main(String[] args) {
    	
    	Set<Integer> s=new HashSet<Integer>();
    	
    
       Scanner sc=new Scanner(System.in);
       int optCount=sc.nextInt();
        for(int i=0;i<optCount;i++){
            int opt=sc.nextInt();
            if(opt==1){
                //insert a node.
                int insertNode=sc.nextInt();
                heap.add(insertNode);
          ;
                rearrage();
                ///minHeap();
                 // int minNode=getParent(heap.size()-1);
                
                //System.out.println(minNode);
                
                
            }
            
            if(opt==2){
                
                int deleteNode=sc.nextInt();
                //delete a node.
               // System.out.println("To delete the node");
                delete(deleteNode);
            }
            if(opt==3){
                int size=heap.size()-1;
               // System.out.println("Get parent:: for the size::"+size);
                
              // int minNode=getParent(0);
                
                System.out.println(heap.get(0));
                //print the min element from the heap;
                
                
            }
          
        }
        
      
    }
    
    public static void rearrage(){
        int size=heap.size()-1;
        while(heap.get(size) < getParent(size)){
            swap(size, size/2);
            size=size/2;
        }
    }
    
   public static int getParent(int pos){
        return heap.get((pos/2));
    }
    
    public static int leftChild(int pos){
        return heap.get(2*pos);
    }
    
       public static int rightChild(int pos){
        return heap.get((2*pos)+1);
    }
    
     private static void swap(int fpos, int spos)
    {
        int tmp;
        tmp = heap.get(fpos);
         heap.set(fpos,heap.get(spos));
        //Heap[fpos] = Heap[spos];
         heap.set(spos,tmp);
        //Heap[spos] = tmp;
    }
    
      private static void minHeapify(int pos)
    {
        if (!isLeaf(pos))
        { 
            if ( heap.get(pos) > leftChild(pos)  || heap.get(pos) > rightChild(pos))
            {
                if (heap.get(pos) > leftChild(pos))
                {
                    swap(pos, 2*pos);
                    minHeapify(2*pos);
                }else
                {
                    swap(pos, (2*pos)+1);
                    minHeapify((2*pos)+1);
                }
            }
        }
    }
    
       private static  boolean isLeaf(int pos)
    {
           int size=heap.size();
        if (pos >=  (size / 2)  &&  pos <= size)
        { 
            return true;
        }
        return false;
    }
    
    
    private static void delete(int val){
        int size=heap.size()-1;
        
        int tempVal=heap.get(size);
        //System.out.println("Into the delete functions");
        //int temp
      
        int pos=size/2;
        boolean found=false;
        //int i=0;
        for(int i=0;i<size;i++){
            
          
            if(heap.get(i)==val){
                found=true;
                //heap.add(i,tempVal);
                heap.remove(i);
            }  
            //i=i+1;
        }
        
          //heap.remove(size);
  
        
        if(found){
            //System.out.println("Found the value");
            rearrage();
        }
        
    }
    
    
    public static void minHeap()
    {
        int size=heap.size()-1;
        for (int pos = (size / 2); pos >= 1 ; pos--)
        {
            minHeapify(pos);
        }
    }
    
    public static void print()
    {
        int size=heap.size();
        for (int i = 1; i <= size / 2; i++ )
        {
            System.out.print(" PARENT : " + heap.get(i));
            if(2*i <= size-1)
            System.out.print(" LEFT CHILD : " +  heap.get(2*i));
            if(2*i+1 <= size-1)
            System.out.print(" RIGHT CHILD :" + heap.get(2 * i  + 1));
            System.out.println();
        } 
    }
    
     
    
}