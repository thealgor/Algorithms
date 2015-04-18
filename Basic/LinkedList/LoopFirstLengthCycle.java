public class LoopFirstLengthCycle{
	private static class Node{
		int data;
		Node next;
		public Node(int data, Node next){
			this.data = data;
			this.next = next;
		}
	}
	public static void findCycleFirstNode(Node head){
		Node fast =head, slow=head;
		while(fast!=null && fast.next!=null){
           slow = slow.next;
           fast = fast.next.next;
            System.out.println("fast data"+fast.data +"Slow data:"+slow.data);
           if(slow == fast)
           	  break;
		}
        if(fast==null || fast.next == null)
        	System.out.println("Given linked list doesnt have a cycle");
        else{
        	System.out.println("Cycle exists!");
            //find the first node in the cycle
            Node first = head;
            while(first!=fast){
            	first = first.next;
            	fast = fast.next;
            }
            System.out.println(first.data+"is the beinging Node of the cycle");
            //length
            int count = 0;
            fast = fast.next;
            while(fast!=first){
            	fast=fast.next;
            	count++;
            }
            System.out.println("length of the loop: "+count);

        }
	}

	public static void main(String[] args){
		Node head = new Node(0, null);
		Node curr = head;
		int count = 20;
		int first = 6;
		int c = 1;
		Node firstNode = null;
		for(int i=1;i<=count;i++){
           Node newNode = new Node(i,null);
           curr.next = newNode;
           curr= newNode;
           c++;
           if(c==first)
           	firstNode = newNode;
		}
        curr.next =firstNode;
        findCycleFirstNode(head);
	}
}