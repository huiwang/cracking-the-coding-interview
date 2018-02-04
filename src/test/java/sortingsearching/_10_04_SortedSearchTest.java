package sortingsearching;

import org.junit.Assert;
import org.junit.Test;
import sortingsearching._10_04_SortedSearch.Listy;

public class _10_04_SortedSearchTest {

    private _10_04_SortedSearch s = new _10_04_SortedSearch();

    @Test
    public void withEmptyListy() {
        Assert.assertEquals(-1, s.sortedSearch(Listy.of(), 1));
    }

    @Test
    public void withOneElem() {
        Assert.assertEquals(0, s.sortedSearch(Listy.of(1), 1));
    }

    @Test
    public void withMultipleElems() {
        Assert.assertEquals(3, s.sortedSearch(Listy.of(1, 3, 4, 5, 8, 10), 5));
        Assert.assertEquals(-1, s.sortedSearch(Listy.of(1, 3, 4, 5, 8, 10), 6));
    }

    @Test
    public void withDuplicates() {
        int actual = s.sortedSearch(Listy.of(1, 3, 4, 5, 5, 10), 5);
        Assert.assertTrue(actual == 3 || actual == 4);
    }
}