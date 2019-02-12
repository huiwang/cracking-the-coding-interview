package arraystring;

/**
 * Assume you have a method isSubstring which checks if one word is a substring of another.
 * Given two strings, sl and s2, write code to check if s2 is a rotation of s1
 * using only one call to isSubstring (e.g.,"waterbottle" is a rotation of"erbottlewat").
 */
class _01_09_StringRotation {
    boolean rotated(String original, String result) {
        if (original.equalsIgnoreCase(result)) {
            return true;
        }
        if (original.length() != result.length()) {
            return false;
        }
        int SIZE = original.length();
        int start = 1; // the string is not matched, so start from the second character
        while (start < SIZE) {
            if (result.charAt(start) == original.charAt(0)) {
                boolean matched = true;
                for (int i = 1; i < SIZE; ++i) {
                    int offset = (start + i) % SIZE;
                    if (original.charAt(i) != result.charAt(offset)) {
                        matched = false;
                        break;
                    }
                }
                if (matched) return true;
            }
            ++start;
        }
        return false;
    }

}
