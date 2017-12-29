package recursivedp;

import java.util.*;

/**
 * Write a method to compute all permutations of a string whose characters
 * are not necessarily unique. The list of permutations should not have duplicates.
 */
class _08_08_PermutationWithDup {

    Set<String> computePermutation(String str) {
        if (str.length() == 0) return Collections.singleton("");
        Map<Character, Integer> frequencyTable = buildFrequencyTable(str);
        Set<String> result = new HashSet<>();
        dfs(frequencyTable, "", str.length(), result);
        return result;
    }

    private void dfs(Map<Character, Integer> map, String prefix, int remaining, Set<String> result) {
        if (remaining == 0) {
            result.add(prefix);
        } else {
            for (Character c : map.keySet()) {
                int count = map.get(c);
                if (count > 0) {
                    map.put(c, count - 1);
                    dfs(map, prefix + c, remaining - 1, result);
                    map.put(c, count);
                }
            }
        }
    }

    private Map<Character, Integer> buildFrequencyTable(String str) {
        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            m.compute(str.charAt(i), (k, v) -> v == null ? 1 : v + 1);
        }
        return m;
    }


}
