package com.truelaure.ctci.linkedlist;

import org.junit.Test;

import static com.truelaure.ctci.linkedlist.LinkedListNode.of;
import static org.junit.Assert.*;

public class _02_03_DeleteMiddleNodeTest {

    private _02_03_DeleteMiddleNode s = new _02_03_DeleteMiddleNode();

    @Test
    public void withNull() {
        assertFalse(s.deleteMiddleNode(null));
    }

    @Test
    public void withLastNode() {
        assertFalse(s.deleteMiddleNode(of(1, 2, 3).next.next));
    }

    @Test
    public void withMiddleNode() {
        LinkedListNode input = of(1, 2, 3);
        assertTrue(s.deleteMiddleNode(input.next));
        assertEquals(of(1, 3), input);
    }

}