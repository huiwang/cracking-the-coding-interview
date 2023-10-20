package arraystring;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class _01_09_StringRotationTest {

  private _01_09_StringRotation s = new _01_09_StringRotation();

  @Test
  void withEmpty() {
    assertTrue(s.rotated("", ""));
  }

  @Test
  void withSameWord() {
    assertTrue(s.rotated("hello", "hello"));
  }

  @Test
  void withRotated() {
    assertTrue(s.rotated("hello", "llohe"));
  }

  @Test
  void withSubstring_ButDifferentSize() {
    assertFalse(s.rotated("hello", "llo"));
  }

  @Test
  void withDifferentWords() {
    assertFalse(s.rotated("hello", "world"));
  }

  @Test
  void withNotRotated() {
    assertFalse(s.rotated("hello", "oehll"));
  }
}
