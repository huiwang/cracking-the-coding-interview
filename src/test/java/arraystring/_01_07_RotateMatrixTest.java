package arraystring;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class _01_07_RotateMatrixTest {

  private _01_07_RotateMatrix s = new _01_07_RotateMatrix();

  @Test
  void withOneOne() {
    assertTrue(Arrays.deepEquals(new int[][] {{1}}, s.rotate(new int[][] {{1}})));
  }

  @Test
  void withTwoTwo() {
    assertTrue(
        Arrays.deepEquals(
            new int[][] {
              {3, 1},
              {4, 2}
            },
            s.rotate(
                new int[][] {
                  {1, 2},
                  {3, 4}
                })));
  }

  @Test
  void withThreeThree() {
    assertTrue(
        Arrays.deepEquals(
            new int[][] {
              {7, 4, 1},
              {8, 5, 2},
              {9, 6, 3}
            },
            s.rotate(
                new int[][] {
                  {1, 2, 3},
                  {4, 5, 6},
                  {7, 8, 9}
                })));
  }
}
