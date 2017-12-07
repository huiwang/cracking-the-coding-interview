package stackqueue;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _03_01_ThreeInOneTest {

    @Test
    public void withStackSize1() {
        _03_01_ThreeInOne s = new _03_01_ThreeInOne(1);
        s.push(0, 0);
        s.push(1, 1);
        s.push(2, 2);
        assertEquals(0, s.pop(0));
        assertEquals(1, s.pop(1));
        assertEquals(2, s.pop(2));
    }


    @Test
    public void withStackSize2() {
        _03_01_ThreeInOne s = new _03_01_ThreeInOne(2);
        s.push(0, 6);
        s.push(1, 1);
        s.push(1, 2);
        s.push(2, 3);
        s.push(2, 4);
        s.push(2, 5);
        assertEquals(6, s.pop(0));
        assertEquals(2, s.pop(1));
        assertEquals(1, s.pop(1));
        assertEquals(5, s.pop(2));
        assertEquals(4, s.pop(2));
        assertEquals(3, s.pop(2));
    }

    @Test(expected = RuntimeException.class)
    public void withArrayLength3_Exceeded() {
        _03_01_ThreeInOne s = new _03_01_ThreeInOne(1);
        s.push(0, 1);
        s.push(0, 1);
        s.push(0, 1);
        s.push(0, 1);
    }

    @Test(expected = RuntimeException.class)
    public void withArrayLength3_StackNotExists() {
        _03_01_ThreeInOne s = new _03_01_ThreeInOne(3);
        s.push(3, 1);
    }
}
