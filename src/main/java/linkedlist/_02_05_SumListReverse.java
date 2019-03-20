package linkedlist;

/**
 * Sum Lists: You have two numbers represented by a linked list,
 * where each node contains a single digit.
 * The digits are stored in reverse order, such that the 1 's digit is at the head of the list.
 * Write a function that adds the two numbers and returns the sum as a linked list.
 * <p>
 * EXAMPLE
 * Input:(7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295.
 * Output:2 -> 1 -> 9.That is,912.
 */
class _02_05_SumListReverse {
    LinkedListNode sum(LinkedListNode l1, LinkedListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        LinkedListNode head = new LinkedListNode(0);
        LinkedListNode pre = null;
        LinkedListNode tail = head;
        while (l1 != null || l2 != null) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            tail.val += sum % 10;
            tail.next = new LinkedListNode(sum / 10);
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            pre = tail;
            tail = tail.next;
        }
        if (tail.val == 0) {
            pre.next = null;
        }
        return head;
    }

}
