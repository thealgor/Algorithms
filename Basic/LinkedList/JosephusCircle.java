//N nodes(memebers), delete every Mth and find the last remaining

public class JosephusCircle{
	private class Node{
		private int data;
		private Node next;
		public Node(int data, Node next){
			this.data = data;
			this.next=next;
		}
	}

	public void josephusCirc(int N, int M){
		Node dummy = new Node(-1,null);
		Node curr = dummy;
		for(int i=0;i<N;i++){
          Node newNode = new Node(i, null);
          curr.next =newNode;
          curr = newNode;
		}
		Node head = dummy.next;
		curr.next = head; //create a loop
        curr = head;
        Node prev;
		for(int i =0;i<N;i++){
			for(int j=0;j<M;j++){
				prev = curr;
				curr = curr.next;
			}
            //delete the node
            prev = curr.next;
            curr = curr.next;
		}
	  System.out.println(curr.data);  
   
	}


}