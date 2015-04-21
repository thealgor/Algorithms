
import javax.naming.OperationNotSupportedException;
import java.util.*;
public class FlattenMultiLevelLLIterator{
    public void iterate(Node head){
      List1 l = new List1(head);
      MyIterator it = l.iterator();
      while(it.hasNext()){
          System.out.println(it.next().data);
      }
    }

    public void test(){
        Node one = new Node(1,null,null);
        Node two = new Node(2,null,null);
        Node thr = new Node(3,null,null);
        Node fou = new Node(4,null,null);
        Node fiv = new Node(5,null,null);
        Node six = new Node(6,null,null);
        Node seven = new Node(7, null, null);
        Node eight = new Node(8, null, null);
        Node nine = new Node(9, null, null);
        Node dummy = new Node(-1, null, null);
        Node curr = dummy;
        for(int i = 0;i<10;i++){
            Node newNode = new Node(i+10, null, null);
            curr.next = newNode;
            if(i==0){
                newNode.child = one;
                one.next = two;
                one.child = thr;
                thr.child = nine;
            }

            if(i==5){
                newNode.child = fiv;
                fiv.next = fou;
                fiv.child = six;
                fou.next = seven;
                fou.child = eight;
            }
            curr = newNode;
        }
       iterate(dummy.next);
    }

    public static void main(String[] args){
        FlattenMultiLevelLLIterator f = new FlattenMultiLevelLLIterator();
        f.test();
    }


}

 class MyIterator implements Iterator{
    Stack st = new Stack();
    public MyIterator(Node head){
        if(head == null)
            throw new IllegalArgumentException("Cannot iterate over a null pointer");
        st.push(head);
    }

    @Override
    public boolean hasNext(){
        return st.size()>0;
    }
    @Override
    public Node next(){
        if(st.empty())
            throw new IllegalArgumentException("Cannot do next on empty list");
        Node curr = (Node)st.pop();
        if(curr!=null){
            if(curr.next!=null){
               st.push(curr.next);
            if(curr.child!=null)
                st.push(curr.child);

            }
        }

     return curr;
    }

     @Override
    public void remove(){

    }
}

 class Node{
    public int data;
    public Node next;
    public Node child;
    public Node(int data, Node next, Node child){
        this.data = data;
        this.next = next;
        this.child = child;
    }
}

class List1 implements Iterable{
    Node start;
    public List1(Node start){
        this.start = start;
    }
    public MyIterator iterator(){
      return new MyIterator(start);
    }

}
