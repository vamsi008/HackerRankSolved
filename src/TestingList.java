
public class TestingList {
	
	
	public static void main(String[] args){
		
		Node node =new Node(1);
		Node head=Node.insert(null, node);
		Node.insert(head, new Node(2));
		Node.insert(head, new Node(3));
		
		head=Node.Delete(head, 0);
		System.out.println("The value in the head is ::"+head.data);
		
		Node temp=head;
		while(temp!=null){
			System.out.println(temp.data);
			temp=temp.next;
		
		}
		
		
	}

}

class Node {
    int data;
    Node next;
    
    public Node(int data){
    	this.data=data;
    }
    
    static Node  insert(Node head,Node newNode){
    	
    	if(head==null){
    		head=newNode;
    		return head;
    	}
    	Node temp=head;
    	while(temp.next!=null){
    		temp=temp.next;	
    	}
    	
    	temp.next=newNode;
    	
    	return head;
    }
    
    
    static Node  Delete(Node head, int position) {
    
    	    if(position==0){
    	        Node temp=head;
    	        head=head.next;
    	        //System.out.println("The data in the head is ::"+head.data);
    	        

    			Node temp1=head;
    	        return head;
    	    }else{
    	        int count=0;
    	        Node temp1=head;
    	        Node prev=temp1;
    	        while (count<position){
    	            prev=temp1;
    	            temp1=temp1.next;
    	            count=count+1;
    	        }
    	        
    	        prev.next=temp1.next;
    	        return head;
    	    }
    }
 }
