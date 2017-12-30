package recursivedp;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Write a method to compute all permutations of a string of unique characters.
 */
class _08_07_PermutationWithoutDup {

    Set<String> computePermutation(String str) {
        if (str.length() == 0) return Collections.singleton("");
        Set<String> result = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            String prefix = str.substring(0, i);
            String remainder = str.substring(i + 1, str.length());
            Set<String> partial = computePermutation(prefix + remainder);
            for (String s : partial) {
                result.add(c + s);
            }
        }
        return result;
    }

}
