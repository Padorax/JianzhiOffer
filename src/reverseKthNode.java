public class reverseKthNode {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
//        ListNode slow = new ListNode(0);
//        slow.next = head;
        ListNode fast = head, slow = head;
        int i = 0;
        while (i < k) {
            //            List length is less than k
            if (fast == null) return null;
            fast = fast.next;
            i++;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        reverseKthNode s = new reverseKthNode();
        ListNode l = s.new ListNode(1);
        l.next = s.new ListNode(2);
        l.next.next = s.new ListNode(3);
        l.next.next.next = s.new ListNode(4);
        l.next.next.next.next = s.new ListNode(5);
        System.out.print(s.FindKthToTail(l,6).val);
    }
}
