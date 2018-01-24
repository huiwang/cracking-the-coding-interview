package sortingsearching;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class _10_01_SortedMergeTest {

    private _10_01_SortedMerge s = new _10_01_SortedMerge();

    @Test
    public void withOneElementEach() {
        Assert.assertTrue(Arrays.equals(new int[]{1, 2}, s.merge(new int[]{2, 0}, new int[]{1})));
    }

    @Test
    public void withMultipleElementsEach() {
        Assert.assertTrue(Arrays.equals(new int[]{2, 3, 4, 5, 6}, s.merge(new int[]{2, 4, 6, 0, 0}, new int[]{3, 5})));
    }
}