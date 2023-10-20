package stackqueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class _03_01_ThreeInOneTest {

  @Test
  void withStackSize1() {
    _03_01_ThreeInOne s = new _03_01_ThreeInOne(1);
    s.push(0, 0);
    s.push(1, 1);
    s.push(2, 2);
    assertEquals(0, s.pop(0));
    assertEquals(1, s.pop(1));
    assertEquals(2, s.pop(2));
  }

  @Test
  void withStackSize2() {
    _03_01_ThreeInOne s = new _03_01_ThreeInOne(2);
    s.push(0, 6);
    s.push(1, 1);
    s.push(1, 2);
    s.push(2, 3);
    s.push(2, 4);
    s.push(2, 5);
    assertEquals(6, s.pop(0));
    assertEquals(2, s.pop(1));
    assertEquals(1, s.pop(1));
    assertEquals(5, s.pop(2));
    assertEquals(4, s.pop(2));
    assertEquals(3, s.pop(2));
  }

  @Test
  void withArrayLength3_Exceeded() {
    _03_01_ThreeInOne s = new _03_01_ThreeInOne(1);
    assertThrows(
        RuntimeException.class,
        () -> {
          s.push(0, 1);
          s.push(0, 1);
          s.push(0, 1);
          s.push(0, 1);
        });
  }

  @Test
  void withArrayLength3_StackNotExists() {
    _03_01_ThreeInOne s = new _03_01_ThreeInOne(3);
    assertThrows(
        RuntimeException.class,
        () -> {
          s.push(3, 1);
        });
  }
}
