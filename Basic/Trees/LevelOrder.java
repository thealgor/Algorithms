/**
 * Created by sunil.kksubramanyam on 4/27/15.
 */

import java.util.*;
public class LevelOrder {
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
    /*
       If a collection refuses to add a particular element for any reason other than that it already contains the element, it must throw an exception (rather than returning false).
       This preserves the invariant that a collection always contains the specified element after this call returns.

       that when element can not be added to collection the add method throws an exception and offer does'nt.
       The difference is that offer() will return false if it fails to insert the element on a size restricted Queue, whereas add() will throw an IllegalStateException.
       You should use offer() when failure to insert an element would be normal, and add() when failure would be an exceptional occurrence (that needs to be handled).
     */
    public List<Integer> levelOrderTraversal(Node root){
        if(root == null)
            return null;
        Queue<Node> q = new LinkedList<Node>();
        List<Integer> res = new ArrayList<Integer>();
        q.add(root);
        while(!q.isEmpty()){
            Node curr = q.remove();
            res.add(curr.data);
            if(curr.left!=null)
                q.add(curr.left); //q.offer(curr.left);
            if(curr.right!=null)
                q.add(curr.right); //q.offer(curr.right);
        }
        return res;
    }

    public void test(){
		Node four = new Node(4,null,null);
		Node five = new Node(5, null, null);
		Node six = new Node(6,null, null);
		Node seven = new Node(7,null,null);
		Node two = new Node(2,four,five);
		Node three = new Node(3,six,seven);
		Node one = new Node(1,two, three);
		List<Integer> res = levelOrderTraversal(one);
        for(Integer i: res){
            System.out.println(i);
        }
	}

    public static void main(String[] args){
        LevelOrder l = new  LevelOrder();
        l.test();
    }


}

