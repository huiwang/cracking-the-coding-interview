package linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * Remove Dups!
 * Write code to remove duplicates from an unsorted linked list.
 */
class _02_01_RemoveDups {

    // time o(n)
    // space o(n)
    LinkedListNode removeDups(LinkedListNode head) {
        Set<Integer> set = new HashSet<>();
        LinkedListNode pre = null;
        LinkedListNode next = head;
        while (next != null) {
            if (set.contains(next.val)) {
                pre.next = next.next;
            } else {
                set.add(next.val);
                pre = next;
            }
            next = next.next;
        }
        return head;
    }
}
