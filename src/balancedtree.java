
/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/
    boolean checkBST(Node root) {
        
       // Node temp=root;
        boolean isBalanced=true;
        Stack<Node> que = new Stack<Node>();
        List<Integer> node_data=new LinkedList<Integer>();
       
        //que.push(root);
        Node temp=root;
        //Node left=root.left;
        while(temp!=null){
            
            que.push(temp);
            temp=temp.left;
        }
        while(!que.isEmpty()){
            Node temp1=que.pop();
            
            if(node_data.isEmpty()){
                node_data.add(temp1.data);
            }else{
                if(node_data.get(node_data.size()-1)>temp1.data){
                  //  System.out.println("the node at the previous end is ::"+node_data.get(node_data.size()-1) +":: The node value is ::"+temp1.data);
                    isBalanced=false;
                    break;
                }else{
                     node_data.add(temp1.data);
                }
            }
            Node right=temp1.right;
            if(right!=null){
              
                   //que.push(right);
                 
                
                while (right != null) {
                    que.push(right);
                    right = right.left;
                }
            }
        }

       
        
        return isBalanced;
        
    }

 


   

