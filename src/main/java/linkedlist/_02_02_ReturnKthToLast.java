package linkedlist;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement an algorithm to find the kth to last element of a singly linked list
 */
class _02_02_ReturnKthToLast {

    LinkedListNode kthToLast(LinkedListNode head, int k) {
        Queue<LinkedListNode> deque = new LinkedList<>();
        LinkedListNode curr = head;
        while (curr != null) {
            if (deque.size() >= (k + 1)) {
                deque.remove();
            }
            deque.add(curr);
            curr = curr.next;
        }
        return deque.size() > k ? deque.remove() : null;
    }
}
