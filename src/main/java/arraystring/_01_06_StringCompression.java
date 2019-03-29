package arraystring;

/**
 * Implement a method to perform basic string compression using the counts of repeated characters.
 * For example, the string aabcccccaaa would become a2blc5a3.
 * If the "compressed" string would not become smaller than the original string, your method should return
 * the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 */
class _01_06_StringCompression {
    String compress(String s) {
        StringBuilder sb = new StringBuilder();
        char c = ' ';
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != c) {
                if (count > 0) {
                    sb.append(c).append(count);
                }
                c = s.charAt(i);
                count = 1;
            }
            else {
                count++;
            }
        }
        if (count > 0) {
            sb.append(c).append(count);
        }
        return sb.length() < s.length() ? sb.toString() : s;
    }

    /**
     * Given an array of characters, compress it in-place.
     *
     * The length after compression must always be smaller than or equal to the original array.
     *
     * Every element of the array should be a character (not int) of length 1.
     *
     * After you are done modifying the input array in-place, return the new length of the array.
     *
     * Example 1:
     *
     * Input:
     * ["a","a","b","b","c","c","c"]
     *
     * Output:
     * Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
     *
     * Explanation:
     * "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
     *
     * Example 2:
     *
     * Input:
     * ["a"]
     *
     * Output:
     * Return 1, and the first 1 characters of the input array should be: ["a"]
     *
     * Explanation:
     * Nothing is replaced.
     *
     * Example 3:
     *
     * Input:
     * ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
     *
     * Output:
     * Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
     *
     * Explanation:
     * Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
     *
     * @param chars
     * @return
     */
    public int compress_leetcode_443(char[] chars) {
        if (chars.length <= 1) return chars.length;
        char c = chars[0];
        int count = 0;
        int j = 0;
        for (int i = 1; i <= chars.length; i++) {
            if (i < chars.length && chars[i] == c) { // repeating characters
                count++;
            }
            else if (i >= chars.length || c != chars[i]) { // to the end or encounter a new character
                chars[j++] = c;
                if (count > 0) {
                    String s = String.valueOf(count + 1);
                    System.arraycopy(s.toCharArray(), 0, chars, j, s.length());
                    j += s.length();
                }
                if (i < chars.length) {
                    c = chars[i];
                    count = 0;
                }
            }
        }
        return j;
    }

    public int compress_leetcode_443_2nd(char[] chars) {
        if (chars.length <= 1) return chars.length;
        char c = chars[0];
        int count = 0;
        int j = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == c) { // count repeating characters
                count++;
            }
            if (i + 1 == chars.length || c != chars[i]) { // to the end of the chars or a different character
                chars[j++] = c; // start to output last character
                if (count > 0) { // append count of repeating times to the character
                    String s = String.valueOf(count + 1);
                    System.arraycopy(s.toCharArray(), 0, chars, j, s.length());
                    j += s.length();
                }
                if (i + 1 == chars.length && chars[i] != c) {
                    chars[j++] = chars[i];
                }
                c = chars[i];
                count = 0;
            }
        }
        return j;
    }
    
    public int compress_leetcode_443_best(char[] chars) {
        int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            if ((read + 1 == chars.length) || (chars[read + 1] != chars[read])) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c : Integer.toString(read - anchor + 1).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }

    public static void main(String args[]) {
        _01_06_StringCompression solution = new _01_06_StringCompression();
        char[] chars = "aabbcccd".toCharArray();
        int len = solution.compress_leetcode_443(chars);
        System.out.println("After compress_mine: " + new String(chars).substring(0, len));
        chars = "aabbcccd".toCharArray();
        len = solution.compress_leetcode_443_best(chars);
        System.out.println("After compress_best: " + new String(chars).substring(0, len));
    }
}
