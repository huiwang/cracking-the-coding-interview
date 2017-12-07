package treegraph;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _04_05_ValidateBSTTest {

    private _04_05_ValidateBST s = new _04_05_ValidateBST();

    @Test
    public void withOneNode() {
        assertTrue(s.isBST(new BinaryTreeNode(1)));
    }

    @Test
    public void withTwoNodes() {
        BinaryTreeNode node = new BinaryTreeNode(2);
        node.left = new BinaryTreeNode(1);
        assertTrue(s.isBST(node));
    }

    @Test
    public void withThreeNodes() {
        BinaryTreeNode node = new BinaryTreeNode(2);
        node.left = new BinaryTreeNode(1);
        node.right = new BinaryTreeNode(3);
        assertTrue(s.isBST(node));
    }

    @Test
    public void withTreeNodes_NotBalanced() {
        BinaryTreeNode node = new BinaryTreeNode(2);
        node.left = new BinaryTreeNode(1);
        node.right = new BinaryTreeNode(1);
        assertFalse(s.isBST(node));
    }

}