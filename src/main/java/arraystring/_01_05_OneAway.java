package arraystring;

import java.util.HashMap;

/**
 * There are three types of edits that can be performed on strings: insert a character, remove a
 * character, or replace a character. Given two strings, write a function to check if they are one
 * edit (or zero edits) away.
 *
 * <p>EXAMPLE pale, ple -> true pales, pale -> true pale, bale -> true pale, bake -> false
 */
class _01_05_OneAway {

  //Time complexity O(n) | Space complexity O(n)
  boolean isOneAway(String a, String b) {
    if(a.isEmpty() && b.isEmpty()) {
      return true;
    }

    if(Math.abs(a.length() - b.length()) > 1) {
      return false;
    }

    int away = 0;

    var lookupA = new HashMap<Character, Integer>();
    for(int i = 0; i < a.length(); i++) {
      lookupA.merge(a.charAt(i), 1, Integer::sum);
    }

    var lookupB = new HashMap<Character, Integer>();
    for(int i = 0; i < b.length(); i++) {
      lookupB.merge(b.charAt(i), 1, Integer::sum);
    }

    for(var entrySet : lookupB.entrySet()) {
      if(!lookupA.containsKey(entrySet.getKey())) {
        away += entrySet.getValue();
      } else {
        away += Math.abs(entrySet.getValue() - lookupA.get(entrySet.getKey()));
      }

      if(away > 1) {
        return false;
      }
    }
    return true;
  }
}
