package recursivedp;

/**
 * A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time.
 * Implement a method to count how many possible ways the child can run up the stairs.
 */
class _08_01_TripleStep {

    //time o(n) space o(1)
    int countWays(int steps) {
        if (steps == 0) return 1;
        else if (steps == 1) return 1;
        else if (steps == 2) return 2;
        else if (steps == 3) return 4;
        int a = 1;
        int b = 2;
        int c = 4;
        int ways = 0;
        for (int i = 4; i <= steps; i++) {
            ways = a + b + c;
            a = b;
            b = c;
            c = ways;
        }
        return ways;
    }
}
