public class mergeSortedList {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list2 == null) return list1;
        if (list1 == null) return list2;
        ListNode merged = new ListNode(0);
        ListNode cur = merged;
        while (list1 != null && list2 !=null) {
            if (list1.val <= list2.val) {
                cur.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                cur.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 == null) {
            while (list2 != null) {
                cur.next = new ListNode(list2.val);
                list2 = list2.next;
                cur = cur.next;
            }
        } else {
            while (list1 != null) {
                cur.next = new ListNode(list1.val);
                list1 = list1.next;
                cur = cur.next;
            }
        }
        return merged.next;
    }

    public static void main(String[] args) {
       mergeSortedList m = new mergeSortedList();
       ListNode n1 = m.new ListNode(2);
       n1.next = m.new ListNode(3);
       n1.next.next = m.new ListNode(5);
       ListNode n2 = m.new ListNode(1);
       n2.next = m.new ListNode(4);
       n2.next.next = m.new ListNode(7);
       n2.next.next.next = m.new ListNode(9);
       ListNode res = m.Merge(n1, n2);
       assert(res.val == 1);
    }

}

