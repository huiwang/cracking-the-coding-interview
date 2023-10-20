package bitmanipulation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class _05_01_InsertionTest {

  private _05_01_Insertion s = new _05_01_Insertion();

  @Test
  void withZeros() {
    assertEquals(0, s.insert(0, 0, 2, 5));
  }

  @Test
  void withLowInsertion() {
    int n = 0x00_00_69_00;
    int m = 0x00_00_00_b3;
    int x = 0x00_00_69_b3;
    int i = 0;
    int j = 7;
    assertEquals(x, s.insert(n, m, i, j));
  }

  @Test
  void withHighInsertion() {
    int n = 0x00_00_69_00;
    int m = 0x00_00_00_b3;
    int x = 0x00_b3_69_00;
    int i = 16;
    int j = 23;
    assertEquals(x, s.insert(n, m, i, j));
  }

  @Test
  void withMiddleInsertion() {
    int n = 0x00_00_69_00;
    int m = 0x00_00_00_b3;
    int x = 0x00_00_6b_30;
    int i = 4;
    int j = 11;
    assertEquals(x, s.insert(n, m, i, j));
  }
}
