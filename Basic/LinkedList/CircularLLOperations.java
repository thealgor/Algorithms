public class CircularLLOperations{
	private class Node{
		private int data;
		private Node next;
		public Node(int data, Node next){
			this.data = data;
			this.next = next;
		}
	}

	public Node insert(Node head,int data, int pos){
		
        if(head ==null)
        	return new Node(data,null);
		Node tail = head.next;
		
		while(tail.next!=head){
				tail = tail.next;
		}

		if(pos==1){
		   Node newNode = new Node(data, head);
           head = newNode;
           tail.next = head;
           return head;
		}

		// condition based on length, if given position is greater than length then we will place the node at pos%len;
        int c = 1;
        Node curr = head;
        Node prev = curr;
        while(pos<c){
        	curr = curr.next;
        }
        //insert at the end
        if(c!=1 && curr==head){
          Node newNode = new Node(data,head);
          prev.next = newNode;
          newNode.next = head;
        }
        
        //insert in middle
        Node newNode = new Node(data, curr);
        prev.next = newNode;
     return head;
	}

//remove is also the same thing

//split circular linked list into two equal parts

	public void split(Node head){
		Node fast = head.next;
		Node slow = head;

		while(fast.next!=head&&fast.next.next!=head){
			fast = fast.next.next;
			slow = slow.next;
		}
        
        Node head2 = slow.next;
        Node tail2 = null;
        if(fast.next == head)
            tail2 = fast;
        else if(fast.next.next == head)
        	tail2=fast.next;
		tail2.next = head2;
		slow.next = head;

	}

}
