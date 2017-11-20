package com.truelaurel.ctci.stackqueue;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

class _03_03_StackOfPlates {

    private final int threshold;
    private final List<Stack<Integer>> stacks;

    _03_03_StackOfPlates(int threshold) {
        this.threshold = threshold;
        stacks = new ArrayList<>();
    }

    void push(int val) {
        if (stacks.isEmpty() || isLastStackFull()) {
            stacks.add(new Stack<>());
        }
        lastStack().push(val);
    }

    private boolean isLastStackFull() {
        return lastStack().size() == threshold;
    }

    private Stack<Integer> lastStack() {
        return stacks.get(stacks.size() - 1);
    }

    int pop() {
        if (stacks.isEmpty()) throw new EmptyStackException();
        Stack<Integer> stack = lastStack();
        int val = stack.pop();
        if (stack.isEmpty()) stacks.remove(stacks.size() - 1);
        return val;
    }
}
