package arraystring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class _01_06_StringCompressionTest {

  private _01_06_StringCompression s = new _01_06_StringCompression();

  @Test
  void withOneSingleChar() {
    assertEquals("a", s.compress("a"));
  }

  @Test
  void withTwoChars() {
    assertEquals("aa", s.compress("aa"));
  }

  @Test
  void withThreeChars() {
    assertEquals("3a", s.compress("aaa"));
  }

  @Test
  void withDifferentChars() {
    assertEquals("aaab", s.compress("aaab"));
  }

  @Test
  void withDifferentChars_RepeatingSeveralTimes() {
    assertEquals("3a2b", s.compress("aaabb"));
  }

  @Test
  void withDifferentChars_RepeatingInMoreSeqs() {
    assertEquals("3a2b2a", s.compress("aaabbaa"));
  }
}
