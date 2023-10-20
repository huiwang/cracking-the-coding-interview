package arraystring;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class _01_04_PalindromePermutationTest {

  private _01_04_PalindromePermutation s = new _01_04_PalindromePermutation();

  @Test
  void withEmpty() {
    assertTrue(s.check(""));
  }

  @Test
  void withOneChar() {
    assertTrue(s.check("a"));
  }

  @Test
  void withTwoWords_OddLetters() {
    assertTrue(s.check("acto tac"));
  }

  @Test
  void withTwoWords_OddLetters_ThreeOccurences() {
    assertTrue(s.check("act atac"));
  }

  @Test
  void withTwoWords_EvenLetters() {
    assertTrue(s.check("act cat"));
  }
}
