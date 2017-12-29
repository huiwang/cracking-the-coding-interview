package recursivedp;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class _08_07_PermutationWithoutDupTest {

    private _08_07_PermutationWithoutDup f = new _08_07_PermutationWithoutDup();

    @Test
    public void withEmptyString() {
        assertEquals(Collections.singleton(""), f.computePermutation(""));
    }

    @Test
    public void withOneChar() {
        assertEquals(Collections.singleton("a"), f.computePermutation("a"));
    }

    @Test
    public void withTwoChars() {
        assertEquals(new HashSet<>(Arrays.asList("ab", "ba")), f.computePermutation("ab"));
        assertEquals(new HashSet<>(Arrays.asList("ab", "ba")), f.computePermutation("ba"));
    }

    @Test
    public void withThreeChars() {
        HashSet<String> result = new HashSet<>(Arrays.asList("abc", "acb", "bca", "bac", "cab", "cba"));
        assertEquals(result, f.computePermutation("abc"));
        assertEquals(result, f.computePermutation("acb"));
        assertEquals(result, f.computePermutation("bca"));
    }

}