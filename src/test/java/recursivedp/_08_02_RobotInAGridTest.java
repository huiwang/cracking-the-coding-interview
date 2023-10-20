package recursivedp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Test;

class _08_02_RobotInAGridTest {

  private _08_02_RobotInAGrid s = new _08_02_RobotInAGrid();

  @Test
  void withAllFeasibleCells() {
    boolean[][] grid =
        new boolean[][] {
          {true, true, true},
          {true, true, true},
          {true, true, true}
        };

    assertEquals(
        Arrays.asList(
            new Point(0, 0), new Point(0, 1), new Point(0, 2), new Point(1, 2), new Point(2, 2)),
        s.findPath(grid));
  }

  @Test
  void withSomeBrokenCells() {
    boolean[][] grid =
        new boolean[][] {
          {true, true, true},
          {true, true, false},
          {false, true, true}
        };

    assertEquals(
        Arrays.asList(
            new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 2)),
        s.findPath(grid));
  }

  @Test
  void withNoPath() {
    boolean[][] grid =
        new boolean[][] {
          {true, true, true},
          {true, true, false},
          {false, false, true}
        };

    assertEquals(Collections.emptyList(), s.findPath(grid));
  }
}
