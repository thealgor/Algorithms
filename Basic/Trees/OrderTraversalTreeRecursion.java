public class OrderTraversalTreeRecursion{
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
    public void prorder(Node head){
    	if(head == null)
    		return;
    	System.out.println(head.data);
    	preorder(head.left);
    	preorder(head.right);
    }
    
    //LDR
    public void inorder(Node head){
    	if(head == null)
    		return;
    	inorder(head.left);
    	System.out.println(head.data);
    	inorder(head.right);
    }

    //LRD
    public void postOrder(Node head){
    	if(head == null)
    		return;
    	postOrder(head.left);
    	postOrder(head.right);
    	System.out.println(head.data);
    }
}