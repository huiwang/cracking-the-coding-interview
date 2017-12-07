package stackqueue;

import java.util.Stack;

class _03_04_QueueViaStacks {

    private final Stack<Integer> inbox = new Stack<>();
    private final Stack<Integer> outbox = new Stack<>();

    void enqueue(int val) {
        inbox.add(val);
    }

    int size() {
        return inbox.size() + outbox.size();
    }

    int peek() {
        fillOutbox();
        return outbox.peek();
    }

    int dequeue() {
        fillOutbox();
        return outbox.pop();
    }

    private void fillOutbox() {
        if (outbox.isEmpty()) {
            while (!inbox.isEmpty()) {
                outbox.push(inbox.pop());
            }
        }
    }
}
