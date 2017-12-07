package linkedlist;

/**
 * Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the
 * beginning of the loop.
 * <p>
 * DEFINITION
 * Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so as to make a loop in the linked list.
 * <p>
 * EXAMPLE
 * Input: A -> B -> C -> D -> E -> C[the same C as earlier]
 * Output: C
 */
class _02_08_LoopDetection {

    LinkedListNode detect(LinkedListNode head) {
        LinkedListNode runner = head;
        LinkedListNode walker = head;
        while (runner != null && runner.next != null) {
            runner = runner.next.next;
            walker = walker.next;
            if (runner == walker) break;
        }
        if (runner == null || runner.next == null) return null;

        walker = head;
        while (runner != walker) {
            runner = runner.next;
            walker = walker.next;
        }
        return runner;
    }
}
