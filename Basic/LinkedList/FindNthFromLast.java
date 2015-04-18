public class FindNthFromLast{
    private static class Node{
       Node next;
       int data;
       public Node(int data, Node next){
       	this.data = data;
       	this.next = next;
       }
    }
    public static Node findNth(Node head, int n){
        /* nmove till n and have a second ptr after that*/
        Node curr = head;
        for(int i=0;i<n;i++){
        	if(curr==null)
        		throw new IllegalArgumentException("n should be less than size of the linked list");
        	curr = curr.next;
        }
        Node secondPtr = head;

        while(curr!=null){
           curr = curr.next;
           secondPtr = secondPtr.next;
        }
        return secondPtr;
    }


	public static void main(String[] args){
		Node head = new Node(-1,null);
		Node curr = head;
		for(int i=0;i<10;i++){
			Node newNode = new Node(i,null);
			curr.next = newNode;
			curr=newNode;
		}
       Node result1 = findNth(head,9);
       System.out.println(result1.data);
       Node result2 = findNth(head, 15);
       System.out.println(result2.data);

	}
}