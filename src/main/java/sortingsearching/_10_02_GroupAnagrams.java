package sortingsearching;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Write a method to sort an array of strings so that all the anagrams are next to each other.
 */
public class _10_02_GroupAnagrams {

    /**
     * time o(n) ( o(nklogk) when k is the max length of a word, klogk becomes constant so we have o(n))
     * space o(n)
     */
    List<String> groupAnagrams(List<String> words) {
        Map<String, List<String>> group = new HashMap<>();
        for (String word : words) {
            String sorted = sortedString(word);
            group.computeIfAbsent(sorted, k -> new ArrayList<>()).add(word);
        }
        return group.values().stream().flatMap(List::stream).collect(Collectors.toList());
    }

    private String sortedString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}
