package recursivedp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class _08_01_TripleStepTest {

  private _08_01_TripleStep s = new _08_01_TripleStep();

  @Test
  void withZeroStep() {
    assertEquals(1, s.countWays(0));
  }

  @Test
  void withOneStep() {
    assertEquals(1, s.countWays(1));
  }

  @Test
  void withTwoSteps() {
    assertEquals(2, s.countWays(2));
  }

  @Test
  void withTreeSteps() {
    assertEquals(4, s.countWays(3));
  }

  @Test
  void withFourSteps() {
    // 3+1
    //  3
    //  2+1
    //  1+2
    //  1+1+1
    // 2+2
    //  2
    //  1+1
    // 1+3
    //  1
    assertEquals(7, s.countWays(4));
  }

  @Test
  void withFiveSteps() {
    assertEquals(13, s.countWays(5));
  }
}
