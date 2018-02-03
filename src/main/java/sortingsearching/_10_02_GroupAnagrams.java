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
        if (words == null || words.isEmpty()) return words;
        Map<String, List<String>> anagrams = new HashMap<>();
        for (String word : words) {
            anagrams.computeIfAbsent(sorted(word), k -> new ArrayList<>()).add(word);
        }
        return anagrams.values().stream().flatMap(List::stream).collect(Collectors.toList());
    }

    private String sorted(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}
