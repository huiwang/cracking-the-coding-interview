package recursivedp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _08_05_RecursiveMultiplyTest {

    private _08_05_RecursiveMultiply s = new _08_05_RecursiveMultiply();

    @Test
    public void testOneOne() {
        assertEquals(1, s.multiple(1, 1));
    }

    @Test
    public void testOneTwo() {
        assertEquals(2, s.multiple(1, 2));
    }

    @Test
    public void testFiveNine() {
        assertEquals(45, s.multiple(5, 9));
    }

    @Test
    public void testThirtyForty() {
        assertEquals(1200, s.multiple(40, 30));
    }
}