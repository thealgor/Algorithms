public class PalindromeLL{
	private class Node{
		private int data;
		private Node next;
		public Node(int data, Node next){
			this.data = data;
			this.next = next;
		}
	}

	public boolean isPalindrome(Node head){
		Node curr = head;
        
        //only one element or no elements return true
        if(head==null|| head.next ==null)
        	return true;

		Node fast = head.next;
		Node slow = head;
		int c = 1;
		while(fast!=null&&fast.next!=null){ //missed fast!=null --> null pointer exception always while fast and slow use standard procedure
			fast = fast.next.next;
			slow = slow.next;
			c++;			
		}
		Node list2 = slow.next;
	    Node list1 = head;
	    slow.next = null;
        list2 = reverse(list2);
	    while(list2!=null){
	    	if(list2.data == list1.data){
	    		list2 = list2.next;
	    		list1 = list1.next;
	    	}
	    	else{
	    		return false;
	    	}

	    }
      return true;
	}

	public Node reverse(Node head){
		Node tail = null;
		while(head!=null){
			Node temp = head.next;
            head.next = tail;
            tail = head;
            head = temp;
		}
		return tail;

	}

    public void test(){
    	Node one = new Node(5,null);
		Node two = new Node(4,one);
		Node thr = new Node(3,two);
		Node fou = new Node(4,thr);
		Node fiv = new Node(5,fou);

		boolean result = isPalindrome(fiv);
		System.out.println(result);
    }

    public static void main(String[] args){
    	PalindromeLL p = new PalindromeLL();
    	p.test();
    }


}