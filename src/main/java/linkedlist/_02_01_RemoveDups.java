package linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * Remove Dups!
 * Write code to remove duplicates from an unsorted linked list.
 */
class _02_01_RemoveDups {

    LinkedListNode removeDups(LinkedListNode head) {
        Set<Integer> set = new HashSet<>();
        LinkedListNode prev = null;
        LinkedListNode curr = head;
        while (curr != null) {
            if (set.contains(curr.val)) {
                prev.next = curr.next;
            } else {
                set.add(curr.val);
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
}
