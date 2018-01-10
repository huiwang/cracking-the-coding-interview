package recursivedp;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Write an algorithm to print all ways of arranging eight queens on an 8x8 chess board
 * so that none of them share the same row, column, or diagonal.
 * In this case, "diagonal" means all diagonals, not just the two that bisect the board.
 */
public class _08_12_EightQueens {

    private static final int SIZE = 8;

    List<List<Point>> arrange() {
        List<List<Point>> result = new ArrayList<>();
        Constraints constraints = new Constraints();
        dfs(0, new Point[SIZE], constraints, result);
        return result;
    }

    private void dfs(int row, Point[] points, Constraints constraints, List<List<Point>> result) {
        if (row == SIZE) {
            result.add(Arrays.asList(points));
            return;
        }

        for (int col = 0; col < SIZE; col++) {
            Point p = new Point(row, col);
            if (constraints.isFeasible(p)) {
                constraints.mark(p);
                points[row] = p;
                dfs(row + 1, points, constraints, result);
                constraints.unmark(p);
            }
        }

    }

    private static class Constraints {
        private boolean[] rows = new boolean[SIZE];
        private boolean[] cols = new boolean[SIZE];
        private boolean[] positive = new boolean[SIZE * 2 - 1];
        private boolean[] negative = new boolean[SIZE * 2 - 1];

        private void mark(Point p) {
            rows[p.x] = true;
            cols[p.y] = true;
            positive[toPositiveDiagonal(p)] = true;
            negative[toNegativeDiagonal(p)] = true;
        }

        private void unmark(Point p) {
            rows[p.x] = false;
            cols[p.y] = false;
            positive[toPositiveDiagonal(p)] = false;
            negative[toNegativeDiagonal(p)] = false;
        }

        private boolean isFeasible(Point p) {
            return !rows[p.x]
                    && !cols[p.y]
                    && !positive[toPositiveDiagonal(p)]
                    && !negative[toNegativeDiagonal(p)];
        }

        private int toPositiveDiagonal(Point p) {
            return p.x + p.y;
        }


        private int toNegativeDiagonal(Point p) {
            return SIZE - 1 - (p.x - p.y);
        }

    }

}
