package linkedlist;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _02_07_IntersectionTest {

    private _02_07_Intersection s = new _02_07_Intersection();

    @Test
    public void withTwoEmptyLists() {
        assertFalse(s.intersects(LinkedListNode.empty(), LinkedListNode.empty()));
    }

    @Test
    public void withOneEmptyList() {
        assertFalse(s.intersects(LinkedListNode.empty(), LinkedListNode.of(1, 2, 3)));
        assertFalse(s.intersects(LinkedListNode.of(1, 2, 3), LinkedListNode.empty()));
    }

    @Test
    public void withTwoSeparatedLists() {
        assertFalse(s.intersects(LinkedListNode.of(1, 2, 3), LinkedListNode.of(4, 5, 6)));
    }

    @Test
    public void withTwoSeparatedLists_HavingSameValue() {
        assertFalse(s.intersects(LinkedListNode.of(1, 2, 3), LinkedListNode.of(4, 2, 3)));
    }

    @Test
    public void withIntersectedLists() {
        LinkedListNode l1 = LinkedListNode.of(1, 2, 3, 4, 5);
        LinkedListNode l2 = LinkedListNode.of(6, 7, 8);
        l2.next.next.next = l1.next;
        assertTrue(s.intersects(l1, l2));
    }
}