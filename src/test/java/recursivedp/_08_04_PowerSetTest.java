package recursivedp;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class _08_04_PowerSetTest {

    private _08_04_PowerSet s = new _08_04_PowerSet();

    @Test
    public void withEmptySet() {
        assertEquals(Collections.emptySet(), s.subSets(Collections.emptySet()));
    }

    @Test
    public void withOneElement() {
        Set<Set<Integer>> subsets = new HashSet<>();
        subsets.add(Collections.emptySet());
        subsets.add(Collections.singleton(1));
        assertEquals(subsets, s.subSets(Collections.singleton(1)));
    }

    @Test
    public void withTwoElements() {
        Set<Set<Integer>> subsets = new HashSet<>();
        subsets.add(Collections.emptySet());
        subsets.add(Collections.singleton(1));
        subsets.add(Collections.singleton(2));
        subsets.add(new HashSet<>(Arrays.asList(1, 2)));
        assertEquals(subsets, s.subSets(new HashSet<>(Arrays.asList(1, 2))));
    }
}