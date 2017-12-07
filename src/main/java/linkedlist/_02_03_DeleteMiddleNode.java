package linkedlist;

/**
 * Implement an algorithm to delete a node in the
 * middle(i.e., any node but the first and last node, not necessarily the exact middle)
 * of a singly linked list, given only access to that node.
 */
class _02_03_DeleteMiddleNode {

    // time o(1)
    // space o(1)
    boolean deleteMiddleNode(LinkedListNode node) {
        if (node == null || node.next == null) return false;
        LinkedListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
        return true;
    }
}
