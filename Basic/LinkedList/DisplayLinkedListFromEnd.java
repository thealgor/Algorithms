public class DisplayLinkedListFromEnd{
   private class Node{
   	Node next;
   	int data;
   	public Node(int data, Node next){
   		this.data = data;
   		this.next = next;
   	}
   }
   public void displayFromEnd(Node head){
   	if(head==null)
   		return;
   	displayFromEnd(head.next);
   	System.out.println(head.data);
   }
   public void test(){
     Node head = new Node(1000, null);
     Node curr = head;
     for(int i=0;i<20;i++){
     	Node newNode = new Node(i,null);
     	curr.next = newNode;
     	curr = newNode;

     }
       displayFromEnd(head);
   }
   public static void main(String[] args){
   	DisplayLinkedListFromEnd d = new DisplayLinkedListFromEnd();
   	d.test();
   }
}