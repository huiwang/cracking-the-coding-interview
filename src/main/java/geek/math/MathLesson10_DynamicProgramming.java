package geek.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MathLesson10_DynamicProgramming {
    /**
     * Calculate the edit distance of two words
     * This is pretty much same with arraystring._01_05_OneAway
     *
     * @param a
     * @param b
     * @return
     */
    public static int getStrDistance(String a, String b) {
        if (a == null || b == null) {
            return -1;
        }
        int[][] d = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i <= a.length(); ++i) {
            d[i][0] = i;
        }
        for (int j = 0; j <= b.length(); ++j) {
            d[0][j] = j;
        }
        for (int i = 1; i <= a.length(); ++i) {
            for (int j = 1; j <= b.length(); ++j) {
                int r = d[i-1][j-1] + (a.charAt(i-1) == b.charAt(j-1) ? 0 : 1);
                int appendA = d[i-1][j] + 1;
                int appendB = d[i][j-1] + 1;
                d[i][j] = Math.min(r, Math.min(appendA, appendB));
            }
        }
        // for debug purpose
//        System.out.println(Arrays.deepToString(d));
        return d[a.length()][b.length()];
    }

    /**
     * Get the least notes required to collect the sum of money
     *
     * @param values the values of notes we have
     * @param amount the amount of money we want to collect
     * @return
     */
    public static int getLeastNotes(int[] values, int amount) {
        if (values == null || values.length < 1) {
            return -1;
        }
        Arrays.sort(values);
        List<Integer> counts = new ArrayList<>();
        for (int i = 1; i <= amount; ++i) {
            int result = 0;
            // pick the best solution: the smallest count
            for (int j = 0; j < values.length; ++j) {
                int count = getCountForNote(values[j], counts);
                if (result == 0 || (count > 0 && result > count)) {
                    result = count;
                }
            }
            counts.add(result);
        }
        System.out.println(counts.toString());
        return counts.get(counts.size() - 1);
    }

    /**
     * Get the count of notes if we choose to pick this note
     *
     * @param noteValue the value of the note we picked
     * @param counts    the list of previous least counts we got
     * @return
     */
    private static int getCountForNote(int noteValue, List<Integer> counts) {
        // the amount we want to collect
        int amount = counts.size() + 1;
        if (amount < noteValue) {
            // impossible to collect this note to satisfy the amount
            return 0;
        }
        if (amount == noteValue) {
            // the note value matches the amount, this is certainly the least count
            return 1;
        }
        int preCount = counts.get(amount - noteValue - 1);
        // count == 0 means there is no solution to this amount
        return preCount == 0 ? 0 : preCount + 1;
    }
}
