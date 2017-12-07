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
        if (a.length() == b.length()) {
            return oneReplace(a, b);
        } else if (a.length() - b.length() == 1) {
            return oneInsertion(a, b);
        } else if (b.length() - a.length() == 1) {
            return oneInsertion(b, a);
        } else {
            return false;
        }
    }

    private boolean oneInsertion(String longStr, String shortStr) {
        boolean insert = false;
        for (int i = 0, j = 0; i < shortStr.length(); i++, j++) {
            if (shortStr.charAt(i) != longStr.charAt(j)) {
                if (insert) return false;
                insert = true;
                i--;
            }
        }

        return true;
    }

    private boolean oneReplace(String a, String b) {
        boolean replace = false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (replace) return false;
                replace = true;
            }
        }
        return true;
    }
}
