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
                q.add(curr.left);
            if(curr.right!=null)
                q.add(curr.right);
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

