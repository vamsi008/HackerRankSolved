import java.util.Collections;
import java.util.List;

public class TrieTree {

	public static void main(String args[]) {

		Node root = new Node('0',true);
		insertNode(root,"hacker");
		insertNode(root,"hackerrank");
		System.out.println("The number of occurences is ::"+search(root,"hac"));

	}

	static void insertNode(Node root, String s) {
		Node temp_root = root;

		for (int i = 0; i < s.length(); i++) {

			char t = s.charAt(i);
			int index = (int) t;
			List<Node> child = temp_root.children;
			Node temp = child.get(index - 97);
			if (temp.data == '0') {
				temp.data = t;
				temp.occurences = temp.occurences + 1;
			} else {

				temp.occurences = temp.occurences + 1;
			}

			temp_root = temp;

		}

	}

	static int search(Node root, String word) {

		Node temp_root = root;
		int occurences = 0;
		for (int i = 0; i < word.length() && temp_root != null; i++) {

			List<Node> children = temp_root.children;
			char t = word.charAt(i);
			int index = (int) t;
			Node temp = children.get(index - 97);
			if (temp.data != t) {
				occurences = temp.occurences;
				break;
			} else {

				temp_root = temp;
			}

		}
		
		if(temp_root==null){
			occurences=0;
		}

		return occurences;

	}

}


class Node {

	List<Node> children = Collections.nCopies(23, new Node());


	char data;

	boolean isRoot = false;

	int occurences = 0;

	public Node() {
		this.data = '0';
	}

	public Node(char data) {
		this.data = data;
		this.occurences = this.occurences + 1;

	}

	public Node(char data, boolean isRoot) {

		this.data = data;
		this.isRoot = isRoot;
	}

}
