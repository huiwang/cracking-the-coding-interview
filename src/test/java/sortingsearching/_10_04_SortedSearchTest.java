package sortingsearching;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import sortingsearching._10_04_SortedSearch.Listy;

class _10_04_SortedSearchTest {

  private _10_04_SortedSearch s = new _10_04_SortedSearch();

  @Test
  void withEmptyListy() {
    assertEquals(-1, s.sortedSearch(Listy.of(), 1));
  }

  @Test
  void withOneElem() {
    assertEquals(0, s.sortedSearch(Listy.of(1), 1));
  }

  @Test
  void withMultipleElems() {
    assertEquals(3, s.sortedSearch(Listy.of(1, 3, 4, 5, 8, 10), 5));
    assertEquals(-1, s.sortedSearch(Listy.of(1, 3, 4, 5, 8, 10), 6));
  }

  @Test
  void withDuplicates() {
    int actual = s.sortedSearch(Listy.of(1, 3, 4, 5, 5, 10), 5);
    assertTrue(actual == 3 || actual == 4);
  }
}
