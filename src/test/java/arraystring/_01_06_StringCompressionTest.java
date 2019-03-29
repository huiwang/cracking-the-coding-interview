package arraystring;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _01_06_StringCompressionTest {

    private _01_06_StringCompression s = new _01_06_StringCompression();

    @Test
    public void withOneSingleChar() {
        assertEquals("a", s.compress("a"));
    }

    @Test
    public void withTwoChars() {
        assertEquals("aa", s.compress("aa"));
    }

    @Test
    public void withThreeChars() {
        assertEquals("a3", s.compress("aaa"));
    }

    @Test
    public void withDifferentChars() {
        assertEquals("aaab", s.compress("aaab"));
    }

    @Test
    public void withDifferentChars_RepeatingSeveralTimes() {
        assertEquals("a3b2", s.compress("aaabb"));
    }

    @Test
    public void withDifferentChars_RepeatingInMoreSeqs() {
        assertEquals("a3b2a2", s.compress("aaabbaa"));
    }

}