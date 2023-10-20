package sortingsearching;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Test;

class _10_02_GroupAnagramsTest {

  private _10_02_GroupAnagrams s = new _10_02_GroupAnagrams();

  @Test
  void withEmpty() {
    assertEquals(Collections.emptyList(), s.groupAnagrams(Collections.emptyList()));
  }

  @Test
  void withOneWord() {
    assertEquals(
        Collections.singletonList("hello"), s.groupAnagrams(Collections.singletonList("hello")));
  }

  @Test
  void withThreeWords() {
    assertEquals(
        Arrays.asList("hello", "olelh", "world"),
        s.groupAnagrams(Arrays.asList("hello", "world", "olelh")));
  }

  @Test
  void withFourWords() {
    assertEquals(
        Arrays.asList("hello", "olelh", "lrowd", "world"),
        s.groupAnagrams(Arrays.asList("hello", "lrowd", "olelh", "world")));
  }
}
