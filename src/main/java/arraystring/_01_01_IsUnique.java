package arraystring;

import java.util.HashSet;
import java.util.Set;

/** Implement an algorithm to determine if a string has all unique characters. */
class _01_01_IsUnique {

  //Time complexity O(n) | Space complexity O(n)
  boolean isUnique(String str) {
    Set<Character> charSet = new HashSet<>();

    for(char c : str.toCharArray()) {
      charSet.add(c);
    }

    return charSet.size() == str.length();
  }
}
