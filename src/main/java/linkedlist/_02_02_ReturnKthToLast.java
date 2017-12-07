package linkedlist;

/**
 * Implement an algorithm to find the kth to last element of a singly linked list
 */
class _02_02_ReturnKthToLast {

    // time o(n)
    // space o(1)
    LinkedListNode kthToLast(LinkedListNode head, int k) {
        LinkedListNode kth = head;
        LinkedListNode runner = head;
        int dist = 0;
        while (runner.next != null) {
            if (dist == k) {
                runner = runner.next;
                kth = kth.next;
            } else {
                runner = runner.next;
                dist++;
            }
        }
        return dist == k ? kth : null;
    }
}
