package com.truelaure.ctci.linkedlists;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class _02_01_RemoveDupsTest {
    @Test
    public void removeDups() throws Exception {
        _02_01_RemoveDups removeDups = new _02_01_RemoveDups();

        Assert.assertEquals(LinkedListNode.empty(), removeDups.removeDups(LinkedListNode.empty()));

        Assert.assertEquals(
                LinkedListNode.of(1, 2, 3, 4),
                removeDups.removeDups(LinkedListNode.of(1, 2, 3, 4)));

        Assert.assertEquals(
                LinkedListNode.of(1, 2, 3, 4),
                removeDups.removeDups(
                        LinkedListNode.of(1, 2, 2, 3, 2, 4)));
    }

}