package recursivedp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import org.junit.jupiter.api.Test;

class _08_08_PermutationWithDupTest {

  private _08_08_PermutationWithDup s = new _08_08_PermutationWithDup();

  @Test
  void withEmptyString() {
    assertEquals(Collections.singleton(""), s.computePermutation(""));
  }

  @Test
  void withOneChar() {
    assertEquals(Collections.singleton("a"), s.computePermutation("a"));
  }

  @Test
  void withTwoChars() {
    assertEquals(Collections.singleton("aa"), s.computePermutation("aa"));
  }

  @Test
  void withThreeChars() {
    HashSet<String> result = new HashSet<>(Arrays.asList("aab", "aba", "baa"));
    assertEquals(result, s.computePermutation("aba"));
  }

  @Test
  void withManySameChar() {
    String str = "aaaaaaaaaaaa";
    assertEquals(Collections.singleton(str), s.computePermutation(str));
  }
}
