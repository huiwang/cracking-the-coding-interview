package com.truelaure.ctci.linkedlists;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class _02_03_DeleteMiddleNodeTest {
    @Test
    public void deleteMiddleNode() throws Exception {
        _02_03_DeleteMiddleNode solution = new _02_03_DeleteMiddleNode();
        LinkedListNode input = LinkedListNode.of(1, 2, 3);
        Assert.assertFalse(solution.deleteMiddleNode(null));
        Assert.assertFalse(solution.deleteMiddleNode(input.next.next));
        Assert.assertTrue(solution.deleteMiddleNode(input.next));
        Assert.assertEquals(LinkedListNode.of(1, 3), input);
    }

}