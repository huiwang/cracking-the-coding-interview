package com.truelaure.ctci.linkedlists;

import org.junit.Test;

import static com.truelaure.ctci.linkedlists.LinkedListNode.*;
import static org.junit.Assert.*;

public class _02_04_PartitionTest {

    private _02_04_Partition s = new _02_04_Partition();

    @Test
    public void withEmptyList() {
        assertEquals(empty(), s.partition(empty(), 8));
    }

    @Test
    public void withSortedList() {
        assertEquals(of(1, 2, 3), s.partition(of(1, 2, 3), 2));
    }

    @Test
    public void withSortedList_AndOutOfListX() {
        assertEquals(of(3, 2, 1), s.partition(of(1, 2, 3), 4));
    }

    @Test
    public void withSortedList_AndOutOfListX_Smaller() {
        assertEquals(of(1, 2, 3), s.partition(of(1, 2, 3), 0));
    }

    @Test
    public void withUnSortedList() {
        assertEquals(of(1, 2, 4, 3, 5), s.partition(of(4, 3, 2, 5, 1), 3));
    }

    @Test
    public void withUnSortedList_AndOutOfScopeX() {
        assertEquals(of(1, 2, 4, 3, 6), s.partition(of(3, 4, 2, 6, 1), 5));
    }

}