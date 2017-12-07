package linkedlist;

import java.util.Stack;

/**
 * Palindrome: Implement a function to check if a linked list is a palindrome.
 */
class _02_06_Palindrome {

    boolean isPalindrome(LinkedListNode head) {
        if (head == null) return true;
        Stack<Integer> stack = new Stack<>();
        LinkedListNode cur = head;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }

        int half = stack.size() / 2;
        while (half >= 0) {
            int val = stack.pop();
            if (val != head.val) return false;
            head = head.next;
            half--;
        }
        return true;
    }


}
