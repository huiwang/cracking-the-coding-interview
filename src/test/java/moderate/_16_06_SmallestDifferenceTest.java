package moderate;

import org.junit.Assert;
import org.junit.Test;

public class _16_06_SmallestDifferenceTest {

    private _16_06_SmallestDifference s = new _16_06_SmallestDifference();

    @Test
    public void withOneValueEach() {
        Assert.assertEquals(1, s.findSmallestDiff(new int[]{1}, new int[]{2}));
    }

    @Test
    public void withOneValueLeft_TwoValuesRight() {
        Assert.assertEquals(1, s.findSmallestDiff(new int[]{5}, new int[]{3, 6}));
    }

    @Test
    public void withMultipleValuesEach() {
        Assert.assertEquals(3, s.findSmallestDiff(new int[]{1, 3, 15, 11, 2}, new int[]{23, 127, 235, 19, 8}));
    }
}