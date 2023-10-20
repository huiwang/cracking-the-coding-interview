package arraystring;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class _01_01_IsUniqueTest {

  private _01_01_IsUnique s = new _01_01_IsUnique();

  @Test
  void withEmptyString() {
    assertTrue(s.isUnique(""));
  }

  @Test
  void withUniqueString() {
    assertTrue(s.isUnique("abcde"));
  }

  @Test
  void withDuplication() {
    assertFalse(s.isUnique("abcda"));
  }
}
