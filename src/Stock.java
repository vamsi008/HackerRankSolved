import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Stock {

	
	
/*	1,
	1,
	3,
	1,
	2,
	6,
	1,
*/
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */ 

		// Scanner sc = new Scanner(System.in);

		// int size=sc.nextInt();
		int[] arr = {6,5,8,4,7,10,9};
		 Boolean done=false;
		List<Integer> st = new LinkedList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			st.add(arr[i]);
		}
		int count=0;
		while(!done){
			int prev=st.size();
			st = getStockSpan(st,done);
			int next=st.size();
			if(prev==next){
				done=true;
				break;
			}
			count=count+1;
		}
		
		System.out.println("The attempts is ::"+count);
		
	}

	static List<Integer> getStockSpan(List<Integer> stockPriceList,Boolean done) {
		List<Integer> stockSpanList = new ArrayList<Integer>();
		List<Integer> modifiedList=new ArrayList<Integer>();
		stockSpanList.add(0, 1);
		modifiedList.add(0,stockPriceList.get(0));
		Stack<Integer> s = new Stack<Integer>();
		s.push(0);
		int index=1;
		for (int i = 1; i < stockPriceList.size(); i++) {

			while (!s.isEmpty() && stockPriceList.get(s.peek()) < stockPriceList.get(i)) {
				s.pop();

			}
			int count=0;
			if (!s.isEmpty()) {
			 count=	i - s.peek();
				//stockSpanList.add(i, i - s.peek());
			} else {
				count=i+1;
				//stockSpanList.add(i, i + 1);
			}
			
			if(count==1){
				modifiedList.add(index, stockPriceList.get(i));
				index=index+1;
				
			}
			stockSpanList.add(i, count);

			s.push(i);
		}
		return modifiedList;
	}
}
