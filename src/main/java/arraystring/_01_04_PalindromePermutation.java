package arraystring;

/**
 * Given a string, write a function to check if it is a permutation of a palindrome.
 * A palindrome is a word or phrase that is the same forwards and backwards.
 * A permutation is a rearrangement of letters.
 * The palindrome does not need to be limited to just dictionary words.
 * <p>
 * EXAMPLE
 * Input: Tact Coa
 * Output: True (permutations: "taco cat", "atco cta", etc.)
 */
class _01_04_PalindromePermutation {
    boolean check(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(chars[i])) {
                i++;
            }
            while (j > i && !Character.isLetterOrDigit(chars[j])) {
                j--;
            }
            if (i >= j) return true;
            if (Character.toLowerCase(chars[i]) != Character.toLowerCase(chars[j])) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
