package arraystring;

/**
 * Write a method to replace all spaces in a string with '%20' You may assume that the string has
 * sufficient space at the end to hold the additional characters, and that you are given the "true"
 * length of the string. (Note: If implementing in Java,please use a character array so that you can
 * perform this operation in place.)
 *
 * <p>EXAMPLE Input: "Mr John Smith ", 13 Output: "Mr%20John%20Smith"
 */
class _01_03_URLify {
  //Time Complexity O(n)  | Space Complexity O(1)
  char[] urlify(char[] chars, int trueLength) {
    if(chars.length == trueLength) {
      return chars;
    }

    int i = trueLength -1, j = chars.length -1;

    while(i > 0) {
      if(Character.isSpaceChar(chars[i])) {
        chars[j-2] = '%';
        chars[j-1] = '2';
        chars[j] = '0';
        i--;
        j -= 3;
      } else {
        chars[j] = chars[i];
        j--;
        i--;
      }
    }

    return chars;
  }
}
