public class MiddleOfLinkedList{
	private class Node{
	  int data;
	  Node next;
	  public Node(int data, Node next){
        this.data = data;
        this.next = next;
	  }
	}

	public void middleOfLinkedList(Node head){
	  Node slow = head;
	  Node fast = head;
	  while(fast!=null&&fast.next!=null){
	  fast = fast.next.next;
	  slow = slow.next;
	  }
	  System.out.println(slow.data);
	}

	public void test(){
	  Node head = new Node(10, null);
	  int n = 5;
	  Node curr = head;
	  for(int i=0;i<n;i++){
        Node newNode = new Node(i, null);
        curr.next = newNode;
        curr = newNode;
	  }
	  middleOfLinkedList(head);

	}

	public static void main(String[] args){

	 MiddleOfLinkedList m = new MiddleOfLinkedList();
	 m.test();
	}
}