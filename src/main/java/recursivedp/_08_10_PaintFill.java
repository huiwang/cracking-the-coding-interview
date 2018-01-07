package recursivedp;

/**
 * Paint Fill: Implement the "paint fill" function that one might see on many image editing programs.
 * That is, given a screen (represented by a two-dimensional array of colors), a point, and a new color,
 * fill in the surrounding area until the color changes from the original color.
 * <p>
 * EXAMPLE
 * <p>
 * [0, 1, 1]
 * [1, 1, 0]
 * [1, 0, 0]
 * <p>
 * Given a new point at (2, 2) and new color 2, the expected screen after paint filling should be
 * [0, 1, 1]
 * [1, 1, 2]
 * [1, 2, 2]
 */
public class _08_10_PaintFill {

    private int[][] screen;
    private int rows;
    private int cols;
    private int oldColor;
    private int newColor;

    int[][] paintFill(int[][] screen, int row, int col, int newColor) {
        this.screen = screen;
        rows = screen.length;
        if (rows == 0) throw new IllegalArgumentException("scree must contain at least one row");
        cols = screen[0].length;
        oldColor = screen[row][col];
        this.newColor = newColor;
        doPaint(row, col);
        return screen;
    }

    private void doPaint(int row, int col) {
        if (screen[row][col] != oldColor) return;

        screen[row][col] = newColor;
        if (row > 0) {
            doPaint(row - 1, col);
        }

        if (row < rows - 1) {
            doPaint(row + 1, col);
        }

        if (col > 0) {
            doPaint(row, col - 1);
        }

        if (col < cols - 1) {
            doPaint(row, col + 1);
        }
    }
}
