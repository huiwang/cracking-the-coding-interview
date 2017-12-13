package moderate;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _16_01_NumberSwapperTest {

    private _16_01_NumberSwapper s = new _16_01_NumberSwapper();

    @Test
    public void test() {
        int[] ab = {1, 2};
        s.swap(ab);
        assertEquals(ab[0], 2);
        assertEquals(ab[1], 1);
    }

}