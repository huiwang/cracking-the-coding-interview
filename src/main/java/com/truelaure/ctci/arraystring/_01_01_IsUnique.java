package com.truelaure.ctci.arraystring;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Is Unique
 *
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 *
 * Ideas
 *
 * Set: convert the string to a set and tests if the set size is the same as the input string
 * if the set size is smaller, it means duplication is found.
 *  time o(n)
 *  space o(1) //the set can has as many elements as the size the character set
 *
 */

class _01_01_IsUnique {

    boolean isUnique(String str) {
        return isUniqueWithSet(str);
    }

    private boolean isUniqueWithSet(String str) {
        Set<Integer> set = str.chars().boxed().collect(Collectors.toSet());
        return set.size() == str.length();
    }

}
