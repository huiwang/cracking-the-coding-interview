package sortingsearching;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class _10_02_GroupAnagramsTest {

    private _10_02_GroupAnagrams s = new _10_02_GroupAnagrams();

    @Test
    public void withEmpty() {
        Assert.assertEquals(Collections.emptyList(), s.groupAnagrams(Collections.emptyList()));
    }

    @Test
    public void withOneWord() {
        Assert.assertEquals(Collections.singletonList("hello"), s.groupAnagrams(Collections.singletonList("hello")));
    }

    @Test
    public void withThreeWords() {
        Assert.assertEquals(Arrays.asList("hello", "olelh", "world"), s.groupAnagrams(Arrays.asList("hello", "world", "olelh")));
    }

    @Test
    public void withFourWords() {
        Assert.assertEquals(Arrays.asList("hello", "olelh", "lrowd", "world"), s.groupAnagrams(Arrays.asList("hello", "lrowd", "olelh", "world")));
    }
}