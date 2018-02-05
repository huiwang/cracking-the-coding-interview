package sortingsearching;

import org.junit.Assert;
import org.junit.Test;

public class _10_03_SearchInRotatedArrayTest {

    private _10_03_SearchInRotatedArray s = new _10_03_SearchInRotatedArray();

    @Test
    public void withOneElement() {
        Assert.assertEquals(-1, s.find(new int[]{1}, 2));
        Assert.assertEquals(0, s.find(new int[]{1}, 1));
    }

    @Test
    public void withTwoElement() {
        Assert.assertEquals(1, s.find(new int[]{2, 1}, 1));
        Assert.assertEquals(0, s.find(new int[]{2, 1}, 2));
        Assert.assertEquals(-1, s.find(new int[]{2, 1}, 0));
    }

    @Test
    public void withMultipleElements() {
        Assert.assertEquals(8, s.find(new int[]{15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}, 5));
    }

    @Test
    public void withDuplicates() {
        Assert.assertEquals(8, s.find(new int[]{20, 20, 20, 20, 20, 20, 20, 20, 5, 7, 10, 14}, 5));
        int r = s.find(new int[]{20, 20, 20, 20, 20, 20, 20, 20, 5, 7, 10, 14}, 20);
        Assert.assertTrue(r >= 0 && r <= 7);
    }
}