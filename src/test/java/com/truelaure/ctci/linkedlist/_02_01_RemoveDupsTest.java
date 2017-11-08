package com.truelaure.ctci.linkedlist;

import org.junit.Test;

import static com.truelaure.ctci.linkedlist.LinkedListNode.empty;
import static com.truelaure.ctci.linkedlist.LinkedListNode.of;
import static org.junit.Assert.assertEquals;

public class _02_01_RemoveDupsTest {

    private _02_01_RemoveDups s = new _02_01_RemoveDups();

    @Test
    public void withEmptyList() {
        assertEquals(empty(), s.removeDups(empty()));
    }

    @Test
    public void withUniqueList() {
        assertEquals(of(1, 2, 3, 4), s.removeDups(of(1, 2, 3, 4)));
    }

    @Test
    public void withDuplications() {
        assertEquals(of(1, 2, 3, 4), s.removeDups(of(1, 2, 2, 3, 2, 4)));
    }

}