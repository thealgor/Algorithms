public class AddNumbersLL{
	private static class Node{
		private int data;
		private Node next;
		public Node(int data, Node next){
			this.data = data;
			this.next=next;
		}
	}

	public static Node addListsInGivenOrder(Node l1, Node l2){
		Node dummy = new Node(-1,null);
		int num =0,carry = 0,sum=0;
		Node curr = dummy;
		while(l1!=null || l2!=null){
			sum = (l1!=null?l1.data:0) + (l2!=null?l2.data:0)+carry; //didnt use this logic. Code ended up becomging big.
			if(sum>9){
               num =sum%10;
               carry = 1 ;
			}
			else{
				 num = sum;
				 carry  = 0;
			}
			Node newNode = new Node(num,null);
            curr.next = newNode;
            curr = newNode;
            if(l1!=null)  //missed this section of code. Got a null pointer exception.
                l1=l1.next;
            if(l2!=null)
                l2=l2.next;


		}
        if(carry==1){
        	Node newNode = new Node(carry,null);
            curr.next = newNode;
        }
         
        return dummy.next;
  
	}

   //check for the static stuff
    public Node addNumbersRecursive(Node l1, Node l2, int carry){
    	if(l1==null&&l2==null &&carry==0)
    		return null;
    	
        Node result = new Node(carry,null);
    	int value = carry;
    	if(l1!=null)
    		value += l1.data;
    	if(l2!=null)
    		value += l2.data;
    	result.data = value%10;
    	if(l1!=null||l2!=null||value>=10){
    		Node more = addNumbersRecursive(l1.next!=null?l1.next:null,l2.next!=null?l2.next:null,value>=10?1:0);
    		result.next = more;
    	}
    	return result;
    }

	public static void main(String[] args){
		Node head1 = new Node(9, null);
		Node curr = head1;
		int count = 4;
		for(int i=1;i<=count;i++){
           Node newNode = new Node(9,null);
           curr.next = newNode;
           curr= newNode;
		}

		Node head2 = new Node(9,null);
        count = 3;
        curr = head2;
		for(int i=1;i<=count;i++){
           Node newNode = new Node(9,null);
           curr.next = newNode;
           curr= newNode;
		}
        Node result = addListsInGivenOrder(head1, head2);
        while(result!=null){
        	System.out.println(result.data);
            result = result.next;
        }

	}
	
}