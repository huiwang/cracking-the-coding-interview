package recursivedp;

import org.junit.Assert;
import org.junit.Test;
import recursivedp._08_13_StackOfBoxes.Box;

import java.util.Arrays;
import java.util.Collections;

public class _08_13_StackOfBoxesTest {

    private final _08_13_StackOfBoxes s = new _08_13_StackOfBoxes();


    @Test
    public void with0Box() {
        Assert.assertEquals(0, s.createStack(Collections.emptyList()));
    }

    @Test
    public void with1Box() {
        Assert.assertEquals(1, s.createStack(Collections.singletonList(new Box(1, 1, 1))));
    }

    @Test
    public void with3Boxes() {
        Assert.assertEquals(5, s.createStack(Arrays.asList(
                new Box(2, 2, 2),
                new Box(3, 3, 3),
                new Box(3, 3, 4))));
    }

    @Test
    public void with4Boxes() {
        Assert.assertEquals(10, s.createStack(Arrays.asList(
                new Box(4, 4, 4),
                new Box(3, 3, 3),
                new Box(2, 2, 2),
                new Box(1, 1, 1))));
    }
}