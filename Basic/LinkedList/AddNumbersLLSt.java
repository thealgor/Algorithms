public class AddNumbersLLSt{
	private class Node{
		Node next=null;
		int data;
		public Node(int data, Node next){
			this.data = data;
			this.next = next;
		}
	}

    //straight approach: 1) pad lists with zeroes 2) add  and 3) insert before
    
   //You need this because at every recursion step, you need to send two properties: 1) Node with partial result 2) carry value
   public class PartialSum{
   	public Node sum = null;
   	public int carry = 0;
   }



    public Node addListsInStraightOrder(Node l1, Node l2){
    	int m = length(l1);
    	int n = length(l2);
    	if(m>n){
    		l2=padList(l2, m-n);
    	}
    	else if(m<n){
    		l1 = padList(l1,n-m);
    	}
      PartialSum sum = addListHelper(l1,l2);
      if(sum.carry==0)
      	return sum.sum;
      else{
      	Node newNode = new Node(sum.carry, null);
      	return insertBefore(sum.sum, newNode);
      }
      

    }


    public PartialSum addListHelper(Node l1, Node l2){
    	if(l1==null&&l2==null){
    		PartialSum sum = new PartialSum();
    		return sum;
    	}

    	PartialSum sum = addListHelper(l1.next,l2.next);


    	int value = sum.carry+l1.data+l2.data;
    	Node newNode = new Node(value%10,null);
        sum.sum = insertBefore(sum.sum, newNode);
    	sum.carry = value>=10? 1: 0;
    	return sum;

    }

    public Node padList(Node l, int padLen){
      for(int i=0;i<padLen;i++){
      	Node zeroNode = new Node(0,null);
      	l= insertBefore(l, zeroNode);
      }
      return l;
    }

    public Node insertBefore(Node l, Node tempNode){
       tempNode.next = l;
       l= tempNode;
       return l;
    }

    public int length(Node l1){
       int count = 0;
       while(l1!=null){
       	l1 = l1.next;
       	count++;
       }
       return count;
    }


    public void test(){

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
        Node result = addListsInStraightOrder(head1, head2);
        while(result!=null){
        	System.out.println(result.data);
            result = result.next;
        }

    }

    public static void main(String[] args){
    	AddNumbersLLSt a = new AddNumbersLLSt();
    	a.test();
    }
}