package treegraph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class _04_12_PathsWithSumTest {

  private _04_12_PathsWithSum s = new _04_12_PathsWithSum();

  @Test
  void withOneNode() {
    BinaryTreeNode root = new BinaryTreeNode(1);
    assertEquals(0, s.countPathWithSum(root, 2));
    assertEquals(1, s.countPathWithSum(root, 1));
  }

  @Test
  void withThreeNodes() {
    BinaryTreeNode root = new BinaryTreeNode(1);
    root.left = new BinaryTreeNode(1);
    root.right = new BinaryTreeNode(2);
    assertEquals(2, s.countPathWithSum(root, 1));
    assertEquals(2, s.countPathWithSum(root, 2));
    assertEquals(1, s.countPathWithSum(root, 3));
    assertEquals(0, s.countPathWithSum(root, 4));
  }

  @Test
  void withMoreDepths() {
    BinaryTreeNode root = new BinaryTreeNode(10);
    root.left = new BinaryTreeNode(5);
    root.left.left = new BinaryTreeNode(3);
    root.left.left.left = new BinaryTreeNode(3);
    root.left.left.right = new BinaryTreeNode(-2);
    root.left.right = new BinaryTreeNode(1);
    root.left.right.right = new BinaryTreeNode(2);

    root.right = new BinaryTreeNode(-3);
    root.right.right = new BinaryTreeNode(-11);

    assertEquals(2, s.countPathWithSum(root, 8));
  }
}
