
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN.Print output to STDOUT. Your class should be named Solution. */
        
        Scanner sc =new Scanner(System.in);
        int size=sc.nextInt();
        //List<Point> tempList=new ArrayList<Point>();
         Queue<Point> queue = new LinkedList<Point>();
        for(int i=0;i<size;i++){
            int petrol=sc.nextInt();
            int dist=sc.nextInt();
            //So the distance and the petrol are the same needed.
            queue.add(new Point(dist,petrol,i));
            
        }
        
        cal(queue,size);
        //SortedMap<K, V>
    }
    
    public static void cal(Queue<Point> queue,int size){
        int petrol=0;
       
        List<Point> tempList=new ArrayList<Point>();
        while(!queue.isEmpty()){
            Point tempPoint=queue.poll();
            petrol=petrol+tempPoint.petrol;
            if(petrol<tempPoint.dist){
                
                //Reset the petrol to 0
                petrol=0;
                //min=0;
                for(Point temp:tempList){
                    queue.add(temp);
                }
                 queue.add(tempPoint);
                
                 tempList=new ArrayList<Point>();
                
            }else{
                 petrol=petrol-tempPoint.dist;       
                tempList.add(tempPoint);
                
            }
            
        }
      
        System.out.println(tempList.get(0).index);
    }
        
     
}

class Point{
    int dist;
    int petrol;
    int index;
    public Point(int dist,int petrol,int index){
        
        this.dist=dist;
        this.petrol=petrol;
        this.index=index;
    }
}
