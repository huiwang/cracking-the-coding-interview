package linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class _02_05_SumListReverseTest {

  private _02_05_SumListReverse s = new _02_05_SumListReverse();

  @Test
  void withTwoEmptyLists() {
    assertEquals(LinkedListNode.empty(), s.sum(LinkedListNode.empty(), LinkedListNode.empty()));
  }

  @Test
  void withOneEmptyList() {
    assertEquals(
        LinkedListNode.of(1, 2, 3), s.sum(LinkedListNode.empty(), LinkedListNode.of(1, 2, 3)));
  }

  @Test
  void withNoCarry() {
    assertEquals(
        LinkedListNode.of(2, 4, 6), s.sum(LinkedListNode.of(1, 2, 3), LinkedListNode.of(1, 2, 3)));
  }

  @Test
  void withCarry() {
    assertEquals(
        LinkedListNode.of(0, 4, 6), s.sum(LinkedListNode.of(1, 8, 3), LinkedListNode.of(9, 5, 2)));
  }

  @Test
  void withCarryAtEnd() {
    assertEquals(
        LinkedListNode.of(0, 4, 2, 1),
        s.sum(LinkedListNode.of(1, 8, 9), LinkedListNode.of(9, 5, 2)));
  }
}
