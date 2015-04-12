public class StackUsingLinkedList{

	private Node first=null;

	private class Node{
		private int data;
		private Node next;
	}

	public static void push(int data){
		Node oldNode=first;
		first = new Node();
		first.data=data;
		first.next=oldNode;
	}

	public boolean isEmpty(){
		return first==null;
	}

	public static int pop(){
		if(isEmpty())
			return throw new  UnsupoortedOperationException("stack is already empty!! you cannot pop");
		int item =first.item;
		first=first.next;
		return item;
	}
}

//few extra methods from Stanford

public class Iterate{
	public static void iterateList(Node first){
		while(first!=null){
			System.out.println(first.data);
			first=first.next;
		}
	}
}

//add 1,2,3,4,5,6

public static void buildList(){
	Node head = new Node();
	head.data=1;
	Node tail = null;
	tail = head;
	for(int i=2;i<5;i++){
		Node nextNode = new Node();
		nextNode.data=i;
		tail.next=nextNode;
		tail=tail.next;
	}
}

//dummy node

public static void buildListDummy(){
	Node dummy = new Node();
	Node tail = dummy;
    for(int i=1;i<n;i++){
    	Node nextNode = new Node(i);
    	tail.next=nextNode; 
    }
    return dummy.next;
}

//count number of times an int occurs in a list

public static int count(Node current, int data){
  int c=0;
  while(current!=null){
  	if(current.data==data)
  		c++;
  	current=current.next;
  }
  return c;
}



public static int getNth(Node current, int n){
	int count = 1;
	while(current!=null){
       if(count==n)
       	return current.data;
       current=current.next;
       count++;
	}
}


Problem 4:

public static void insertNth(Node list,int data, int n){
	int i=0;
	Node current = list;
	Node newNode = new Node(data);
    if(n==0)
    	newNode.next = list;


	while(current!=null){
       if(i==n-1){
       	Node temp = current.next;
       	current.next = newNode;
       	newNode.next = temp;
       	break;
       }
       current=current.next;
       i++;

	}
	if(i!=n-1)
		throw new IllegalArgumentExpcetion("send n value within the  size of the linked list"+)
}


Problem: 6

public static void sortedInsert(Node head, Node newNode){
	int i=0;
	boolean inserted = false;
	if(head == null){
		head=newNode;
		inserted=true;
	}
	if(newNode.data<head.data)
		newNode.next = head;
	Node prev = head;
	Node curr = head.next;
	
	while(curr!=null){
        if(curr.data>newNode.data){
        	prev.next=newNode;
        	newNode.next=curr;
        	inserted=true;
        }
        prev=curr;
        curr=curr.next;
	}
    if(!inserted){
      prev.next=newNode;
    }
}

//better solution


public static void sortedInsert(Node head, Node newNode){
	//first case - insert element at the beginning of the linked list
	if(head==null||head.data>newNode.data)
		newNode.next=head;

	//others - search if next node has data larger than the given node?
	Node curr = head;
	while(curr.next!=null&&curr.next.data<newNode.data)
       curr =curr.next;
    
    newNode.next=curr.next;
    curr.next=newNode;

}


//easy solution - dummy node

public static Node sortedInsert(Node head, Node newNode){
	Node dummy = new Node(Integer.MIN_VALUE);
	dummy.next = head;
	Node curr = dummy.next;
	while(curr.next!=null&&curr.next.data<=newNode.data){
		curr= curr.next;
	}
	newNode.next=curr.next;
	curr.next=newNode;
}


//problem 7: iterate and insert all the ndoes using sortedInsert

public static void insertSort(Node head){
	Node result = null;
	Node curr = head;
	while(curr!=null){
		Node next = curr.next; //tricky
		sortedInsert(result, curr);
		curr = next;
	}
}


//problem 8: two lists, append list b to a and set b to null

public static void append(Node a, Node b){
	if(a==null){
		a=b;
	}
	else{
		Node curr = head;
		while(curr.next!=null)
			curr = curr.next;
		curr.next =b;
	}
	b=null;
}



//problem 9: FrontBackSplit {2,3,5,7,11} o/p: {2,3,5} {7,11}

//b and c are output
public static void frontBackSplit(Node a, Node b, Node c){
    if(a==null)
    	return IllegalArgumentExpcetion("List is empty, you cannot split");
    Node slow = a;
    Node fast = a; //this doesnt work
    while(fast.next!=null){
    	fast = fast.next.next;
    	slow = slow.next;
    }
    Node c = slow.next;
    Node b = a;
    slow.next=null;
 }


tests:
1) null
2) 1 2  - fails
Node fast = a.next;
3) 1 2 3 - works
4) 1 2 3 4 5 - works


//problem 10: remove duplicates

public static Node removeDuplicates(Node head){
	if(head.next==null || head==null)
		return head;
	Node curr = head.next;
	Node prev = curr;
	while(curr!=null){
       if(curr.data==prev.data){
       	  prev.next = curr.next;
       	  curr = curr.next;
       	  continue;
       	}
       	else{
       		prev = curr;
       		curr = curr.next;
       	}
	}
	return head;
}

Tests:
1) null || 1
2) 1 1  - works
3) 1 2 2 2 3 - works
4) 1 1 1 - works

//problem 11: Move Node. Remove first node of the second list and push it to the first list
//ex: {1,2,3} {1,2,3} => {1,1,2,3},{2,3}

//could use src, dest as variable names
public static void moveNode(Node a, Node b){
	if(b==null)
		return;  //do nothing
    Node firstNode = b;
    b= firstNode.next;
    firstNode.next=a;
    a=FirstNode;
    
}


//Problem 12: Alternating Split
//{a,b,a,b,a}-> {a,a,a} and {b,b}

public static void alternatingSplit(Node head){
	Node a, b;
	Node head = current;
	boolean odd = false;
    while(current!=null){
    	if(!odd){
           if(a==null)
           	 a=current;
           	else
           		a.next=current;
           	current=current.next;
           	odd=true;
    	}
    	else{
    		if(b==null)
    			b=current;
    		else
    			b.next=current;
    		current=current.next;
            odd = false;
    	}
    }
}

//dummy node implementation would be simpler

public static void alternatingSplit(Node head){
	Node aDummy= new Node();
	Node bDummy = new Node();
	Node current = head;
	Node aTail = aDummy;
	Node bTail = bDummy;
	while(current!=null){
        aTail.next =current;
        aTail=aTail.next;
        current=current.next;
        if(current!=null){
        	bTail.next = current;
            bTail = bTail.next;
            current=current.next;
        }
	}
	Node a = aDummy.next;
	Node b = bDummy.next;
}

//problem 13: ShuffleMerge  -- alternatively

public static Node shuffleMerge(Node a, Node b){
	Node dummy = new Node();
	Node result = dummy;
	while(a!=null && b!=null){
       result.next = a;
       a=a.next;
       result = result.next;
       result.next = b;
       b=b.next;
       result = result.next;
	}
	if(a==null)
		result.next = b;
	else if(b==null)
		result.next = a;
	return dummy.next;
}

//Test: {1,2,3}{4,5}


//Problem 14: sortedMerge

public static Node sortedMerge(Node a, Node b){
	Node dummy = new Node();
	Node tail = dummy;
	while(a!=null&&b!=null){
		if(a.data<=b.data){  //equal to imp here
          tail.next = a;
          a=a.next;
          tail=tail.next;
		}
		else{
			tail.next=b;
			b=b.next;
			tail=tail.next;
		}
	}
	if(a==null)
		 tail.next=b;
	else if(b==null)
		tail.next=a;
	return dummy.next;
}



//using recursion

public static Node sortedMerge(Node a, Node b){
	Node result = null;
	if(a==null)
		return b;
	else if(b==null)
		return a;
	if(a.data<=b.data){
		result = a;
		result.next=sortedMerge(a.next,b);
	}
	else{
		result = b;
		result.next=sortedMerge(a,b.next);
	}
	return result;
}


//problem 15: mergeSort


public static void sort(Node head, int count){
    Node current = head;
    //code to split Front Back Split.
    
    if(head==null)
    	return IllegalArgumentExpcetion("List is empty, cannot sort");
    Node a=head;
    Node slow = a;
    Node fast = a; //this doesnt work
    while(fast.next!=null){
    	fast = fast.next.next;
    	slow = slow.next;
    }
    Node c = slow.next;
    Node b = a;
    slow.next=null;

    mergeSort(b);
    mergeSort(c);
    sortedMerge(a,b);

}


//Problem: 16 SortedIntersect. common nodes in two lists, should traverse only once.

public static Node sorteIntersect(Node a, Node b){
	Node dummy = new Node();
	Node result = dummy;
	while(a!=null && b!=null){
		if(a.data==b.data){
			result.next = new Node(a.data);
			a=a.next;
			b=b.next
		}
		else if(a.data<b.data){
			a=a.next;
		}
		else{
			b=b.next;
		}
	}
	return result;
}

//Problem 17: reverse Linked list without using extra space.

public static void reverse(Node head){
   Node result = null;
   Node current = head;
   while(current!=null){
   	 Node next = current.next;
   	 current.next = result;
   	 result = current;
   	 current = next;
   }
   return result;
}

//problem 18: Reverse Linked List recursively
// 1->2->3->null
//reverse of null 
//reverse of 1 element
//reverse of n elements.

public Node reverse(Node head){
	if(head == null)
		return null;
	if(head.next == null)
		return head;
	Node second = head.next;
	Node first = head;
	first.next = null;
	Node reverseList = reverse(second);
	second.next = first;
    return reverseList; //just returning the same node again and again anda gain.
}

