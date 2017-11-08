package com.truelaure.ctci.linkedlist;

import org.junit.Test;

import static com.truelaure.ctci.linkedlist.LinkedListNode.empty;
import static com.truelaure.ctci.linkedlist.LinkedListNode.of;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _02_06_PalindromeTest {

    private _02_06_Palindrome s = new _02_06_Palindrome();

    @Test
    public void withEmptyList() {
        assertTrue(s.isPalindrome(empty()));
    }

    @Test
    public void withOneElement() {
        assertTrue(s.isPalindrome(of(1)));
    }

    @Test
    public void withThreeElements() {
        assertTrue(s.isPalindrome(of(1, 2, 1)));
    }

    @Test
    public void withFourElements() {
        assertTrue(s.isPalindrome(of(1, 2, 2, 1)));
    }

    @Test
    public void withFourElements_NotPalindrome() {
        assertFalse(s.isPalindrome(of(1, 2, 2, 3)));
    }
}