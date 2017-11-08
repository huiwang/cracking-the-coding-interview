package com.truelaure.ctci.linkedlists;

import org.junit.Test;

import static com.truelaure.ctci.linkedlists.LinkedListNode.*;
import static org.junit.Assert.*;

public class _02_07_IntersectionTest {

    private _02_07_Intersection s = new _02_07_Intersection();

    @Test
    public void withTwoEmptyLists() {
        assertFalse(s.intersects(empty(), empty()));
    }

    @Test
    public void withOneEmptyList() {
        assertFalse(s.intersects(empty(), of(1, 2, 3)));
        assertFalse(s.intersects(of(1, 2, 3), empty()));
    }

    @Test
    public void withTwoSeparatedLists() {
        assertFalse(s.intersects(of(1, 2, 3), of(4, 5, 6)));
    }

    @Test
    public void withTwoSeparatedLists_HavingSameValue() {
        assertFalse(s.intersects(of(1, 2, 3), of(4, 2, 3)));
    }

    @Test
    public void withIntersectedLists() {
        LinkedListNode l1 = of(1, 2, 3, 4, 5);
        LinkedListNode l2 = of(6, 7, 8);
        l2.next.next.next = l1.next;
        assertTrue(s.intersects(l1, l2));
    }
}