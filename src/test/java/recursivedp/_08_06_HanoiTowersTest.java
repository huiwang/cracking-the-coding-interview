package recursivedp;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class _08_06_HanoiTowersTest {

    private _08_06_HanoiTowers s = new _08_06_HanoiTowers();

    @Test
    public void withOneDisk() {
        assertEquals(Arrays.asList(1, 3), s.leftToRight(1));
    }

    @Test
    public void withTwoDisk() {
        assertEquals(Arrays.asList(
                1, 2,
                1, 3,
                2, 3
        ), s.leftToRight(2));
    }

    @Test
    public void withThreeDisks() {
        assertEquals(Arrays.asList(
                1, 3,
                1, 2,
                3, 2,
                1, 3,
                2, 1,
                2, 3,
                1, 3
        ), s.leftToRight(3));
    }
}