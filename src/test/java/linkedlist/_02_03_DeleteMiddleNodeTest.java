package linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class _02_03_DeleteMiddleNodeTest {

  private _02_03_DeleteMiddleNode s = new _02_03_DeleteMiddleNode();

  @Test
  void withNull() {
    assertFalse(s.deleteMiddleNode(null));
  }

  @Test
  void withLastNode() {
    assertFalse(s.deleteMiddleNode(LinkedListNode.of(1, 2, 3).next.next));
  }

  @Test
  void withMiddleNode() {
    LinkedListNode input = LinkedListNode.of(1, 2, 3);
    assertTrue(s.deleteMiddleNode(input.next));
    assertEquals(LinkedListNode.of(1, 3), input);
  }
}
