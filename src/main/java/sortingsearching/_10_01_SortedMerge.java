package sortingsearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given two sorted arrays, A and B, where A has a large enough buffer at the end to hold B.
 * Write a method to merge B into A in sorted order.
 */
public class _10_01_SortedMerge {

    int[] merge(int[] big, int[] small) {
//        return myway(big, small);
        return master(big, small);
    }

    private int[] master(int[] big, int[] small) {
        int b = big.length - small.length - 1;
        int s = small.length - 1;
        int t = big.length - 1;
        while (b >= 0 || s >=0) {
            if (b < 0) {
                big[t--] = small[s--];
            } else if (s < 0 || big[b] > small[s]) {
                big[t--] = big[b--];
            } else {
                big[t--] = small[s--];
            }
        }
        return big;
    }

    private int[] myway(int[] big, int[] small) {
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while (big[i] != 0 && j < small.length) {
            if (big[i] < small[j]) {
                list.add(big[i++]);
            } else {
                list.add(small[j++]);
            }
        }
        while (big[i] != 0) {
            list.add(big[i++]);
        }
        while (j < small.length) {
            list.add(small[j++]);
        }
        for (int m = 0; m < list.size(); ++m) {
            big[m] = list.get(m);
        }
        return big;
    }
}
