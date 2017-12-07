package bitmanipulation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _05_04_NextSmallerNumberTest {

    private _05_04_NextSmallerNumber s = new _05_04_NextSmallerNumber();

    @Test
    public void withOne() {
        assertEquals(-1, s.nextSmaller(1));
    }

    @Test
    public void withIntegerTooSmall() {
        assertEquals(-1, s.nextSmaller(3));
    }

    @Test
    public void withTen() {
        assertEquals(9, s.nextSmaller(10));
    }

    @Test
    public void withManyOnesZeros() {
        assertEquals(0x0008_fee0, s.nextSmaller(0x0008_ff03));
    }

}