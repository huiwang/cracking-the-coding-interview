package treegraph;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class _04_10_CheckSubTreeTest {

  private _04_10_CheckSubTree s = new _04_10_CheckSubTree();

  @Test
  void withOneNode() {
    BinaryTreeNode a = new BinaryTreeNode(1);
    BinaryTreeNode b = new BinaryTreeNode(1);
    assertTrue(s.isSubTree(a, b));
  }

  @Test
  void withTwoNodes() {
    BinaryTreeNode a = new BinaryTreeNode(1);
    a.left = new BinaryTreeNode(2);
    BinaryTreeNode b = new BinaryTreeNode(2);
    assertTrue(s.isSubTree(a, b));
  }

  @Test
  void withMoreNodes() {
    BinaryTreeNode a = new BinaryTreeNode(1);
    a.right = new BinaryTreeNode(2);
    a.right.right = new BinaryTreeNode(3);
    a.right.right.left = new BinaryTreeNode(4);
    a.right.right.right = new BinaryTreeNode(5);

    BinaryTreeNode b = new BinaryTreeNode(3);
    b.left = new BinaryTreeNode(4);
    b.right = new BinaryTreeNode(5);

    assertTrue(s.isSubTree(a, b));
  }

  @Test
  void withDiffTree() {
    BinaryTreeNode a = new BinaryTreeNode(1);
    a.left = new BinaryTreeNode(2);
    a.right = new BinaryTreeNode(3);
    BinaryTreeNode b = new BinaryTreeNode(4);
    assertFalse(s.isSubTree(a, b));
  }

  @Test
  void withSamePreOrder() {
    BinaryTreeNode a = new BinaryTreeNode(1);
    a.left = new BinaryTreeNode(2);
    a.right = new BinaryTreeNode(3);

    BinaryTreeNode b = new BinaryTreeNode(1);
    b.right = new BinaryTreeNode(2);
    b.left = new BinaryTreeNode(3);

    assertFalse(s.isSubTree(a, b));
  }
}
