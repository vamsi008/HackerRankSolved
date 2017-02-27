
public class Insertion {

	
	public static void main(String[] args){
		
		
		int arr[]={4,2};
		insertIntoSorted(arr);
		
	}
	
	
	public static void insertIntoSorted(int[] ar) {
      int size=ar.length,i;
      int temp=ar[size-1];
      for(i=size-1;i>=0;i--){
    	  System.out.println("The value os the array positions is ::"+i+"  :: "+temp );	  
    	 if(ar[i]>temp){
    		  ar[i+1]=ar[i];
    	  }else{
    		  ar[i]=temp;
    	  }
    	  printArray(ar);
      }
      System.out.println("The value of n is ::"+i);
      if(i==-1){
    	  
    	  ar[i+1]=temp;
      }
      
      printArray(ar);
     
		
		
    }
	
	   private static void printArray(int[] ar) {
	        for(int n: ar){
	            System.out.print(n+" ");
	        }
	        System.out.println("");
	    }
}
