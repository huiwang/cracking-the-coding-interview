package sortingsearching;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class _10_03_SearchInRotatedArrayTest {

  private _10_03_SearchInRotatedArray s = new _10_03_SearchInRotatedArray();

  @Test
  void withOneElement() {
    assertEquals(-1, s.find(new int[] {1}, 2));
    assertEquals(0, s.find(new int[] {1}, 1));
  }

  @Test
  void withTwoElement() {
    assertEquals(1, s.find(new int[] {2, 1}, 1));
    assertEquals(0, s.find(new int[] {2, 1}, 2));
    assertEquals(-1, s.find(new int[] {2, 1}, 0));
  }

  @Test
  void withMultipleElements() {
    assertEquals(8, s.find(new int[] {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}, 5));
  }

  @Test
  void withDuplicates() {
    assertEquals(8, s.find(new int[] {20, 20, 20, 20, 20, 20, 20, 20, 5, 7, 10, 14}, 5));
    int r = s.find(new int[] {20, 20, 20, 20, 20, 20, 20, 20, 5, 7, 10, 14}, 20);
    assertTrue(r >= 0 && r <= 7);
  }
}
