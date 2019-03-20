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
        if (l1 == null && l2 == null) return null;
        int sum = getNumber(l1) + getNumber(l2);
        String str = String.valueOf(sum);
        LinkedListNode head = null;
        LinkedListNode prev = head;
        for (char c : str.toCharArray()) {
            LinkedListNode digit = new LinkedListNode(c - '0');
            if (prev == null) {
                head = digit;
                prev = head;
            } else {
                prev.next = digit;
                prev = prev.next;
            }
        }
        return head;
    }

    private static int getNumber(LinkedListNode head) {
        LinkedListNode cur = head;
        int ret = 0;
        while (cur != null) {
            ret = ret * 10 + cur.val;
            cur = cur.next;
        }
        return ret;
    }
}
