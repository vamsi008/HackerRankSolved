
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner sc = new Scanner(System.in);
        
        int size=sc.nextInt();
        Map<Integer,Integer> sampleMap=new HashMap<Integer,Integer>();
         int max=0;
        for(int i=0;i<size;i++){
            
            int tempValue=sc.nextInt();
           
            if(sampleMap.get(tempValue)!=null){
                
                int count=sampleMap.get(tempValue);
                sampleMap.put(tempValue,count+1);
                if(count+1>max){
                    max=count;
                }
            }else{
                if(1>max){
                    max=1;
                }
                sampleMap.put(tempValue,1);
            }
            
        }
        if(size==1){
             System.out.println(0);            

        }else{
        System.out.println(size-max-1);
        }
    }
}