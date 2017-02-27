import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solutio*/
        Scanner sc=new Scanner(System.in);
        
        int tstCount=sc.nextInt();
        for(int i=0;i<tstCount;i++){
            int size=sc.nextInt();
            int mod=sc.nextInt();
            int[] arr=new int[size];
            for(int j=0;j<size;j++){
                arr[j]=sc.nextInt();
                
            }
            System.out.println(maxCount(arr,mod));
        }
    }
    
    static int maxCount(int[] arr,int mod){
        //System.out.println("the mod is ::"+mod);
        int max_so_far=arr[0]%mod;
        int curr_max=arr[0]%mod;
         for (int i = 1; i < arr.length; i++)
        {
            curr_max = max(arr[i]%mod,( curr_max+arr[i])%mod);
           //  System.out.println("The max value is ::"+curr_max);
            max_so_far = max(max_so_far, curr_max);
         }
        //System.out.println("the max so far is ::"+max_so_far);
        return (max_so_far);
        
        
    }
    static int max(int a,int b){
        return (a>b?a:b);
    }
}