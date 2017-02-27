import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PoisionTree {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
       // Scanner sc=new Scanner(System.in);
       // int size=sc.nextInt();
        int[] arr={3,1,10,7,3,5,6,6};
       /* for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
            size
        }*/
        getResult(arr);
    }
    static void getResult(int[] arr){
        Stack<Integer> st=new Stack<Integer>();
        st.push(0);
        int count=0;
        int maxCount=0;
        for(int i=1;i<arr.length;i++){
            //If the previous element more than the existing element;
            if(arr[i-1]>=arr[i]){
                if(arr[st.peek()] >= arr[i]){
                    //System.out.println("Pushing the arr[i] element ::"+arr[i]);
                    if(maxCount<count)
                   maxCount=count;
                    count=0;
                    st.push(i);
                }else{
                    
                   // SYstem.out.println("The element ");
                	
                    count=count+1;
                    
                   // System.out.println("The count is ::"+count);
                } 
            }else{
            	
            	if(count<1)
            	count=1;
            }
        }
        
        if(maxCount<count)
            maxCount=count;
        
        System.out.println(maxCount);
    }
}
