import java.util.Scanner;
import java.util.Stack;

public class Stack_E {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
/*		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();

		}*/
		int[] arr={20,5,6,15,2,2,17,2,11,5,14,5,10,9,19,12,5};
		getResult(arr);
	}

	static void getResult(int[] arr) {
		Stack<Integer> st = new Stack<Integer>();
		st.push(arr[0]);
		int count = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[i - 1] && count < 1) {
				count = count + 1;
			} else {
				if (arr[i] < arr[i - 1]) {
					if (st.peek() >= arr[i])
						st.push(arr[i]);
					else
						count = count + 1;
				}
			}
		}

		System.out.println(count);
	}
}