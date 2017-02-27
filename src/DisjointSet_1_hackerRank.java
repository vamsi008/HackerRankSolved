import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	//ConcurrentHashMap<K, V>
        
        Scanner sc =new Scanner(System.in);
       // List<Node> list=new ArrayList<Node>();
        int size=sc.nextInt();
        int queries=sc.nextInt();
        int[] set=new int[size+1];
        for(int i=0;i<queries;i++){
            
            String op=sc.next();
             int temp1=Integer.parseInt(sc.next()); 
            int temp2=-1;
            if(op.equals("M")){
                  temp2=Integer.parseInt(sc.next()); 
             
                addNode( temp1, temp2, set);
            }else{
              //  set[temp1]=temp1;
                getSetCount(temp1,set);
            }
               //System.out.println("The two values are ::"+op +  " ::: "+temp +" :: "+temp2);
            
        }
    }
    
    static void addNode(int temp1,int temp2,int[] set){
        
        int firstVal=set[temp1];
        int secondVal=set[temp2];
        
        if(firstVal==0 || secondVal==0){
            if(firstVal==0 && secondVal==0 ){
            set[temp1]=temp1;
            set[temp2]=temp1;
            }else{
                if(firstVal==0 && secondVal!=0){
                    set[temp1]=secondVal;
                }else{
                    if(firstVal!=0 && secondVal==0){
                        set[temp2]=firstVal;
                    }
                }
            }
        }else{
            
            //When both are parents.    
            if(firstVal==temp1 && secondVal==temp2){
                
                    set[temp2]=temp1;
                    for(int i=1;i<set.length;i++){
                        if(set[i]==secondVal){
                            set[i]=firstVal;
                        }
                    }
                
            }else{
                
               
                    
                    for(int i=1;i<set.length;i++){
                        if(set[i]==secondVal){
                            set[i]=firstVal;
                        }
                    }
              
                
            }
            
           
        }
        
        
    }
    
    
    static  void getSetCount(int temp1,int[] set){
        int tempVal=set[temp1];
        if(tempVal==0){
            set[temp1]=temp1;
            System.out.println(1);
        }else{
            if(tempVal==temp1){
                int count=0;
                for(int i=0;i<set.length;i++){
                    
                    if(set[i]==tempVal){
                        count=count+1;
                    }
                 }
                  System.out.println(count);
                }else{
                    boolean flag=false;
                    while(!flag){
                        
                        int tempo=set[tempVal];
                        if(tempo==tempVal){
                            flag=true;
                            break;
                        }
                        tempVal=tempo;
                        
                    }
                    
                     int count=0;
                    for(int i=0;i<set.length;i++){
                    
                    if(set[i]==tempVal){
                        count=count+1;
                    }
                    
                    
                }
                 System.out.println(count);
            }
        }
    }
}