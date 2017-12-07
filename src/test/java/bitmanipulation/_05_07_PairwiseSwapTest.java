package bitmanipulation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _05_07_PairwiseSwapTest {

    private _05_07_PairwiseSwap s = new _05_07_PairwiseSwap();

    @Test
    public void withZero() {
        assertEquals(0, s.swap(0));
    }

    @Test
    public void withOne() {
        assertEquals(2, s.swap(1));
    }

    @Test
    public void withTwo() {
        assertEquals(1, s.swap(2));
    }

    @Test
    public void withTen() {
        assertEquals(5, s.swap(10));
    }

    @Test
    public void withTenEveryWhere() {
        assertEquals(0x5555_5555, s.swap(0xaaaa_aaaa));
    }
}