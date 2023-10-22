package arraystring;

/**
 * Implement a method to perform basic string compression using the counts of repeated characters.
 * For example, the string aabcccccaaa would become a2blc5a3. If the "compressed" string would not
 * become smaller than the original string, your method should return the original string. You can
 * assume the string has only uppercase and lowercase letters (a - z).
 */
class _01_06_StringCompression {
  //Time complexity O(n) | Space complexity O (n)
  String compress(String s) {
    if(s.length() == 1 || s.isEmpty()) {
      return s;
    }

    int count = 1;
    char c = ' ';
    var sb = new StringBuilder();

    for(int i = 0; i < s.length(); i++) {
      if(c == ' ') {
        c = s.charAt(i);
      }
      else if(c == s.charAt(i)) {
        count++;
      }
      else {
        sb.append(c).append(count);
        count = 1;
        c = s.charAt(i);
      }

      if(i == s.length() -1) {
        sb.append(c).append(count);
      }
    }

    if(sb.toString().length() < s.length()) {
      return sb.toString();
    } else {
      return s;
    }
  }
}
