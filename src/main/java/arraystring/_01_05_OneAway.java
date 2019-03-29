package arraystring;

/**
 * There are three types of edits that can be performed on strings:
 * insert a character, remove a character, or replace a character.
 * Given two strings, write a function to check if they are one edit (or zero edits) away.
 * <p>
 * EXAMPLE
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bake -> false
 */
class _01_05_OneAway {
    boolean isOneAway(String a, String b) {
        int len = a.length();
        if (Math.abs(a.length() - b.length()) == 1) {
            char[] shorter = a.length() < b.length() ? a.toCharArray() : b.toCharArray();
            char[] longer = a.length() < b.length() ? b.toCharArray() : a.toCharArray();
            for (int i = 0, j = 0; i < shorter.length; i++) {
                while (shorter[i] != longer[j++]) {
                    if (j > i+1) {
                        return false;
                    }
                }
            }
        }
        else if (a.length() == b.length()) {
            boolean hasDifferent = false;
            for (int i = 0; i < a.length(); i ++) {
                if (a.charAt(i) != b.charAt(i)) {
                    if (!hasDifferent) {
                        hasDifferent = true;
                    }
                    else {
                        return false;
                    }
                }
            }
        }
        else {
            return false;
        }
        return true;
    }

}
