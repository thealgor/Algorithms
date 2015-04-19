public class PointerToGivenNodeDelete{
	private static class Node{
		private int data;
		private Node next;
		public Node(int data, Node next){
			this.data =data;
			this.next = next;
		}
	}
	public static void deleteNode(Node ptr){
		if(ptr==null || ptr.next==null)
			throw new IllegalArgumentException("Send the node somewhwer in the middle of a linked list");
		Node nextNode = ptr.next;
		int tempdata = nextNode.data;
		ptr.data = tempdata;
		ptr.next = nextNode.next;
		nextNode.next=null;
	}
	//no testing needed I guess.
}