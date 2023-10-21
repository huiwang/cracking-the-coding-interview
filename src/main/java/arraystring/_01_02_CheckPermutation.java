package arraystring;

/** Given two strings,write a method to decide if one is a permutation of the other. */
class _01_02_CheckPermutation {

  //Time Complexity O(n) | Space Complexity O(1)
  boolean check(String a, String b) {

    var sumCharsA = 0;
    var sumCharsB = 0;

    for(int i = 0; i < a.length(); i++) {
      sumCharsA += a.charAt(i);
    }

    for(int i = 0; i < b.length(); i++) {
      sumCharsB += b.charAt(i);
    }

    return sumCharsA == sumCharsB;
  }
}
