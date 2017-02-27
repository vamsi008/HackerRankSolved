import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner sc=new Scanner(System.in);
        
        int size=sc.nextInt();
        Stack<Integer> st=new Stack<Integer>();
        int max=0;
        for(int i=0;i<size;i++){
            if(st.isEmpty()){
            st.push(sc.nextInt());
            }else{
                int lowVal=st.peek();
                int nextVal=sc.nextInt();
                int maxVal=lowVal ^ nextVal;
                if(max<maxVal){
                    max=maxVal;
                }
                if(lowVal>nextVal){
                    while(!st.isEmpty() && st.peek()>nextVal){
                        lowVal=st.peek();
                        maxVal=lowVal ^ nextVal;
                         if(max<maxVal){
                            max=maxVal;
                        }
                        st.pop();
                    }
                    st.push(nextVal);
                }else{
                    st.push(nextVal);
                }
                
            }
                
            
        }
        
        System.out.println(max);
    }
}