package bitmanipulation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _05_02_BinaryToStringTest {

    private _05_02_BinaryToString s = new _05_02_BinaryToString();

    @Test
    public void withZero() {
        assertEquals("ERROR", s.print(0));
    }

    @Test
    public void withOne() {
        assertEquals("ERROR", s.print(1));
    }

    @Test
    public void withOneBit() {
        assertEquals(".1", s.print(0.5));
    }

    @Test
    public void withTwoBits() {
        assertEquals(".11", s.print(0.75));
    }

    @Test
    public void withThreeBits() {
        assertEquals(".101", s.print(0.625));
    }

    @Test
    public void withUndoable() {
        assertEquals("ERROR", s.print(0.1));
    }

}