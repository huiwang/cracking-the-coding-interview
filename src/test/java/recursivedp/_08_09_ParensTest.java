package recursivedp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import org.junit.jupiter.api.Test;

class _08_09_ParensTest {

  private final _08_09_Parens s = new _08_09_Parens();

  @Test
  void withZeroPair() {
    assertEquals(Collections.emptySet(), s.combine(0));
  }

  @Test
  void withOnePair() {
    assertEquals(Collections.singleton("()"), s.combine(1));
  }

  @Test
  void withTwoPairs() {
    assertEquals(new HashSet<>(Arrays.asList("()()", "(())")), s.combine(2));
  }

  @Test
  void withThreePairs() {
    assertEquals(
        new HashSet<>(Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()")),
        s.combine(3));
  }
}
