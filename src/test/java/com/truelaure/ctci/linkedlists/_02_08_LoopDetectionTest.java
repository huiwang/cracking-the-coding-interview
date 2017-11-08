package com.truelaure.ctci.linkedlists;

import org.junit.Test;

import static com.truelaure.ctci.linkedlists.LinkedListNode.*;
import static org.junit.Assert.*;

public class _02_08_LoopDetectionTest {

    private _02_08_LoopDetection s = new _02_08_LoopDetection();

    @Test
    public void withEmptyList() {
        assertNull(s.detect(empty()));
    }

    @Test
    public void withListWithoutLoop() {
        assertNull(s.detect(of(1, 2, 3)));
    }

    @Test
    public void testWithLoop_FromListHead() {
        LinkedListNode list = of(1, 2, 3, 4, 5);
        list.next.next.next.next.next = list;
        assertEquals(1, s.detect(list).val);
    }

    @Test
    public void testWithLoop_FromListTail() {
        LinkedListNode list = of(1, 2, 3, 4, 5);
        LinkedListNode tail = list.next.next.next.next;
        tail.next = tail;
        assertEquals(5, s.detect(list).val);
    }

    @Test
    public void testWithLoop_FromListMiddle() {
        LinkedListNode list = of(1, 2, 3, 4, 5);
        list.next.next.next.next.next = list.next;
        assertEquals(2, s.detect(list).val);
    }
}