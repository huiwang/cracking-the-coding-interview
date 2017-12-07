package arraystring;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _01_02_CheckPermutationTest {

    private _01_02_CheckPermutation s = new _01_02_CheckPermutation();

    @Test
    public void withEmptyString() {
        assertTrue(s.check("", ""));
    }

    @Test
    public void withOneSingleChar() {
        assertTrue(s.check("a", "a"));
    }

    @Test
    public void withOneSingleDifferentChar() {
        assertFalse(s.check("a", "b"));
    }

    @Test
    public void withThreeChars() {
        assertTrue(s.check("abc", "bac"));
    }

    @Test
    public void withRepeatingChars() {
        assertTrue(s.check("aabbc", "bcaba"));
    }

    @Test
    public void withDifferentLength() {
        assertFalse(s.check("abc", "ab"));
    }
}