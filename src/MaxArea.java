import java.util.Stack;

public class MaxArea {
	
	public static void main(String args[]){
		
		
		int arr[]={8979,4570,6436,5083,7780,3269,5400,7579,2324,2116};
		Stack<Integer> st_bar = new Stack<Integer>();
		Stack<Integer> st_pos=new Stack<Integer>();
		int maxArea=0;
		int pos=0;
		for(int i=0;i<arr.length;i++){
			
			if(st_bar.isEmpty()){
				st_bar.push(arr[i]);
				st_pos.push(i);
			}else{
					if(st_bar.peek()<arr[i]){
						st_bar.push(arr[i]);
						st_pos.push(i);
					}else{
						while(!st_bar.isEmpty() && st_bar.peek()>arr[i]){
							int[] result=calculateArea(st_bar,st_pos,i,maxArea);
							maxArea=result[0];
							pos=result[1];
						}
						
						st_bar.push(arr[i]);
						st_pos.push(pos);
					}
			}
			
		}
		
		System.out.println("The max area is ::"+maxArea);
	}
	
	static int[] calculateArea(Stack<Integer> st_bar,Stack<Integer> st_pos,int curr_pos,int maxArea){
		
		int tempMax=st_bar.pop();
		
		int pos=st_pos.pop();
		int area=tempMax*(curr_pos-pos);
		
		if(maxArea<area){
			maxArea=area;
		}
		
		return new int[]{maxArea,pos};
		
	}

}
