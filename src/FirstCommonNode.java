public class FirstCommonNode {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;

//        iterate over p1 and p2, get the difference of the length
        int len1 = 0, len2 = 0;
        ListNode p1 = pHead1, p2 = pHead2;
        while(p1 != null) {
            len1++;
            p1 = p1.next;
        }
        while(p2 != null) {
            len2++;
            p2 = p2.next;
        }
//        iterate again with advance step on longer list
//        let pHead1 points to longer list
        if (len1 < len2) {
            ListNode temp = pHead1; pHead1 = pHead2; pHead2 = temp;
            int l = len1; len1 = len2; len2 = l;
        }

//        for (int i = 0; i <= len1 - len2; i++) need to check if len1 == len2
        int i = 0;
        while (i++ < len1-len2) pHead1 = pHead1.next;

        while (pHead1 != null && pHead2 != null) {
            if (pHead1 == pHead2) return pHead1;
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }

        return null;
    }

    public static void main(String[] args) {
        FirstCommonNode s = new FirstCommonNode();
        ListNode l1 = s.new ListNode(1);
        ListNode l2 = s.new ListNode(2);
        ListNode r1 = s.new ListNode(1);
        ListNode r2 = s.new ListNode(3);
        ListNode l3 = s.new ListNode(4);
        l1.next = l2;
        l2.next = r1;
        r1.next = r2;
        l3.next = r1;
        ListNode res = s.FindFirstCommonNode(l1, l3);
        System.out.print(res.val);
    }
}
