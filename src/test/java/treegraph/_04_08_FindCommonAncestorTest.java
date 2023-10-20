package treegraph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class _04_08_FindCommonAncestorTest {

  private _04_08_FindCommonAncestor s = new _04_08_FindCommonAncestor();

  @Test
  void withOneNode() {
    ParentAwareBinaryTreeNode node = new ParentAwareBinaryTreeNode(1);
    assertEquals(node, s.findCommonAncestor(node, node));
  }

  @Test
  void withTwoNodes() {
    ParentAwareBinaryTreeNode node = new ParentAwareBinaryTreeNode(1);
    node.addLeft(2);
    assertEquals(node, s.findCommonAncestor(node, node.left));
  }

  @Test
  void withThreeNodes() {
    ParentAwareBinaryTreeNode node = new ParentAwareBinaryTreeNode(1);
    node.addLeft(2);
    node.addRight(3);
    assertEquals(node, s.findCommonAncestor(node.left, node.right));
  }

  @Test
  void withMoreNodes() {
    ParentAwareBinaryTreeNode node = new ParentAwareBinaryTreeNode(1);
    node.addLeft(2);
    ParentAwareBinaryTreeNode ancestor = node.addRight(3);
    ParentAwareBinaryTreeNode a = ancestor.addLeft(4).addRight(5);
    ParentAwareBinaryTreeNode b = ancestor.addRight(6).addRight(7).addRight(8);
    assertEquals(ancestor, s.findCommonAncestor(a, b));
  }
}
