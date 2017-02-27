import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution.*/
        
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        Map<String,Integer> sample=new TreeMap<String,Integer>();
        for(int i=0;i<s.length();i++){
            Integer count=sample.get( String.valueOf(s.charAt(i)));
            if(count==null){
                count=1;
            }else{
                count=count+1;
                
            }
            sample.put(String.valueOf(s.charAt(i)),count);
        }
        Set<Integer> temp=new HashSet<Integer>();
        for (Map.Entry<String, Object> entry : sample.entrySet()) {
                 // String key = entry.getKey();
                  //Object value = entry.getValue();
            temp.add(entry.getValue());
                  
        }
        
        if(temp.size()==1){
            System.out.println("YES");
        }else{
            if(temp.size >2 ){
                System.out.println("NO");
            }else{
              
                    temp.toArray(arr);
                   
            }
        }
    }
}
