public class RandomList {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
        CloneNodes(pHead);
        ConnectRandomNodes(pHead);
        return ReconnectNodes(pHead);
    }

//    create N' for any node N in list and let N.next => N'
    void CloneNodes(RandomListNode p) {
        while (p != null) {
            RandomListNode pCloned = new RandomListNode(p.label);
            pCloned.next = p.next;
            p.next = pCloned;
            p = pCloned.next;
        }
    }

    void ConnectRandomNodes(RandomListNode p) {
        while(p != null) {
            RandomListNode pCloned = p.next;
            if (p.random != null) {
                pCloned.random = p.random.next;
            }
            p = pCloned.next;
        }
    }

    RandomListNode ReconnectNodes(RandomListNode p) {
        RandomListNode pcHead;
        RandomListNode pcNode;
        if (p == null) return null;
        pcHead = pcNode = p.next;
        p.next = pcNode.next;
        p = p.next;

        while(p != null) {
            pcNode.next = p.next;
            pcNode = pcNode.next;
            p.next = pcNode.next;
            p = p.next;

        }
        return pcHead;

    }
    public static void main(String[] args) {
        RandomList s = new RandomList();
        RandomListNode l1 = s.new RandomListNode(1);
        RandomListNode l2 = s.new RandomListNode(2);
        RandomListNode l3 = s.new RandomListNode(3);
//        RandomListNode l4 = s.new RandomListNode(4);
//        RandomListNode l5 = s.new RandomListNode(5);
        l1.next = l2;
        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
        l1.random = l3;
//        l2.random = l5;
//        l4.random = l2;
//        s.CloneNodes(l1);
//        s.ConnectRandomNodes(l1);
//        RandomListNode s2 = s.Clone(l1);
        s.Clone(l1);
    }
}
