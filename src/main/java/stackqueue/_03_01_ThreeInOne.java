package stackqueue;

import java.util.NoSuchElementException;

/**
 * Describe how you could use a single array to implement three stacks
 */
class _03_01_ThreeInOne {

    private final int[] arr;
    private StackInfo[] stacks;


    _03_01_ThreeInOne(int initSize) {
        arr = new int[3 * initSize];
        stacks = new StackInfo[3];
        for (int i = 0; i < stacks.length; i++) {
            stacks[i] = new StackInfo(i * initSize, initSize);
        }
    }

    void push(int stackNum, int val) {
        checkStackNum(stackNum);
        StackInfo stackInfo = stacks[stackNum];
        if (stackInfo.isFull()) {
            if (isAllFull()) throw new IllegalStateException("array is full");
            expand(stackNum);
        }
        arr[adjust(stackInfo.peek() + 1)] = val;
        stackInfo.size++;
    }

    private boolean isAllFull() {
        int sum = 0;
        for (StackInfo stack : stacks) {
            sum += stack.size;
        }
        return sum >= arr.length;
    }

    private void expand(int stackNum) {
        shift(nextStack(stackNum));
        stacks[stackNum].capacity++;
    }

    private int adjust(int i) {
        return ((i % arr.length) + arr.length) % arr.length;
    }

    private void shift(int stackNumb) {
        StackInfo stackInfo = stacks[stackNumb];
        if (stackInfo.isFull()) {
            shift(nextStack(stackNumb));
        }
        int cur = adjust(stackInfo.peek() + 1);
        while (cur != stackInfo.start) {
            int previous = adjust(cur - 1);
            arr[cur] = arr[previous];
            cur = previous;
        }
        stackInfo.start = adjust(stackInfo.start + 1);
    }

    private int nextStack(int stackNumb) {
        return (stackNumb + 1) % stacks.length;
    }

    private void checkStackNum(int stackNum) {
        if (stackNum >= stacks.length || stackNum < 0)
            throw new IllegalArgumentException("Stack doesn't exist " + stackNum + " 0 - 2");
    }

    int pop(int stackNum) {
        checkStackNum(stackNum);
        StackInfo stackInfo = stacks[stackNum];
        if (stackInfo.isEmpty()) throw new NoSuchElementException("stack is empty");
        int peekIndex = stackInfo.peek() % arr.length;
        int peek = arr[peekIndex];
        arr[peekIndex] = 0;
        stackInfo.size--;
        return peek;
    }

    private static class StackInfo {
        int start;
        int size;
        int capacity;

        StackInfo(int start, int capacity) {
            this.start = start;
            this.capacity = capacity;
        }

        int peek() {
            return start + size - 1;
        }

        boolean isEmpty() {
            return size == 0;
        }

        boolean isFull() {
            return size == capacity;
        }
    }


}
