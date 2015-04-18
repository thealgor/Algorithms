//Problem 17: reverse Linked list without using extra space.
public class ReverseLinkedList{
    private static class Node{
        int data;
        Node next;
        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    public static Node reverse(Node head){
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

    public  Node reverse1(Node head){
        if(head == null)
            return null;
        if(head.next == null) //most important thing here.
            return head;
        Node second = head.next;
        Node first = head;
        first.next = null;
        Node reverseList = reverse1(second);
        second.next = first;
        return reverseList; //just returning the same node again and again anda gain.
    }

}
