
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner sc=new Scanner(System.in);
        List<Node> list=new ArrayList<Node>();
        
        int cases=sc.nextInt();
        
        for(int i=0;i<cases;i++){
            int temp1=sc.nextInt();
            int temp2=sc.nextInt();
            
            if(list.size()==0){
                
                Node node1=new Node(temp1,null);
                Node node2=new Node(temp2,node1);
                list.add(node1);
                list.add(node2);
            }else{
                Node node1=null;
                Node node2=null;
                for(Node temp:list){
                    
                    if(temp.data==temp1){
                       if(temp.parent!=null){
                           while(temp.parent!=null){
                               temp=temp.parent;
                           }
                           node1=temp;
                       }else{
                           node1=temp;
                       }
                        break;
                    }
                    
                }
                
                  for(Node temp_node:list){
                    
                    if(temp_node.data==temp2){
                       if(temp_node.parent!=null){
                           while(temp_node.parent!=null){
                               temp_node=temp_node.parent;
                           }
                           node2=temp_node;
                       }else{
                           node2=temp_node;
                       }
                    }
                    
                }
                
                if(node1==null && node2==null){
                 node1=new Node(temp1,null);
                node2=new Node(temp2,node1);
                
                }else{
                    if(node1==null && node2!=null){
                        
                        node1=new Node(temp1,node2);
                    }else{
                        if(node1!=null && node2==null){
                         
                            node2=new Node(temp2,node1);
                        }else{
                          //  System.out.println("The are node which should be 2 and 6  "+temp1+" ::  "+temp2);
                            if(node1.data!=node2.data){
                            node2.parent=node1; 
                            node1.score=node1.score+node2.score;
                            }
                           // System.out.println("The parent "+node1.data+" score is ::"+node1.score);
                            //System.out.println("The parent "+node2.data+" score is ::"+node2.score);
                        }
                    }
                }
                
                list.add(node1);
                list.add(node2);
       
            }
            
        }
        
        getDisjointSets(list);
        

        
    }
    
    static void getDisjointSets(List<Node> list){
        int min=0;
        int max=0;
        Map<Integer,Integer> map=new TreeMap<Integer,Integer>();
        
        for(Node temp:list){
         
         
            
            if(temp.parent==null){
                
                int score=temp.score;
                 //System.out.println("The score for ::"+temp.data+ " is ::"+score);
               if(min==0 || score<min ){
                min=score;
            }
            if(max==0 || score>max){
                max=score;
            }
                
            }
          
            
        }
        
     
        
        
        System.out.println(min+ " "+max);
    }
    
    
   
}

 class Node{
        Node parent;
        int data;
        int score=1;
        
        public Node(int data,Node parent){
            
            this.data=data;
            
            this.parent=parent;
            if(parent!=null){
            parent.score=parent.score+this.score;
            }
        }
    }