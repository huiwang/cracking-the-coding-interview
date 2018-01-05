package recursivedp;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class _08_09_ParensTest {

    private final _08_09_Parens s = new _08_09_Parens();

    @Test
    public void withZeroPair() {
        Assert.assertEquals(Collections.emptySet(), s.combine(0));
    }

    @Test
    public void withOnePair() {
        Assert.assertEquals(Collections.singleton("()"), s.combine(1));
    }

    @Test
    public void withTwoPairs() {
        Assert.assertEquals(new HashSet<>(Arrays.asList("()()", "(())")), s.combine(2));
    }

    @Test
    public void withThreePairs() {
        Assert.assertEquals(new HashSet<>(Arrays.asList(
                "((()))",
                "(()())",
                "(())()",
                "()(())",
                "()()()")), s.combine(3));
    }
}