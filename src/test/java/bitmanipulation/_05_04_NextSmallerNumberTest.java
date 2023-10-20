package bitmanipulation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class _05_04_NextSmallerNumberTest {

  private _05_04_NextSmallerNumber s = new _05_04_NextSmallerNumber();

  @Test
  void withOne() {
    assertEquals(-1, s.nextSmaller(1));
  }

  @Test
  void withIntegerTooSmall() {
    assertEquals(-1, s.nextSmaller(3));
  }

  @Test
  void withTen() {
    assertEquals(9, s.nextSmaller(10));
  }

  @Test
  void withManyOnesZeros() {
    assertEquals(0x0008_fee0, s.nextSmaller(0x0008_ff03));
  }
}
