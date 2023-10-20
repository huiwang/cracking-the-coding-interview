package stackqueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Stack;
import org.junit.jupiter.api.Test;

class _03_05_SortStackTest {

  private _03_05_SortStack s = new _03_05_SortStack();

  @Test
  void withAlreadySorted() {
    Stack<Integer> stack = new Stack<>();
    stack.push(3);
    stack.push(2);
    stack.push(1);
    Stack<Integer> result = s.sort(stack);
    assertEquals(1, result.pop().intValue());
    assertEquals(2, result.pop().intValue());
    assertEquals(3, result.pop().intValue());
  }

  @Test
  void withUnSorted() {
    Stack<Integer> stack = new Stack<>();
    stack.push(2);
    stack.push(5);
    stack.push(3);
    stack.push(4);
    Stack<Integer> result = s.sort(stack);
    assertEquals(2, result.pop().intValue());
    assertEquals(3, result.pop().intValue());
    assertEquals(4, result.pop().intValue());
    assertEquals(5, result.pop().intValue());
  }
}
