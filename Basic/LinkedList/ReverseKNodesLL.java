public class ReverseKNodesLL{
	private class Node{
		private int data;
		private Node next;
		public Node(int data ,Node next){
			this.data = data;
			this.next = next;
		}
	}
    /*
      when k=2, we can easily swap the data of two nodes

     */

    public Node reverseKnodes(Node l, int k){
    	Node curr = l;
        Node head = l;
        int c =0;
        while(curr!=null&&c<k-1){
            curr = curr.next;
            c++;
        }
        Node nextNode = null; 
        if(c==k-1&&curr!=null){
            nextNode=curr.next;
            curr.next = null;
        }
        else{
            return head;
        }
        Node result = reverse(head);

        head.next = reverseKnodes(nextNode,k);

        return result;
        
    }

    public Node reverse(Node h){
        Node tail = null;
        while(h!=null){
            Node temp = h.next;
            h.next = tail;
            tail = h;
            h = temp;
        }
        return tail;

    }

    public void test(){
    	Node res = new Node(0, null);
    	Node curr = res;
    	int c = 10;
    	for(int i=1;i<10;i++){
    		Node newNode = new Node(i,null);
    		curr.next = newNode;
    		curr = newNode;
    	}
       Node f = reverseKnodes(res,2);
       while(f!=null){
       	System.out.println(f.data);
       	f=f.next;
       }
    }

    public static void main(String[] args){
    	ReverseKNodesLL r = new ReverseKNodesLL();
    	r.test();
    }

}