import java.util.*;
public class LinkedListNextRandomClone {
	private class Node{
		private Node next;
		private int data;
		private Node random;
		public Node(int data, Node next, Node random){
			this.data = data;
			this.next = next;
			this.random = random;
		}
	}

	//method1: hashmap
    public Node clone(Node head){
		HashMap<Node,Node> hmap = new HashMap<Node, Node>();
		HashMap<Node,Node> hmap1 = new HashMap<Node, Node>();
		Node curr = head;
		Node result = null;
		Node hr = result;
		Node resultHead = null;
		while(curr!=null){
            hmap.put(curr,curr.random);
            Node temp = new Node(curr.data, null, null);
            hmap1.put(curr, temp);
            if(result==null){
            	resultHead = temp;
            	result = temp;
            }
            else{
            	result.next = temp;
            	result = temp;
            }
            curr = curr.next;
		}
        curr=head;
        while(curr!=null){
          Node newTemp = hmap1.get(curr);
          Node actualRandom = hmap.get(curr);
          Node tempRandom = hmap1.get(actualRandom);
          newTemp.random=tempRandom;
          curr = curr.next;
		}  
      return resultHead;

	}

    //method 2: without extra space
    //Algorithm: 1) create copy nodes in between the original nodes
    //           2) curr.next.random = curr.random.next;..assign random pointers
    //           3) Break the list into two parts

    public Node clone2(Node head){
        Node original = head;
        Node curr = original;
        Node copy = new Node(-1,null,null);
        while(curr!=null){
            //insert in between nodes
            Node newNode = new Node(curr.data,null,null);
            Node temp = curr.next;
            curr.next = newNode;
            newNode.next = temp;
            curr = temp;
        }

        curr = original;
        while(curr!=null){
            curr.next.random = curr.random.next;
            curr = curr.next.next;
        }

        Node curr1 = original;
        copy = original.next;
        Node curr2 = copy;

        while(curr1.next!=null){
            curr1.next = curr1.next.next;
            curr1 = curr1.next.next;
            if(curr2.next!=null){
                curr2.next = curr2.next.next;
                curr2=curr2.next.next;
            }
        }

        return copy;
    }


	public void test(){
		Node one = new Node(1,null,null);
		Node two = new Node(2,one,null);
		Node thr = new Node(3,two,null);
		Node fou = new Node(4,thr,null);
		Node fiv = new Node(5,fou,null);
		one.random = fiv;
		fiv.random = two;
		two.random= fou;
		fou.random = thr;
		thr.random = one;

		Node result = clone(fiv);
		while(result!=null){
			if(result.next!=null) 
				System.out.println(result.data+"next "+result.next.data+"random "+result.random.data);
			else
				System.out.println(result.data+"next null"+"random "+result.random.data);
            result = result.next; //made the same mistake twice. while testing keep this in mind
		}

        System.out.println("-------");

        result = clone2(fiv);
        while(result!=null){
            if(result.next!=null)
                System.out.println(result.data+"next "+result.next.data+"random "+result.random.data);
            else
                System.out.println(result.data+"next null"+"random "+result.random.data);
            result = result.next; //made the same mistake twice. while testing keep this in mind
        }

	}

    public static void main(String[] args){
    	LinkedListNextRandomClone l = new LinkedListNextRandomClone();
    	l.test();
    }


}