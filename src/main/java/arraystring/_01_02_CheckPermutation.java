package arraystring;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings,write a method to decide if one is a permutation of the other.
 */
class _01_02_CheckPermutation {
    boolean check(String a, String b) {
        return computeFrequency(a).equals(computeFrequency(b));
    }

    private Map<Character, Integer> computeFrequency(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            freq.merge(s.charAt(i), 1, (ov, v) -> ov + v);
        }
        return freq;
    }
}
