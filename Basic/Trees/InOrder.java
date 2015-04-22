import java.util.*;
public class InOrder{
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
	public void inOrderIterative(Node root){
	   Stack<Node> st = new Stack<Node>();
	   while(true){
	      while(root!=null){
	      	st.push(root);
	      	root = root.left;
	      }
 		  if(st.isEmpty())
 		     break;
 		  root = st.pop();
 		  System.out.println(root.data);
 		  root = root.right;
		}
	}

	 //LDR
    public void inOrderRecursive(Node head){
    	if(head == null)
    		return;
    	inOrderRecursive(head.left);
    	System.out.println(head.data);
    	inOrderRecursive(head.right);
    }

	public void test(){
		Node four = new Node(4,null,null);
		Node five = new Node(5, null, null);
		Node six = new Node(6,null, null);
		Node seven = new Node(7,null,null);
		Node two = new Node(2,four,five);
		Node three = new Node(3,six,seven);
		Node one = new Node(1,two, three);
		inOrderIterative(one);
		System.out.println("Recursive code");
		inOrderRecursive(one);
	}
    
    public static void main(String[] args){
    	InOrder i = new InOrder();
    	i.test();
    }

}