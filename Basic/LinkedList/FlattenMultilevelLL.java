public class FlattenMultilevelLL{
	private class Node{
		private int data;
		private Node next;
		private Node child;
		public Node(int data, Node next, Node child){
			this.data = data;
			this.next = next;
			this.child = child;
		}
	}

	//algorithm:
    //         1) Go to end of the first level, and if your current node has a child add that to the end and then update
    // the tail. and go so on..

    public Node flatten(Node head){

		Node curr = head;
        if(curr == null)
        	throw new IllegalArgumentException("cannot be null");

		Node tail = updateTail(curr);
        while(curr!=null){
        	if(curr.child!=null){
        		tail.next = curr.child;
        		tail = updateTail(tail);
        	}
        	curr = curr.next;
        }
        return head;
    }
	public Node updateTail(Node head){
		Node curr = head;
		while(curr.next!=null){
            curr = curr.next;
		}
		return curr;
	}

	public void test(){
		Node one = new Node(1,null,null);
		Node two = new Node(2,null,null);
		Node thr = new Node(3,null,null);
		Node fou = new Node(4,null,null);
		Node fiv = new Node(5,null,null);
		Node six = new Node(6,null,null);
		Node dummy = new Node(-1, null, null);
		Node curr = dummy;
		for(int i = 0;i<10;i++){
			Node newNode = new Node(i+10, null, null);
			curr.next = newNode;
			if(i==0){
				newNode.child = one;
				one.next = two;
				one.child = thr;
			}

			if(i==5){
				newNode.child = fiv;
				newNode.next = fou;
				fiv.child = six;
			}
			curr = newNode;
		}
       Node result = flatten(dummy.next);
       while(result!=null){
       	System.out.println(result.data);
       	result = result.next;
       }

	}

	public static void main(String[] args){
		FlattenMultilevelLL f = new FlattenMultilevelLL();
		f.test();
	}
}