package linkedlist;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _02_03_DeleteMiddleNodeTest {

    private _02_03_DeleteMiddleNode s = new _02_03_DeleteMiddleNode();

    @Test
    public void withNull() {
        assertFalse(s.deleteMiddleNode(null));
    }

    @Test
    public void withLastNode() {
        assertFalse(s.deleteMiddleNode(LinkedListNode.of(1, 2, 3).next.next));
    }

    @Test
    public void withMiddleNode() {
        LinkedListNode input = LinkedListNode.of(1, 2, 3);
        assertTrue(s.deleteMiddleNode(input.next));
        Assert.assertEquals(LinkedListNode.of(1, 3), input);
    }

}