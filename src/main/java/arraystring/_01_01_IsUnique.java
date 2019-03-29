package arraystring;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 */

class _01_01_IsUnique {

    boolean isUnique(String str) {
//        long distinctCount = str.chars().boxed().distinct().count();
        Set<Integer> set = str.chars().boxed().collect(Collectors.toSet());
        return set.size() == str.length();
    }

}
