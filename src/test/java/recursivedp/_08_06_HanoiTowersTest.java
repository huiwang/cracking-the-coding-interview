package recursivedp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class _08_06_HanoiTowersTest {

  private _08_06_HanoiTowers s = new _08_06_HanoiTowers();

  @Test
  void withOneDisk() {
    assertEquals(Arrays.asList(1, 3), s.leftToRight(1));
  }

  @Test
  void withTwoDisk() {
    assertEquals(
        Arrays.asList(
            1, 2,
            1, 3,
            2, 3),
        s.leftToRight(2));
  }

  @Test
  void withThreeDisks() {
    assertEquals(
        Arrays.asList(
            1, 3,
            1, 2,
            3, 2,
            1, 3,
            2, 1,
            2, 3,
            1, 3),
        s.leftToRight(3));
  }
}
