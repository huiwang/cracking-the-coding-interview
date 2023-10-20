package treegraph;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class _04_05_ValidateBSTTest {

  private _04_05_ValidateBST s = new _04_05_ValidateBST();

  @Test
  void withOneNode() {
    assertTrue(s.isBST(new BinaryTreeNode(1)));
  }

  @Test
  void withTwoNodes() {
    BinaryTreeNode node = new BinaryTreeNode(2);
    node.left = new BinaryTreeNode(1);
    assertTrue(s.isBST(node));
  }

  @Test
  void withThreeNodes() {
    BinaryTreeNode node = new BinaryTreeNode(2);
    node.left = new BinaryTreeNode(1);
    node.right = new BinaryTreeNode(3);
    assertTrue(s.isBST(node));
  }

  @Test
  void withTreeNodes_NotBalanced() {
    BinaryTreeNode node = new BinaryTreeNode(2);
    node.left = new BinaryTreeNode(1);
    node.right = new BinaryTreeNode(1);
    assertFalse(s.isBST(node));
  }
}
