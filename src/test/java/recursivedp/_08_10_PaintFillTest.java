package recursivedp;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class _08_10_PaintFillTest {

    private final _08_10_PaintFill s = new _08_10_PaintFill();

    @Test
    public void withAllOriginalColorConnected() {
        int[][] screen = new int[][]{
                {1, 0, 1},
                {0, 0, 1},
                {1, 0, 0}
        };

        int x = 1, y = 1;

        int newColor = 2;

        int[][] expected = new int[][]{
                {1, 2, 1},
                {2, 2, 1},
                {1, 2, 2}
        };
        Assert.assertTrue(Arrays.deepEquals(expected, s.paintFill(screen, x, y, newColor)));
    }

    @Test
    public void withAllOriginalColorSeparated() {
        int[][] screen = new int[][]{
                {1, 0, 1},
                {0, 1, 1},
                {1, 0, 0}
        };

        int x = 2, y = 1;

        int newColor = 2;

        int[][] expected = new int[][]{
                {1, 0, 1},
                {0, 1, 1},
                {1, 2, 2}
        };
        Assert.assertTrue(Arrays.deepEquals(expected, s.paintFill(screen, x, y, newColor)));
    }
}