package recursivedp;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
 * The robot can only move in two directions, right and down, but certain cells are "off limits"
 * such that the robot cannot step on them. Design an algorithm to find a path for the robot
 * from the top left to the bottom right.
 */
class _08_02_RobotInAGrid {
    List<Point> findPath(boolean[][] grid) {
        if (grid == null || grid.length == 0) return Collections.emptyList();
        int rows = grid.length - 1;
        int cols = grid[0].length - 1;
        List<Point> path = new ArrayList<>();
        Set<Point> failed = new HashSet<>();
        getPath(grid, rows, cols, path, failed);
        return path;
    }

    private boolean getPath(boolean[][] grid, int r, int c, List<Point> path, Set<Point> failed) {
        if (r < 0 || c < 0 || !grid[r][c]) {
            return false;
        }
        Point p = new Point(r, c);

        if (failed.contains(p)) return false;

        boolean isOrigin = (r == 0) && (c == 0);
        if (isOrigin || getPath(grid, r - 1, c, path, failed) || getPath(grid, r, c - 1, path, failed)) {
            path.add(p);
            return true;
        } else {
            failed.add(p);
            return false;
        }
    }

}
