package com.truelaure.ctci.linkedlists;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class _02_02_ReturnKthToLastTest {
    @Test
    public void returnKthToLast() throws Exception {
        _02_02_ReturnKthToLast kthToLast = new _02_02_ReturnKthToLast();
        Assert.assertEquals(3, kthToLast.returnKthToLast(LinkedListNode.of(1, 2, 3), 0).val);
        Assert.assertEquals(2, kthToLast.returnKthToLast(LinkedListNode.of(1, 2, 3), 1).val);
        Assert.assertEquals(1, kthToLast.returnKthToLast(LinkedListNode.of(1, 2, 3), 2).val);
        Assert.assertNull(kthToLast.returnKthToLast(LinkedListNode.of(1, 2, 3), 3));
    }

}