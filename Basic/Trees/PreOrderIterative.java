import java.util.*;
public class PreOrderIterative{
	private class Node{
		private int data;
		private Node left;
		private Node right;
		public Node(int data, Node left, Node right){
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	//DLR
	public void preOrderRecursive(Node head){
		if(head == null)
			return;
		System.out.println(head.data);
		preOrderRecursive(head.left);
		preOrderRecursive(head.right);
	}

	public void preOrderIterative(Node root){
		Stack<Node> st = new Stack<Node>();
		while(true){
			while(root!=null){ //was always using st.empty() here, so not working.
           	  		System.out.println(root.data);
           	  		st.push(root);
           	  		root = root.left;
           		}
                if(st.isEmpty())
                	break;
				root = st.pop();
                root = root.right;
           }
       }

	public void preOrderIterativeBetter(Node root){
		Stack<Node> st = new Stack<Node>();
		st.push(root);
		while(!st.isEmpty()){
			Node curr = st.pop();
			System.out.println(curr.data);
			if(curr.right!=null)
				st.push(curr.right);
			if(curr.left!=null)
				st.push(curr.left);
		}
	}

	public void test(){
		Node four = new Node(4,null,null);
		Node five = new Node(5, null, null);
		Node six = new Node(6,null, null);
		Node seven = new Node(7,null,null);
		Node two = new Node(2,four,five);
		Node three = new Node(3,six,seven);
		Node one = new Node(1,two, three);
		preOrderIterative(one);
		System.out.println("Recursive code");
		preOrderRecursive(one);
		System.out.println("Better Solution");
		preOrderIterativeBetter(one);
	}

	public static void main(String[] orgs){
		PreOrderIterative p = new PreOrderIterative();
		p.test();
	}
}