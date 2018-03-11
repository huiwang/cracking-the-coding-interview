package sortingsearching;

import org.junit.Assert;
import org.junit.Test;

public class _10_05_SparseSearchTest {

    private final _10_05_SparseSearch sparseSearch = new _10_05_SparseSearch();

    @Test
    public void withEmptyString() {
        Assert.assertEquals(-1, sparseSearch.find(new String[]{"hello", "", "world"}, ""));
    }

    @Test
    public void withValidString() {
        Assert.assertEquals(8, sparseSearch.find(
                new String[]{"hello", "", "", "idea", "", "", "", "", "world", "", "", "", "", "", "xylo", "", ""},
                "world"));

    }

    @Test
    public void withManySparse() {
        Assert.assertEquals(0, sparseSearch.find(
                new String[]{"hello", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                "hello"));

    }
    @Test
    public void withWordInTheEnd() {
        Assert.assertEquals(3, sparseSearch.find(
                new String[]{"", "", "", "hello"},
                "hello"));

    }
}