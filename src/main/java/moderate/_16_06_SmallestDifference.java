package moderate;

import java.util.Arrays;

/**
 * Given two arrays of integers, compute the pair of values (one value in each array)
 * with the smallest (non-negative) difference. Return the difference.
 * <p>
 * EXAMPLE
 * Input: {1, 3, 15, 11, 2}, {23, 127,235, 19, 8}
 * Output: 3. That is, the pair (11, 8).
 */
public class _16_06_SmallestDifference {

    int findSmallestDiff(int[] a1, int[] a2) {
        int[] small = a1.length < a2.length ? a1 : a2;
        int[] big = small == a1 ? a2 : a1;
        Arrays.sort(small);
        int diff = Integer.MAX_VALUE;
        for (int i : big) {
            int p = Arrays.binarySearch(small, i);
            if (p < 0) {
                int insertion = -p - 1;
                if (insertion > 0) {
                    diff = Math.min(diff, i - small[insertion - 1]);
                }

                if (insertion < small.length) {
                    diff = Math.min(diff, small[insertion] - i);
                }
            }
        }
        return diff;
    }
}
