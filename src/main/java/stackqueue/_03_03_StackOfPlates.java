package stackqueue;

import java.util.*;

class _03_03_StackOfPlates {

    private final int threshold;
    private final List<Deque<Integer>> stacks;

    _03_03_StackOfPlates(int threshold) {
        this.threshold = threshold;
        stacks = new ArrayList<>();
    }

    void push(int val) {
        if (stacks.isEmpty() || isLastStackFull()) {
            stacks.add(new LinkedList<>());
        }
        lastStack().push(val);
    }

    private boolean isLastStackFull() {
        return lastStack().size() == threshold;
    }

    private Deque<Integer> lastStack() {
        return stacks.get(stacks.size() - 1);
    }

    int pop() {
        if (stacks.isEmpty()) throw new EmptyStackException();
        Deque<Integer> stack = lastStack();
        int val = stack.pop();
        if (stack.isEmpty()) removeLast();
        return val;
    }

    int popAt(int stackNum) {
        int val = stacks.get(stackNum).pop();
        for (int i = stackNum; i < stacks.size(); i++) {
            if (i + 1 < stacks.size()) {
                Deque<Integer> nextStack = stacks.get(i + 1);
                stacks.get(i).push(nextStack.removeLast());
            }
        }
        if (lastStack().isEmpty()) {
            removeLast();
        }
        return val;
    }

    private void removeLast() {
        stacks.remove(stacks.size() - 1);
    }
}
