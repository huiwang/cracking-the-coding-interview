package recursivedp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class _08_05_RecursiveMultiplyTest {

  private _08_05_RecursiveMultiply s = new _08_05_RecursiveMultiply();

  @Test
  void testOneOne() {
    assertEquals(1, s.multiple(1, 1));
  }

  @Test
  void testOneTwo() {
    assertEquals(2, s.multiple(1, 2));
  }

  @Test
  void testFiveNine() {
    assertEquals(45, s.multiple(5, 9));
  }

  @Test
  void testThirtyForty() {
    assertEquals(1200, s.multiple(40, 30));
  }
}
