/**
 * Created by sunil.kksubramanyam on 4/27/15.
 */
import java.util.*;
public class PostOrderIterative {
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

    public ArrayList<Integer> postOrderIterative(Node root){
        Stack<Node> st = new Stack<Node>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        st.push(root);
        Node curr = null, prev = null;
        while(!st.isEmpty()){
            curr = st.peek();
            if(prev == null || prev.left == curr || prev.right == curr){
                if(curr.left!=null)
                    st.push(curr.left);
                else if(curr.right!=null)
                    st.push(curr.right);
            }
            else if(curr.left == prev){
                if(curr.right!=null)
                    st.push(curr.right);
            }
            else{
                res.add(curr.data);
                st.pop();
            }
            prev = curr;
        }

        return res;
    }

     //LRD
    public void postOrderRecursive(Node head){
    	if(head == null)
    		return;
    	postOrderRecursive(head.left);
    	postOrderRecursive(head.right);
    	System.out.println(head.data);
    }

    public void test(){
		Node four = new Node(4,null,null);
		Node five = new Node(5, null, null);
		Node six = new Node(6,null, null);
		Node seven = new Node(7,null,null);
		Node two = new Node(2,four,five);
		Node three = new Node(3,six,seven);
		Node one = new Node(1,two, three);
		ArrayList<Integer> res = postOrderIterative(one);
        for(Integer i: res){
            System.out.println(i);
        }

		System.out.println("Recursive code");
		postOrderRecursive(one);
	}

    public static void main(String[] args){
        PostOrderIterative p = new  PostOrderIterative();
        p.test();
    }
}
