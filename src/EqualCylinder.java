import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        List<Integer> h1 = new ArrayList<Integer>();
        int height1=0;
        int height2=0;
        int height3=0;
        for(int h1_i=0; h1_i < n1; h1_i++){
            h1.add(in.nextInt());
            height1=height1+ h1.get(h1_i);
        }
        List<Integer> h2 = new ArrayList<Integer>();
        for(int h2_i=0; h2_i < n2; h2_i++){
                 h2.add(in.nextInt());
            height2=height2+ h2.get(h2_i);
        }
         List<Integer> h3 = new ArrayList<Integer>();
        for(int h3_i=0; h3_i < n3; h3_i++){
             h3.add(in.nextInt());
            height3=height3+ h3.get(h3_i);
        }
        
        findMaxHeight(h1,h2,h3,height1,height2,height3);
    }
    
    public static void findMaxHeight(List<Integer> h1,List<Integer> h2,List<Integer> h3,int ht1,int ht2,int ht3){
        
        while( !h1.isEmpty() && !h2.isEmpty() && !h3.isEmpty()) {
        if (ht1 > ht2) {
            ht1 = ht1 - h1.remove(0);
        } else if (ht2 > ht3) {
            ht2 = ht2 - h2.remove(0);
        } else {
            ht3 = ht3 - h3.remove(0);
        }
        if (ht1 == ht2 && ht2 == ht3) {
            break;
        }
    }
        
        if(h1.isEmpty()|| h2.isEmpty()||h3.isEmpty()){
            System.out.println(0);
        }else{
            
        
        System.out.println(ht1);
        }
    
    }
    
    
    
}
