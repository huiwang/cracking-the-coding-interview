package arraystring;

import java.util.Arrays;

/**
 * Given two strings,write a method to decide if one is a permutation of the other.
 */
class _01_02_CheckPermutation {
    boolean check(String a, String b) {
        return Arrays.equals(sorted(a), sorted(b));
    }

    private static char[] sorted(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return chars;
    }
}
