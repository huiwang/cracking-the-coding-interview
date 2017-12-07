package arraystring;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 */

class _01_01_IsUnique {

    // time o(n)
    // space o(1)
    boolean isUnique(String str) {
        Set<Integer> set = str.chars().boxed().collect(Collectors.toSet());
        return set.size() == str.length();
    }

}
