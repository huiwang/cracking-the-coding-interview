package moderate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class _16_06_SmallestDifferenceTest {

  private _16_06_SmallestDifference s = new _16_06_SmallestDifference();

  @Test
  void withOneValueEach() {
    assertEquals(1, s.findSmallestDiff(new int[] {1}, new int[] {2}));
  }

  @Test
  void withOneValueLeft_TwoValuesRight() {
    assertEquals(1, s.findSmallestDiff(new int[] {5}, new int[] {3, 6}));
  }

  @Test
  void withMultipleValuesEach() {
    assertEquals(
        3, s.findSmallestDiff(new int[] {1, 3, 15, 11, 2}, new int[] {23, 127, 235, 19, 8}));
  }
}
