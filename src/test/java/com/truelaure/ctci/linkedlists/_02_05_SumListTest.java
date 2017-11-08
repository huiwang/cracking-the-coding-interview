package com.truelaure.ctci.linkedlists;

import org.junit.Test;

import static com.truelaure.ctci.linkedlists.LinkedListNode.*;
import static org.junit.Assert.*;

public class _02_05_SumListTest {

    private _02_05_SumList s = new _02_05_SumList();

    @Test
    public void withTwoEmptyLists() {
        assertEquals(empty(), s.sum(empty(), empty()));
    }

    @Test
    public void withOneEmptyList() {
        assertEquals(of(1, 2, 3), s.sum(empty(), of(1, 2, 3)));
    }

    @Test
    public void withNoCarry() {
        assertEquals(of(2, 4, 6), s.sum(of(1, 2, 3), of(1, 2, 3)));
    }

    @Test
    public void withCarry() {
        assertEquals(of(0, 4, 6), s.sum(of(1, 8, 3), of(9, 5, 2)));
    }

    @Test
    public void withCarryAtEnd() {
        assertEquals(of(0, 4, 2, 1), s.sum(of(1, 8, 9), of(9, 5, 2)));
    }
}