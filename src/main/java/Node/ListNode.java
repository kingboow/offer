package Node;

/**
 * Created by killer on 2017/7/3.
 */
public class ListNode {
    private int Data;
    private ListNode next;

    public ListNode(int data){
        this.Data=data;
    }

    public int getData() {
        return Data;
    }

    public void setData(int data) {
        Data = data;
    }

    public Node.ListNode getNext() {
        return next;
    }

    public void setNext(Node.ListNode next) {
        this.next = next;
    }
}
