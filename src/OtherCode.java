import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner sc=new Scanner(System.in);
        int testCasesCount=sc.nextInt();
        for(int i=0;i<testCasesCount;i++){
             int size=sc.nextInt();
             int arr[] =new int[size];
             int[] arrCount=new int[size];
             int count=0;
             for(int j=0;j<size;j++){
                 arr[j]=sc.nextInt();
                 count=count+arr[j];
                 arrCount[j]=count;
             }
        
             System.out.println(isValid(arr,arrCount));
        }
    }
    
    public static String isValid(int[] arr,int[] arrCount){
        int size=arr.length;
        for(int i=0;i<arr.length;i++){
            
        
            //Count till i is.
            int prevCount=0;
            int nextCount=0;
            if(i==0){
                prevCount=0;
                nextCount=arrCount[size-1];
            }else{
                prevCount=arrCount[i]-arr[i];
                nextCount=arrCount[size-1]-arrCount[i];
            }
        
              if(prevCount==nextCount){
            return "YES";
        }
        
        }
        return "NO";
    }
    public static boolean sort(int[] arr,int div){
       
        int prevCount=0;
        int nextCount=0;
        for(int i=0;i<=div-1;i++){
            prevCount=prevCount+arr[i];
        }
            
        for(int k=div+1;k<arr.length;k++){
         
            nextCount=nextCount+arr[k];
        }
        
        if(prevCount==nextCount){
            return true;
        }
        
        return false;
    }
}