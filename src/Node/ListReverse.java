package Node;



import java.util.Stack;

/**
 * Created by killer on 2017/7/3.
 */
public class ListReverse {
    public static void main (String arg[]){
        ListNode node1= new ListNode(1);
        ListNode node2= new ListNode(2);
        ListNode node3= new ListNode(3);
        node1.setNext(node2);
        node2.setNext(node3);
        ReverseList(node1);//非递归
        ReverseRecursive(node1);//递归
    }

    public static void ReverseList(ListNode node){
        Stack<ListNode> stack = new Stack<ListNode>();
        while (node!=null){
            stack.push(node);
            node = node.getNext();
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop().getData());
        }
    }
    public  static void ReverseRecursive(ListNode node){
        if (node !=null){
            if (node.getNext()!=null){
                ReverseRecursive(node.getNext());
            }
        }
        System.out.println(node.getData());
    }
}
