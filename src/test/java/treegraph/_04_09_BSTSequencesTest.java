package treegraph;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class _04_09_BSTSequencesTest {

    private _04_09_BSTSequences s = new _04_09_BSTSequences();

    @Test
    public void withOneNode() {
        assertEquals(Collections.singletonList(Collections.singletonList(1)), s.sequences(new BinaryTreeNode(1)));
    }

    @Test
    public void withTwoNodes() {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.right = new BinaryTreeNode(2);
        assertEquals(Collections.singletonList(Arrays.asList(1, 2)), s.sequences(root));
    }

    @Test
    public void withThreeNodes() {
        BinaryTreeNode root = new BinaryTreeNode(2);
        root.left = new BinaryTreeNode(1);
        root.right = new BinaryTreeNode(3);
        assertEquals(Arrays.asList(Arrays.asList(2, 1, 3), Arrays.asList(2, 3, 1)), s.sequences(root));
    }

    @Test
    public void withMoreNodes() {
        BinaryTreeNode root = new BinaryTreeNode(5);
        root.left = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(2);
        root.left.right = new BinaryTreeNode(4);
        root.right = new BinaryTreeNode(7);
        assertEquals(
                Arrays.asList(
                        Arrays.asList(5, 3, 2, 4, 7),
                        Arrays.asList(5, 3, 2, 7, 4),
                        Arrays.asList(5, 3, 7, 2, 4),
                        Arrays.asList(5, 7, 3, 2, 4),
                        Arrays.asList(5, 3, 4, 2, 7),
                        Arrays.asList(5, 3, 4, 7, 2),
                        Arrays.asList(5, 3, 7, 4, 2),
                        Arrays.asList(5, 7, 3, 4, 2)
                ),
                s.sequences(root));
    }
}