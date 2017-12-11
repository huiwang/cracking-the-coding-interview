package recursivedp;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Write a method to return all subsets of a set
 */
class _08_04_PowerSet {

    Set<Set<Integer>> subSets(Set<Integer> set) {
        if (set.isEmpty()) return Collections.emptySet();
        Set<Set<Integer>> subsets = new HashSet<>();
        subsets.add(new HashSet<>());
        for (Integer integer : set) {
            subsets = grow(subsets, integer);
        }
        return subsets;
    }

    private Set<Set<Integer>> grow(Set<Set<Integer>> subsets, Integer i) {
        Set<Set<Integer>> grown = subsets.stream().map(set -> grow(i, set)).collect(Collectors.toSet());
        grown.addAll(subsets);
        return grown;
    }

    private HashSet<Integer> grow(Integer i, Set<Integer> set) {
        HashSet<Integer> newSet = new HashSet<>(set);
        newSet.add(i);
        return newSet;
    }
}
