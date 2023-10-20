package bitmanipulation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class _05_03_FilpBitToWinTest {

  private _05_03_FlipBitToWin s = new _05_03_FlipBitToWin();

  @Test
  void withZero() {
    assertEquals(1, s.flip(0));
  }

  @Test
  void withAllOnes() {
    assertEquals(32, s.flip(-1));
  }

  @Test
  void testWithOne() {
    assertEquals(2, s.flip(1));
  }

  @Test
  void testWithOneSegment() {
    assertEquals(4, s.flip(0x0000_000b));
  }

  @Test
  void testWithTwoSegments() {
    assertEquals(5, s.flip(0x00b8_000b));
  }

  @Test
  void WithContinuesSegment() {
    assertEquals(8, s.flip(0x0000_F700));
  }
}
