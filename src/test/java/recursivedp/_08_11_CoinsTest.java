package recursivedp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class _08_11_CoinsTest {

  private final _08_11_Coins s = new _08_11_Coins();

  @Test
  void withZeroCent() {
    assertEquals(1, s.makeChangeWithQuarterDimeNickelPenny(0));
  }

  @Test
  void withOneCent() {
    assertEquals(1, s.makeChangeWithQuarterDimeNickelPenny(2));
  }

  @Test
  void withTwoCents() {
    assertEquals(1, s.makeChangeWithQuarterDimeNickelPenny(3));
  }

  @Test
  void with25Cents() {
    // 25
    // 10 10 5
    // 10 10 1 1 1 1 1
    // 10 5 5 5
    // 10 5 5 1 1 1 1 1
    // 10 5 1 1 1 1 1 1 1 1 1 1
    // 10 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
    // 5 5 5 5 5
    // 5 5 5 5 1 1 1 1 1
    // 5 5 5 1 1 1 1 1 1 1 1 1 1
    // 5 5 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
    // 5 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
    // 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
    assertEquals(13, s.makeChangeWithQuarterDimeNickelPenny(25));
  }

  @Test
  void with100Cents() {
    assertEquals(242, s.makeChangeWithQuarterDimeNickelPenny(100));
  }
}
