package com.truelaure.ctci.linkedlists;

import org.junit.Test;

import static com.truelaure.ctci.linkedlists.LinkedListNode.*;
import static org.junit.Assert.*;

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