package treegraph;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class _04_02_MinimalTreeTest {

    private _04_02_MinimalTree s = new _04_02_MinimalTree();

    @Test
    public void withOneElement() {
        BinaryTreeNode binaryTreeNode = s.buildMinimalTree(new int[]{1});
        assertEquals(1, binaryTreeNode.val);
        assertNull(binaryTreeNode.left);
        assertNull(binaryTreeNode.right);
    }

    @Test
    public void withTwoElements() {
        BinaryTreeNode binaryTreeNode = s.buildMinimalTree(new int[]{1, 2});
        assertEquals(1, binaryTreeNode.val);
        assertEquals(2, binaryTreeNode.right.val);
        assertEquals(null, binaryTreeNode.left);
    }

    @Test
    public void withThreeElements() {
        BinaryTreeNode binaryTreeNode = s.buildMinimalTree(new int[]{1, 2, 3});
        assertEquals(2, binaryTreeNode.val);
        assertEquals(1, binaryTreeNode.left.val);
        assertEquals(3, binaryTreeNode.right.val);
    }

    @Test
    public void withFourElements() {
        BinaryTreeNode binaryTreeNode = s.buildMinimalTree(new int[]{1, 2, 3, 4});
        assertEquals(2, binaryTreeNode.val);
        assertEquals(1, binaryTreeNode.left.val);
        assertEquals(3, binaryTreeNode.right.val);
        assertEquals(4, binaryTreeNode.right.right.val);
    }

}