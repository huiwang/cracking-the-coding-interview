package bitmanipulation;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _05_05_DebuggerTest {

    private _05_05_Debugger s = new _05_05_Debugger();

    @Test
    public void withZero() {
        assertTrue(s.debug(0));
    }

    @Test
    public void withOne() {
        assertTrue(s.debug(1));
    }

    @Test
    public void withTwo() {
        assertTrue(s.debug(2));
    }

    @Test
    public void withThree() {
        assertFalse(s.debug(3));
    }

    @Test
    public void withFour() {
        assertTrue(s.debug(4));
    }

    @Test
    public void withFive() {
        assertFalse(s.debug(5));
    }

}