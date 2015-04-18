public class LoopFirstLengthCycle{
	private static class Node{
		int data;
		Node next;
		public Node(int data, Node next){
			this.data = data;
			this.next = next;
		}
	}
    /*

      INCOMPLETE:
      
       when one is moving two steps and the other is moving one step, is it gauranteed to meet?

       Every p steps slowrunner takes, fastrunner takes 2p steps. Say, slow runner enters loop after k steps, fastrunner
       would have take 2k steps by then. so, there is a difference of more k steps taken by fast runner. At each step
       from now, fast runner goes one step away from slow runner or comes one step closer to the slow runner. Fast runner
       catches up with slow runnerat a rate of 1 step per unit of time.

       How do you know it is the start node?

       Fastrunner is K steps into the loop already. Slowrunner is K(2K-K) steps behind the fastRunner. so, fastrunner is
       Loopsize -K steps behind the slow runner. K= mod(k,LOOP_SIZE)


       Say there are million nodes before the start of the loop. After the meeting point you start from the beginning of
       the list. and move million steps. if ptr is 2 nodes in a 5 node loop, it is similar to saying it moved 7 nodes,
       352 nodes etc.,

       They are going to meet at LOOP_SIZE - K steps. Already K steps in and going to move 1 step closer at a time. So,They
       will meet in loopsize-k steps. At this point they will be K steps before the head of the loop. the head of the linked list
       is also k or aK nodes from the start of the loop. Or

     */

	public static void findCycleFirstNode(Node head){
		Node fast =head, slow=head;
		while(fast!=null && fast.next!=null){  //missed this fast!=null and it failed
           slow = slow.next;
           fast = fast.next.next;
            System.out.println("fast data"+fast.data +"Slow data:"+slow.data);
           if(slow == fast)
           	  break;
		}
        if(fast==null || fast.next == null)
        	System.out.println("Given linked list doesnt have a cycle");
        else{
        	System.out.println("Cycle exists!");
            //find the first node in the cycle
            Node first = head;
            while(first!=fast){
            	first = first.next;
            	fast = fast.next;
            }
            System.out.println(first.data+"is the beinging Node of the cycle");
            //length
            int count = 0;
            fast = fast.next;
            while(fast!=first){
            	fast=fast.next;
            	count++;
            }
            System.out.println("length of the loop: "+count);

        }
	}

	public static void main(String[] args){
		Node head = new Node(0, null);
		Node curr = head;
		int count = 20;
		int first = 6;  //change the first to verify if it is null terminated.
		int c = 1;
		Node firstNode = null;
		for(int i=1;i<=count;i++){
           Node newNode = new Node(i,null);
           curr.next = newNode;
           curr= newNode;
           c++;
           if(c==first&&first!=-1)
           	firstNode = newNode;
		}
        curr.next =firstNode;
        findCycleFirstNode(head);
	}
}