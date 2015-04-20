public class DoubleLL{
	private class Node{
		int data;
		Node prev;
		Node next;
		public Node(int data, Node prev, Node next){
			this.data=data;
			this.prev = prev;
			this.next=next;
		}
	}


	public Node insertNode(Node h, int data, int pos){
       //if list is empty
       if(h==null)
         return new Node(data, null, null); 
       //if need to insert at the begining
       if(pos==0){
       	  	Node newNode = new Node(data, null, h);
            h=newNode;
            return h;
       	 }
		Node curr = h;
		Node prev=curr;
		for(int i=0;i<pos;i++){
       	  //if(curr==null)
       	  	//throw new Exception("Cannot insert at this position");
          prev=curr;
          curr = curr.next;
        }
        //if node is the last node
        if(curr==null){
          prev.next = new Node(data, prev, null);
          return h;
        }
       
       //if node is a middle node
        Node newNode = new Node(data, prev, curr);
        prev.next = newNode;
        curr.prev = newNode;
        return h;
	}

    public Node deleteNode(Node h, int pos){

         if(h==null)
         	throw new IllegalArgumentException("h cannot be null");

    	int size = 10;//just a place holder need length method
    	//discard if position is greater than linked list size
    	if(pos<0||pos>size){
    		System .out.println("invalid operation");
            return h;
    	}

        if(pos==0){
        	 h = h.next;
        	h.prev = null;
        	return h;
        }
        //if it is  a middle node
        Node prev = h;
        Node curr = h;
        int c = 0;
        while(curr!=null&& c<pos){
        	prev = curr;
        	curr = curr.next;
        	c++;
        }
            
        	prev.next = curr.next;
        	//need to verify for the last node as well
            if(curr.next!=null)
        		curr.next.prev = prev;
        	Node dNode = curr;
        	curr = dNode.next;
        	dNode.next = null;
        	dNode.prev = null;
        
     return h;

    }

}