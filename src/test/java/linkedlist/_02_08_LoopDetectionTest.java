package linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class _02_08_LoopDetectionTest {

  private final _02_08_LoopDetection s = new _02_08_LoopDetection();

  @Test
  void withEmptyList() {
    assertNull(s.detect(LinkedListNode.empty()));
  }

  @Test
  void withListWithoutLoop() {
    assertNull(s.detect(LinkedListNode.of(1, 2, 3)));
  }

  @Test
  void testWithLoop_FromListHead() {
    LinkedListNode list = LinkedListNode.of(1, 2, 3, 4, 5);
    list.next.next.next.next.next = list;
    assertEquals(1, s.detect(list).val);
  }

  @Test
  void testWithLoop_FromListTail() {
    LinkedListNode list = LinkedListNode.of(1, 2, 3, 4, 5);
    LinkedListNode tail = list.next.next.next.next;
    tail.next = tail;
    assertEquals(5, s.detect(list).val);
  }

  @Test
  void testWithLoop_FromListMiddle() {
    LinkedListNode list = LinkedListNode.of(1, 2, 3, 4, 5);
    list.next.next.next.next.next = list.next;
    assertEquals(2, s.detect(list).val);
  }
}
