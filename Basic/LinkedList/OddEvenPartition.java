public class OddEvenPartition{
	private class Node{
		private int data;
		private Node next;
		public Node(int data, Node next){
			this.data = data;
			this.next = next;
		}
	}
    // we can solve another problem similar to this if given a partiton value, smaller numbers should come before etc.,
	public Node oddEvenBeginning(Node head){
       Node l1 = null;
       Node l2 = null;
       Node curr = head;
       while(curr!=null){
       	if(curr.data%2==0){
       		Node temp = curr.next;
            curr.next = l1;
            l1 = curr;
            curr = temp;
       	}
       	else{
       		Node temp  = curr.next;
       		curr.next = l2;
       		l2 = curr;
       		curr = temp;
       	}
       }
       if(l1!=null){
          curr = l1;
          while(curr.next!=null)
          	curr = curr.next;
          curr.next = l2;
          return l1;
       }
       else
       	 return l2;
	}

	public void test(){
		Node dummy = new Node(-1, null);
		Node curr = dummy;
		for(int i=0;i<6;i++){
			Node newNode = new Node(i, null);
			curr.next = newNode;
			curr = newNode;
		}
		Node result = oddEvenBeginning(dummy.next);
		while(result!=null){
			System.out.println(result.data);
			result = result.next;
		}
	}

	public static void main(String[] args){
		OddEvenPartition o = new OddEvenPartition();
		o.test();
	}

}