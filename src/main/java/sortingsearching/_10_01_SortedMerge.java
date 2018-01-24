package sortingsearching;

/**
 * You are given two sorted arrays, A and B, where A has a large enough buffer at the end to hold B.
 * Write a method to merge B into A in sorted order.
 */
public class _10_01_SortedMerge {

    int[] merge(int[] big, int[] small) {
        int b = big.length - small.length - 1;
        int s = small.length - 1;
        int i = big.length - 1;
        while (b >= 0 || s >= 0) {
            if (b < 0) {
                big[i--] = small[s--];
            } else if (s < 0) {
                break;
            } else {
                if (small[s] > big[b]) {
                    big[i--] = small[s--];
                } else {
                    big[i--] = big[b--];
                }
            }
        }
        return big;
    }
}
