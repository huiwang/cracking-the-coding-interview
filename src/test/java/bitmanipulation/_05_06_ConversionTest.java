package bitmanipulation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _05_06_ConversionTest {

    private _05_06_Conversion s = new _05_06_Conversion();

    @Test
    public void withZeroAndOne() {
        assertEquals(1, s.convert(0, 1));
    }

    @Test
    public void withOneAndOne() {
        assertEquals(0, s.convert(1, 1));
    }

    @Test
    public void withOneAndTwo() {
        assertEquals(2, s.convert(1, 2));
    }

    @Test
    public void withZeroAndThree() {
        assertEquals(2, s.convert(0, 3));
    }
}