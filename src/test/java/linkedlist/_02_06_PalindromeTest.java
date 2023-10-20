package linkedlist;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class _02_06_PalindromeTest {

  private _02_06_Palindrome s = new _02_06_Palindrome();

  @Test
  void withEmptyList() {
    assertTrue(s.isPalindrome(LinkedListNode.empty()));
  }

  @Test
  void withOneElement() {
    assertTrue(s.isPalindrome(LinkedListNode.of(1)));
  }

  @Test
  void withThreeElements() {
    assertTrue(s.isPalindrome(LinkedListNode.of(1, 2, 1)));
  }

  @Test
  void withFourElements() {
    assertTrue(s.isPalindrome(LinkedListNode.of(1, 2, 2, 1)));
  }

  @Test
  void withFourElements_NotPalindrome() {
    assertFalse(s.isPalindrome(LinkedListNode.of(1, 2, 2, 3)));
  }
}
