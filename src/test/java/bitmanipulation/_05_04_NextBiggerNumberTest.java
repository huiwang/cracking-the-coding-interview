package bitmanipulation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _05_04_NextBiggerNumberTest {

    private _05_04_NextBiggerNumber s = new _05_04_NextBiggerNumber();

    @Test
    public void withOne() {
        assertEquals(2, s.nextBigger(1));
    }

    @Test
    public void withIntegerTooBig() {
        assertEquals(-1, s.nextBigger(0x4000_0000));
    }

    @Test
    public void withTen() {
        assertEquals(12, s.nextBigger(10));
    }

    @Test
    public void withManyOnesZeros() {
        assertEquals(0x0008_ff03, s.nextBigger(0x0008_fee0));
    }

}