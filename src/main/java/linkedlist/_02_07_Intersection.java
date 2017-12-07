package linkedlist;

/**
 * Intersection: Given two (singly) linked lists, determine if the two lists intersect.
 * Return the intersecting node. Note that the intersection is de ned based on reference, not value.
 * That is, if the kth node of the first linked list is the exact same node (by reference)
 * as the jth node of the second linked list, then they are intersecting.
 */
class _02_07_Intersection {

    boolean intersects(LinkedListNode l1, LinkedListNode l2) {
        if (l1 == null || l2 == null) return false;
        LinkedListNode r1 = l1;
        LinkedListNode r2 = l2;
        boolean switched1 = false;
        boolean switched2 = false;
        while (r1 != null || r2 != null) {
            if (r1 == r2) return true;
            if (r1 == null) {
                if (switched1) return false;
                r1 = l2;
                switched1 = true;
            } else {
                r1 = r1.next;
            }

            if (r2 == null) {
                if (switched2) return false;
                r2 = l1;
                switched2 = true;
            } else {
                r2 = r2.next;
            }
        }
        return false;
    }
}
