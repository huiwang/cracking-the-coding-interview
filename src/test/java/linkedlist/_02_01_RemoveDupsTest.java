package linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class _02_01_RemoveDupsTest {

  private _02_01_RemoveDups s = new _02_01_RemoveDups();

  @Test
  void withEmptyList() {
    assertEquals(LinkedListNode.empty(), s.removeDups(LinkedListNode.empty()));
  }

  @Test
  void withUniqueList() {
    assertEquals(LinkedListNode.of(1, 2, 3, 4), s.removeDups(LinkedListNode.of(1, 2, 3, 4)));
  }

  @Test
  void withDuplications() {
    assertEquals(LinkedListNode.of(1, 2, 3, 4), s.removeDups(LinkedListNode.of(1, 2, 2, 3, 2, 4)));
  }
}
