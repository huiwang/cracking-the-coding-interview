package arraystring;

import java.util.HashMap;
/**
 * Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is
 * a word or phrase that is the same forwards and backwards. A permutation is a rearrangement of
 * letters. The palindrome does not need to be limited to just dictionary words.
 *
 * <p>EXAMPLE Input: Tact Coa Output: True (permutations: "taco cat", "atco cta", etc.)
 */
class _01_04_PalindromePermutation {

  //Time complexity O(n) | Space complexity O(n)
  boolean check(String s) {
    if(s.length() == 1) {
      return true;
    }

    var map = new HashMap<Character, Integer>();

    for(int i = 0; i < s.length(); i++) {
      if(!Character.isSpaceChar(s.charAt(i))) {
        map.merge(s.charAt(i), 1, Integer::sum);
      }
    }

    var nonDuplicateNumberCount = 0;
    for(var entrySet : map.entrySet()) {
      if(entrySet.getValue() % 2 != 0) {
        nonDuplicateNumberCount++;
        if(nonDuplicateNumberCount > 1) {
          return false;
        }
      }
    }

    return true;
  }
}
