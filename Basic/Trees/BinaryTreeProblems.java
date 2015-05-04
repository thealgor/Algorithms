/**
 * Created by sunil.kksubramanyam on 4/30/15.
 */
import java.util.*;
public class BinaryTreeProblems {

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
	public boolean searchRecursive(Node root, int data){
		if(root == null)
			return false;
		if(root.data == data)
			return true;
		return searchRecursive(root.left,data)||searchRecursive(root.right,data);
	}

	public boolean searchIterative(Node root, int data){
		if(root == null)
			return false;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()){
			Node temp = q.remove();
			if(temp.data==data)
				return true;
			if(temp.left!=null){
				q.add(temp.left);
			}
			if(temp.right!=null){
				q.add(temp.right);
			}
		}
	 return false;
	}

	public int getMaxRecursive(Node root){
		if(root ==null)
		   return Integer.MIN_VALUE;
		return Math.max(Math.max(getMaxRecursive(root.left),getMaxRecursive(root.right)),root.data);
		/*
		   if(root == null) return Integer.MIN_VALUE;
		   int left = getMaxRecursive(root.left);
		   int right = getMaxRecursive(root.right);
		   return Math.max(Math.max(left,right),data);
		 */

	}

	public int getMaxIterative(Node root){
		if(root==null)
			return Integer.MIN_VALUE;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		int max = Integer.MIN_VALUE;
		while(!q.isEmpty()){
			Node temp = q.remove();
			max = Math.max(temp.data,max);
			if(temp.left!=null)
				q.add(temp.left);
			if(temp.right!=null)
				q.add(temp.right);
		}
		return max;
	}

	//print level order in reverse

	public void printLevelOrderInReverse(Node root){
		if(root==null)
			return;
		Queue<Node> q = new LinkedList<Node>();
		Stack<Node> st = new Stack<Node>();
		q.add(root);
		while(!q.isEmpty()){
			Node temp = q.remove();
			st.add(temp);
			if(temp.right!=null)
				q.add(temp.right);
			if(temp.left!=null)
				q.add(temp.left);

		}
		while(!st.isEmpty()){
			System.out.println(st.pop().data);
		}

	}

	//depth of the tree
	public int depth(Node root){
		if(root==null)
			return 0;
		return 1+Math.max(depth(root.left),depth(root.right));
	}

	//depth of the tree iterative

	public int depthIterative(Node root){
		if(root==null)
			return 0;
		Queue<Node> q = new LinkedList<Node>();
		int count = 0;
		q.add(root);
		q.add(null);
		while(!q.isEmpty()){
			Node temp = q.remove();
			if(temp==null){
				count++;
				if(!q.isEmpty())
					q.add(null);
			}
			else{
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
			}
		}
		return count;
	}

	public void insertNode(Node root, int data){
        Node newNode = new Node(data,null,null);
		if(root==null){
			root = newNode;
			return;
		}

		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()){
			Node temp = q.remove();
			if(temp.left!=null){
				q.add(temp.left);
			}
			else if(temp.left==null){
				temp.left = newNode;
				break;
			}
			if(temp.right!=null){
				q.add(temp.right);
			}
			else if(temp.right==null){
				temp.right = newNode;
				break;
			}
		}
	}

	public Node delete(Node root, int data){
		return null;
	}

	public Node deepestNode(Node root){
		if(root == null)
			return null;
		Queue<Node> q = new LinkedList<Node>();
		Node prev = null;
		q.add(root);
		q.add(null);
		while(!q.isEmpty()){
			Node temp = q.remove();
			if(temp==null){
				if(q.isEmpty())
					return prev;
				continue;
			}
			else{
				prev = temp;
			}
			if(temp.left!=null){
				q.add(temp.left);
			}
			if(temp.right!=null)
				q.add(temp.right);
		}
		return prev;
	}

	public Node deepestNodeRecursive(Node root){

	 return null;
	}


	public void test(){
		Node ten = new Node(10,null,null);
		Node nine = new Node(9,null,null);
		Node eight = new Node(8,ten,null);
		Node four = new Node(4,null,null);
		Node five = new Node(5, null, eight);
		Node six = new Node(6,nine, null);
		Node seven = new Node(7,null,null);
		Node two = new Node(2,four,five);
		Node three = new Node(3,six,seven);
		Node one = new Node(1,two, three);
		System.out.println("Output");
		System.out.println("1.searchRecursive");
		boolean res1 = searchRecursive(one, 9);
		System.out.println(res1);
		boolean res2 = searchRecursive(one, 15);
		System.out.println(res2);
		System.out.println("2.searchIterative");
		boolean res3 = searchIterative(one,9);
		System.out.println(res3);
		boolean res4 = searchIterative(one, 15);
		System.out.println(res4);
		System.out.println("3.Maximum iterative");
		int res5 = getMaxIterative(one);
		System.out.println(res5);
		System.out.println("4.Maximum recursive");
		int res6 = getMaxRecursive(one);
		System.out.println(res6);
		System.out.println("5.Print Level Order in reverse");
		printLevelOrderInReverse(one);
		System.out.println("6.Depth iterative");
		int res7 = depthIterative(one);
		System.out.println(res7);
		System.out.println("7.Depth recursive");
		int res8 = depth(one);
		System.out.println(res8);
		System.out.println("8.insert node 15");
		insertNode(one,15);
		printLevelOrderInReverse(one);
		//System.out.println("Delete node 15");
        //delete(one,15);
		System.out.println("DeepestNode");
		Node res9 = deepestNode(one);
		if(res9!=null)
			System.out.println(res9.data);
	}

	public static  void main(String[] args){
		BinaryTreeProblems b = new BinaryTreeProblems();
		b.test();
	}







}
