package stackqueue;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _03_03_StackOfPlatesTest {

    @Test
    public void withBigThreshold() {
        _03_03_StackOfPlates stack = new _03_03_StackOfPlates(100);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        assertEquals(6, stack.pop());
        assertEquals(5, stack.pop());
        assertEquals(4, stack.pop());
        assertEquals(3, stack.pop());
    }

    @Test
    public void withSmallThreshold() {
        _03_03_StackOfPlates stack = new _03_03_StackOfPlates(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        assertEquals(6, stack.pop());
        assertEquals(5, stack.pop());
        assertEquals(4, stack.pop());
        assertEquals(3, stack.pop());
    }

    @Test
    public void withSmallThreshold_PopAtIndex() {
        _03_03_StackOfPlates stack = new _03_03_StackOfPlates(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);

        assertEquals(6, stack.popAt(1));
        assertEquals(7, stack.popAt(1));
        assertEquals(8, stack.pop());
        assertEquals(4, stack.popAt(0));
        assertEquals(5, stack.pop());
        assertEquals(3, stack.pop());

    }
}