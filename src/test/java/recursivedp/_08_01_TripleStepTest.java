package recursivedp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _08_01_TripleStepTest {

    private _08_01_TripleStep s = new _08_01_TripleStep();

    @Test
    public void withZeroStep() {
        assertEquals(1, s.countWays(0));
    }

    @Test
    public void withOneStep() {
        assertEquals(1, s.countWays(1));
    }

    @Test
    public void withTwoSteps() {
        assertEquals(2, s.countWays(2));
    }

    @Test
    public void withTreeSteps() {
        assertEquals(4, s.countWays(3));
    }

    @Test
    public void withFourSteps() {
        //3+1
        //  3
        //  2+1
        //  1+2
        //  1+1+1
        //2+2
        //  2
        //  1+1
        //1+3
        //  1
        assertEquals(7, s.countWays(4));
    }

    @Test
    public void withFiveSteps() {
        assertEquals(13, s.countWays(5));
    }

    @Test(expected = Exception.class)
    public void withBigStep() {
        s.countWays(37);
    }
}