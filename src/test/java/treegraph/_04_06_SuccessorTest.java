package treegraph;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class _04_06_SuccessorTest {

    private _04_06_Successor s = new _04_06_Successor();

    @Test
    public void withOneNode() {
        assertNull(s.findInOrderSuccessor(new ParentAwareBinaryTreeNode(1)));
    }

    @Test
    public void withTwoNodes() {
        ParentAwareBinaryTreeNode root = new ParentAwareBinaryTreeNode(2);
        root.addLeft(1);
        assertEquals(2, s.findInOrderSuccessor(root.left).val);
    }

    @Test
    public void withFourNodes() {
        ParentAwareBinaryTreeNode root = new ParentAwareBinaryTreeNode(2);
        root.addLeft(1);
        root.addRight(4).addRight(6).addLeft(5);
        assertEquals(4, s.findInOrderSuccessor(root).val);
    }

    @Test
    public void withTargetNodeARightNode() {
        ParentAwareBinaryTreeNode root = new ParentAwareBinaryTreeNode(6);
        root.addLeft(4).addRight(5);
        assertEquals(6, s.findInOrderSuccessor(root.left.right).val);
    }

    @Test
    public void withTargetNodeARightNode_AndWithChild() {
        ParentAwareBinaryTreeNode root = new ParentAwareBinaryTreeNode(8);
        root.addLeft(4).addRight(6).addRight(7);
        assertEquals(7, s.findInOrderSuccessor(root.left.right).val);
    }

    @Test
    public void withTargetNodeADeepRightNode() {
        ParentAwareBinaryTreeNode root = new ParentAwareBinaryTreeNode(8);
        root.addLeft(1).addRight(2).addRight(3).addRight(4);
        assertEquals(8, s.findInOrderSuccessor(root.left.right.right.right).val);
    }
}