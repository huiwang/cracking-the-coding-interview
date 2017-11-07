package com.truelaure.ctci.linkedlists;

import java.util.HashSet;
import java.util.Set;

/**
 * Remove Dups!
 * Write code to remove duplicates from an unsorted linked list.
 */
class _02_01_RemoveDups {

    LinkedListNode removeDups(LinkedListNode head) {
        return removeDupsWithRunner(head);
    }

    /**
     * Iterate on the list to find duplicate
     */
    private LinkedListNode removeDupsWithRunner(LinkedListNode head) {
        LinkedListNode current = head;
        while (current != null) {
            removeNodesHavingVal(current);
            current = current.next;
        }
        return head;
    }

    private void removeNodesHavingVal(LinkedListNode current) {
        LinkedListNode runner = current;
        while (runner.next != null) {
            if (runner.next.val == current.val) {
                runner.next = runner.next.next;
            } else {
                runner = runner.next;
            }
        }
    }

    private LinkedListNode removeDupsWithSet(LinkedListNode head) {
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
