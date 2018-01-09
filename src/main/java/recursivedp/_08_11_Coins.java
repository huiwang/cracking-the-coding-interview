package recursivedp;

/**
 * Coins: Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents), and pennies (1 cent),
 * write code to calculate the number of ways of representing n cents.
 */
public class _08_11_Coins {

    int makeChangeWithQuarterDimeNickelPenny(int n) {
        int[] components = {25, 10, 5, 1};
        int[][] cache = new int[n + 1][components.length];
        return makeChange(n, 0, components, cache);
    }

    private int makeChange(int amount, int index, int[] components, int[][] cache) {
        if (amount == 0 || index == components.length - 1) {
            return 1;
        }
        if (cache[amount][index] > 0) {
            return cache[amount][index];
        }
        int ways = 0;
        for (int remaining = amount; remaining >= 0; remaining -= components[index]) {
            ways += makeChange(remaining, index + 1, components, cache);
        }
        cache[amount][index] = ways;
        return ways;
    }


}
