package treegraph;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class _04_11_RandomNodeTest {

  @Test
  void withSimpleCase() {
    _04_11_RandomNode.Tree tree = new _04_11_RandomNode.Tree();
    tree.insert(5);
    tree.insert(2);
    tree.insert(1);
    tree.insert(3);
    tree.insert(6);
    assertEquals(3, tree.find(3).getVal());
    assertNull(tree.find(4));
    assertNotNull(tree.getRandomNode());
  }
}
