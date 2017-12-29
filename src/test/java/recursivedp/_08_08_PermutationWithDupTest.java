package recursivedp;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class _08_08_PermutationWithDupTest {

    private _08_08_PermutationWithDup s = new _08_08_PermutationWithDup();

    @Test
    public void withEmptyString() {
        assertEquals(Collections.singleton(""), s.computePermutation(""));
    }

    @Test
    public void withOneChar() {
        assertEquals(Collections.singleton("a"), s.computePermutation("a"));
    }

    @Test
    public void withTwoChars() {
        assertEquals(Collections.singleton("aa"), s.computePermutation("aa"));
    }

    @Test
    public void withThreeChars() {
        HashSet<String> result = new HashSet<>(Arrays.asList("aab", "aba", "baa"));
        assertEquals(result, s.computePermutation("aba"));
    }

    @Test
    public void withManySameChar() {
        String str = "aaaaaaaaaaaa";
        assertEquals(Collections.singleton(str), s.computePermutation(str));
    }

}