
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc =new Scanner(System.in);
        int nodes=sc.nextInt();
        Node root=new Node(1,1);
        //Node temp=root;
        Queue<Node> que=new LinkedList<Node>();
        que.add(root);
        for(int i=0;i<nodes;i++){
            int left=sc.nextInt();
            int right=sc.nextInt();
             Node temp=que.poll();
             Node leftNode=null;
            Node rightNode=null;
            if(left!=-1){
                leftNode=new Node(left,temp.height+1);
            }
            if(right!=-1){
                rightNode=new Node(right,temp.height+1);
            }
            if(leftNode!=null)
            que.add(leftNode);
            if(rightNode!=null)
            que.add(rightNode);
           
            temp.left=leftNode;
            temp.right=rightNode;
        }
    
        
        
        int refactorTimes=sc.nextInt();
        for(int p=0;p<refactorTimes;p++){
            refactor(root,sc.nextInt());
        }
        
    }
    
    static void refactor(Node head,int height){
        
        
        Queue<Node> que=new LinkedList<Node>();
        que.add(head);
        while(!que.isEmpty() && que.peek()!=null){
            if((que.peek().height%height)==0){
                refactor_height(que,que.peek().height);
               // break;
            }            
            Node temp=que.poll();
            if(temp!=null && temp.left!=null){
            que.add(temp.left);
            }
            if(temp!=null && temp.right!=null){
                que.add(temp.right);
            }
            
        }
        
        printInorder(head);
         System.out.println();
    }
    
    static void printInorder(Node node){
        
         if (node == null)
            return;
 
        /* first recur on left child */
        printInorder(node.left);
 
        /* then print the data of node */
        System.out.print(node.val + " ");
 
        /* now recur on right child */
        printInorder(node.right);
    }
    
    static void refactor_height(Queue<Node> que,int height){
        
        //System.out.println("the elements at height are ::"+height);
        
        while(!que.isEmpty() && que.peek().height==height){
            
            Node temp=que.poll();
            
           // System.out.println("Things that had to be refactored are ::"+temp.val);
            
            Node temp_left=temp.left;
            
            Node temp_right=temp.right;
            
            
               if(temp_left!=null){
                que.add(temp_left);
            }
            
             if(temp_right!=null){
                que.add(temp_right);
            }
            
           
            
            temp.left=temp_right;
            temp.right=temp_left;
            
         
        }
        
    }
    
 
}

   class Node{
        int val;
        int height;
        Node left;
        Node right;
       public  Node(int val,int height){
           this.val=val;
           this.height=height;
           left=null;
           right=null;
        }
    }