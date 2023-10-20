package recursivedp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class _08_03_MagicIndexTest {

  private _08_03_MagicIndex s = new _08_03_MagicIndex();

  @Test
  void withOneElement() {
    assertEquals(-1, s.findMagicIndex(new int[] {2}));
    assertEquals(0, s.findMagicIndex(new int[] {0}));
  }

  @Test
  void withMagicIndex() {
    assertEquals(2, s.findMagicIndex(new int[] {-1, 0, 2, 5, 7, 9}));
  }

  @Test
  void withoutMagicIndex() {
    assertEquals(-1, s.findMagicIndex(new int[] {1, 2, 3, 4, 5, 6}));
  }
}
