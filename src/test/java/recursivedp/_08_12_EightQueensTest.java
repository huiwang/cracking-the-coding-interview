package recursivedp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class _08_12_EightQueensTest {

  private final _08_12_EightQueens s = new _08_12_EightQueens();

  @Test
  void withEightQueens() {
    List<List<Point>> result = s.arrange();
    System.out.println("Solution size " + result.size());
    result.stream()
        .map(points -> points.stream().map(this::replace).collect(Collectors.joining()))
        .forEach(System.out::println);
    assertEquals(92, result.size());
  }

  private String replace(Point p) {
    char[] chars = " 0 0 0 0 0 0 0 0\n".toCharArray();
    chars[p.y * 2 + 1] = 'x';
    return String.valueOf(chars);
  }
}
