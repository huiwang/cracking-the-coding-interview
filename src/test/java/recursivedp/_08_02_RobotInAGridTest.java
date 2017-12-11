package recursivedp;

import org.junit.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class _08_02_RobotInAGridTest {


    private _08_02_RobotInAGrid s = new _08_02_RobotInAGrid();

    @Test
    public void withAllFeasibleCells() {
        boolean[][] grid = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };

        assertEquals(Arrays.asList(
                new Point(0, 0), new Point(0, 1),
                new Point(0, 2), new Point(1, 2),
                new Point(2, 2)), s.findPath(grid));
    }

    @Test
    public void withSomeBrokenCells() {
        boolean[][] grid = new boolean[][]{
                {true, true, true},
                {true, true, false},
                {false, true, true}
        };

        assertEquals(Arrays.asList(
                new Point(0, 0), new Point(0, 1),
                new Point(1, 1), new Point(2, 1),
                new Point(2, 2)), s.findPath(grid));
    }

    @Test
    public void withNoPath() {
        boolean[][] grid = new boolean[][]{
                {true, true, true},
                {true, true, false},
                {false, false, true}
        };

        assertEquals(Collections.emptyList(), s.findPath(grid));
    }


}