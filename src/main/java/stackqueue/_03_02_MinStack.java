package stackqueue;

import java.util.Stack;

/**
 * How would you design a stack which, in addition to push and pop, has a function min which returns the minimum element? Push, pop and min should all operate in 0(1) time.
 */
class _03_02_MinStack {

    private Stack<Integer> vals = new Stack<>();
    private Stack<Integer> mins = new Stack<>();

    void push(int val) {
        vals.push(val);
        if (mins.isEmpty() || val < mins.peek()) {
            mins.push(val);
        }
    }

    int pop() {
        int val = vals.pop();
        if (val == mins.peek()) {
            mins.pop();
        }
        return val;
    }

    int min() {
        return mins.peek();
    }
}
