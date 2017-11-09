package com.truelaurel.ctci.bitmanipulation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _05_04_NextNumberTest {

    private _05_04_NextNumber s = new _05_04_NextNumber();

    @Test
    public void withOne() {
        assertEquals(2, s.nextLargest(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void withIntegerTooBig() {
        s.nextLargest(0x4000_0000);
    }

    @Test
    public void withTen() {
        assertEquals(12, s.nextLargest(10));
    }

    @Test
    public void withManyOnesZeros() {
        assertEquals(0x0008_ff03, s.nextLargest(0x0008_fee0));
    }

}