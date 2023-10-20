package arraystring;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class _01_05_OneAwayTest {

  private _01_05_OneAway s = new _01_05_OneAway();

  @Test
  void withEmpty() {
    assertTrue(s.isOneAway("", ""));
  }

  @Test
  void withOneEmpty() {
    assertTrue(s.isOneAway("", "b"));
  }

  @Test
  void withTwoSingleWords() {
    assertTrue(s.isOneAway("a", "b"));
  }

  @Test
  void withOneInsertion() {
    assertTrue(s.isOneAway("pae", "pale"));
  }

  @Test
  void withOneDeletion() {
    assertTrue(s.isOneAway("pales", "paes"));
  }

  @Test
  void withOneReplace() {
    assertTrue(s.isOneAway("pawe", "pave"));
  }

  @Test
  void withMoreEdits() {
    assertFalse(s.isOneAway("paxye", "pamne"));
  }
}
