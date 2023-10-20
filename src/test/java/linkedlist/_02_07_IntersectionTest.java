package linkedlist;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class _02_07_IntersectionTest {

  private _02_07_Intersection s = new _02_07_Intersection();

  @Test
  void withTwoEmptyLists() {
    assertFalse(s.intersects(LinkedListNode.empty(), LinkedListNode.empty()));
  }

  @Test
  void withOneEmptyList() {
    assertFalse(s.intersects(LinkedListNode.empty(), LinkedListNode.of(1, 2, 3)));
    assertFalse(s.intersects(LinkedListNode.of(1, 2, 3), LinkedListNode.empty()));
  }

  @Test
  void withTwoSeparatedLists() {
    assertFalse(s.intersects(LinkedListNode.of(1, 2, 3), LinkedListNode.of(4, 5, 6)));
  }

  @Test
  void withTwoSeparatedLists_HavingSameValue() {
    assertFalse(s.intersects(LinkedListNode.of(1, 2, 3), LinkedListNode.of(4, 2, 3)));
  }

  @Test
  void withIntersectedLists() {
    LinkedListNode l1 = LinkedListNode.of(1, 2, 3, 4, 5);
    LinkedListNode l2 = LinkedListNode.of(6, 7, 8);
    l2.next.next.next = l1.next;
    assertTrue(s.intersects(l1, l2));
  }
}
