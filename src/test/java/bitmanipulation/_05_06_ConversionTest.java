package bitmanipulation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class _05_06_ConversionTest {

  private _05_06_Conversion s = new _05_06_Conversion();

  @Test
  void withZeroAndOne() {
    assertEquals(1, s.convert(0, 1));
  }

  @Test
  void withOneAndOne() {
    assertEquals(0, s.convert(1, 1));
  }

  @Test
  void withOneAndTwo() {
    assertEquals(2, s.convert(1, 2));
  }

  @Test
  void withZeroAndThree() {
    assertEquals(2, s.convert(0, 3));
  }
}
