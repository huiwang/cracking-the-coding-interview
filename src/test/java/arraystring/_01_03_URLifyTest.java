package arraystring;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class _01_03_URLifyTest {

  private _01_03_URLify s = new _01_03_URLify();

  @Test
  void withNoSpace() {
    assertArrayEquals("hello".toCharArray(), s.urlify("hello".toCharArray(), 5));
  }

  @Test
  void withInsufficientLength() {
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          s.urlify("hello world ".toCharArray(), 11);
        });
  }

  @Test
  void withOneSpace() {
    assertArrayEquals("hello%20world".toCharArray(), s.urlify("hello world  ".toCharArray(), 11));
  }

  @Test
  void withTwoSpaces() {
    assertArrayEquals(
        "hello%20world%20bob".toCharArray(), s.urlify("hello world bob    ".toCharArray(), 15));
  }
}
