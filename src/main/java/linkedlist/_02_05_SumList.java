package linkedlist;

/**
 * Sum Lists: You have two numbers represented by a linked list,
 * where each node contains a single digit.
 * The digits are stored in normal order, such that the 1 's digit is at the tail of the list.
 * Write a function that adds the two numbers and returns the sum as a linked list.
 * <p>
 * EXAMPLE
 * Input:(7-> 1 -> 6) + (5 -> 9 -> 2).That is, 716 + 592.
 * Output:1 -> 4 -> 0 -> 8.That is, 1408.
 */
class _02_05_SumList {

    LinkedListNode sum(LinkedListNode l1, LinkedListNode l2) {
        int length1 = len(l1);
        int length2 = len(l2);
        l1 = pad(l1, length2 - length1);
        l2 = pad(l2, length1 - length2);
        PartialSum partial = sumRec(l1, l2);
        if (partial.carry == 0) return partial.head;
        LinkedListNode head = new LinkedListNode(1);
        head.next = partial.head;
        return head;
    }

    private PartialSum sumRec(LinkedListNode l1, LinkedListNode l2) {
        if (l1 == null || l2 == null) {
            return new PartialSum();
        }
        PartialSum partial = sumRec(l1.next, l2.next);

        int sum = l1.val + l2.val + partial.carry;
        LinkedListNode n = new LinkedListNode(sum % 10);
        n.next = partial.head;
        partial.head = n;
        partial.carry = sum / 10;
        return partial;
    }

    private int len(LinkedListNode node) {
        int l = 0;
        while (node != null) {
            node = node.next;
            l++;
        }
        return l;
    }

    private LinkedListNode pad(LinkedListNode head, int padding) {
        for (int i = 0; i < padding; i++) {
            LinkedListNode n = new LinkedListNode(0);
            n.next = head;
            head = n;
        }
        return head;
    }

    static class PartialSum {
        LinkedListNode head;
        int carry;
    }


}
