package sortingsearching;

import java.util.Arrays;

/**
 * You are given an array like data structure Listy which lacks a size method.
 * It does, however, have an elementAt(i) method that returns the element at index i in o(1) time.
 * If i is beyond the bounds of the data structure, it returns -1.
 * (For this reason, the data structure only supports positive integers.)
 * Given a Listy which contains sorted, positive integers, find the index at which an element x occurs.
 * If x occurs multiple times, you may return any index.
 */
public class _10_04_SortedSearch {

    int sortedSearch(Listy listy, int target) {
        throw new UnsupportedOperationException();
    }

    static class Listy {
        private int[] elems;

        static Listy of(int... elems) {
            if (elems == null || Arrays.stream(elems).anyMatch(v -> v <= 0)) {
                throw new IllegalArgumentException("elems should contain only positive integers");
            }
            Listy listy = new Listy();
            listy.elems = elems;
            return listy;
        }

        int at(int i) {
            if (i < elems.length && i >= 0) {
                return elems[i];
            }
            return -1;
        }

    }

}
