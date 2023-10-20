package arraystring;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class _01_02_CheckPermutationTest {

  private _01_02_CheckPermutation s = new _01_02_CheckPermutation();

  @Test
  void withEmptyString() {
    assertTrue(s.check("", ""));
  }

  @Test
  void withOneSingleChar() {
    assertTrue(s.check("a", "a"));
  }

  @Test
  void withOneSingleDifferentChar() {
    assertFalse(s.check("a", "b"));
  }

  @Test
  void withThreeChars() {
    assertTrue(s.check("abc", "bac"));
  }

  @Test
  void withRepeatingChars() {
    assertTrue(s.check("aabbc", "bcaba"));
  }

  @Test
  void withDifferentLength() {
    assertFalse(s.check("abc", "ab"));
  }
}
