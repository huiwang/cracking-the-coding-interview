package recursivedp;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Implement an algorithm to print all valid (e.g., properly opened and closed) combinations of n pairs of parentheses.
 * EXAMPLE
 * Input: 3
 * Output: ((())), (()()), (())(), ()(()), ()()()
 */
public class _08_09_Parens {

    //time o(2^n) space o(n) where n = pairs * 2
    Set<String> combine(int pairs) {
        if (pairs == 0) return Collections.emptySet();
        Set<String> result = new HashSet<>();
        char[] buff = new char[pairs * 2];
        doCombine(pairs, 0, 0, result, buff);
        return result;
    }

    private void doCombine(int pairs, int open, int close, Set<String> result, char[] buff) {
        if (open == pairs && close == pairs) {
            result.add(String.valueOf(buff));
        } else {
            if (open < pairs) {
                buff[open + close] = '(';
                doCombine(pairs, open + 1, close, result, buff);
            }
            if (close < open) {
                buff[open + close] = ')';
                doCombine(pairs, open, close + 1, result, buff);
            }
        }
    }
}
