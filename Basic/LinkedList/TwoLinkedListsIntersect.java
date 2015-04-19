public class TwoLinkedListsIntersect{
	private class Node{
		private int data;
		private Node next = null;
        public Node(int data, Node next){
        	this.data = data;
        	this.next = next;
        }
	}

	public Node findTwoLinkedListIntersect(Node l1, Node l2){
		int m = length(l1);
		int n = length(l2);
		Node curr1 = l1;
		Node curr2 = l2;
		if(m==0||n==0)
			throw new IllegalArgumentException("Dont send empty linked lists");
		int diff = Math.abs(m-n);
		if(m>n){
          for(int i=0;i<diff;i++){
          	curr1 = curr1.next;
          }
		}
		else if(m<n){
			for(int i=0;i<diff;i++)
				curr2 = curr2.next;
		}
        while(curr1!=null&&curr2!=null){
        	if(curr1==curr2)
        		return curr1;
        	else{
        		curr1= curr1.next;
        		curr2 = curr2.next;
        	}
        }
        return null; //if no intersection point exists

	}

	public int length(Node l){
		int count = 0;
		while(l!=null){
			count++;
			l=l.next;
		}
       return count;
	}

	public void test(){
		Node head1 = new Node(-1, null);
        Node l1 = head1;
		int n1=10;
		int intersection = 6;
		Node interNode = null;
		for(int i=0;i<n1;i++){
			l1.next = new Node(i, null);
			if(i==intersection)
				interNode = l1.next;
			l1 = l1.next;
		}
        Node head2 = new Node(-1, null);
        Node l2 = head2;
        int n2 = 15;
        for(int i=10;i<n2;i++){
        	l2.next = new Node(i, null);
        	l2 = l2.next;
        }
        l2.next = interNode;
       Node result = findTwoLinkedListIntersect(head1, head2);
       System.out.println(result.data);

	}

	public static void main(String[] args){
		TwoLinkedListsIntersect t = new TwoLinkedListsIntersect();
		t.test();
	}
}
