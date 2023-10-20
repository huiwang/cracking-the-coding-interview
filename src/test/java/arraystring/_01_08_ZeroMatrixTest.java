package arraystring;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class _01_08_ZeroMatrixTest {

  @Test
  void withEmpty() {
    assertTrue(Arrays.deepEquals(new int[][] {{}}, new _01_08_ZeroMatrix().zero(new int[][] {{}})));
  }

  @Test
  void withOneOne() {
    assertTrue(
        Arrays.deepEquals(new int[][] {{1}}, new _01_08_ZeroMatrix().zero(new int[][] {{1}})));
  }

  @Test
  void withOneOne_Zero() {
    assertTrue(
        Arrays.deepEquals(new int[][] {{0}}, new _01_08_ZeroMatrix().zero(new int[][] {{0}})));
  }

  @Test
  void withOneTwo() {
    assertTrue(
        Arrays.deepEquals(
            new int[][] {{0, 0}}, new _01_08_ZeroMatrix().zero(new int[][] {{0, 0}})));
  }

  @Test
  void withTwoTwo() {
    assertTrue(
        Arrays.deepEquals(
            new int[][] {{0, 0}, {0, 1}},
            new _01_08_ZeroMatrix().zero(new int[][] {{0, 1}, {1, 1}})));
  }

  @Test
  void withThreeTree() {
    assertTrue(
        Arrays.deepEquals(
            new int[][] {
              {1, 0, 3},
              {0, 0, 0},
              {7, 0, 9}
            },
            new _01_08_ZeroMatrix()
                .zero(
                    new int[][] {
                      {1, 2, 3},
                      {4, 0, 6},
                      {7, 8, 9}
                    })));
  }
}
