package moderate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class _16_01_NumberSwapperTest {

  private _16_01_NumberSwapper s = new _16_01_NumberSwapper();

  @Test
  void test() {
    int[] ab = {1, 2};
    s.swap(ab);
    assertEquals(ab[0], 2);
    assertEquals(ab[1], 1);
  }
}
