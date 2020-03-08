package offerbook;

public class Node {
    /**
     * 判断链表是否有环
     * 1.hash表：节点放入哈希表，当哈西表包含节点时 说明有环
     * 2.双指针：快、慢指针，快指针在前，每次前进2步，如果快慢没相遇 则无环
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head.getNext() == null || head.getNext().getNext() == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

    private class ListNode {
        private ListNode next;
        private String value;

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
