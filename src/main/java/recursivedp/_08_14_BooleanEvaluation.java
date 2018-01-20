package recursivedp;

/**
 * Given a boolean expression consisting of the symbols 0 (false), 1 (true), & (AND), | (OR), and ^ (XOR),
 * and a desired boolean result value result, implement a function to count the number of ways of
 * parenthesizing the expression such that it evaluates to result.
 * <p>
 * EXAMPLE
 * countEval("1^0|0|1", false) -> 2
 * countEval("0&0&0&1^1|0", true) -> 10
 */
public class _08_14_BooleanEvaluation {

    int evaluate(String expression, boolean result) {
        if (expression.isEmpty()) return 0;
        Pair[][] cache = new Pair[expression.length() + 1][expression.length() + 1];
        Pair pair = doEvaluate(expression, 0, expression.length(), cache);
        return result ? pair.trueCount : pair.falseCount;
    }

    private Pair doEvaluate(String exp, int start, int end, Pair[][] cache) {
        if (cache[start][end] != null) {
            return cache[start][end];
        }
        Pair result;
        if (end - start == 1) {
            result = countPair(exp.charAt(start) == '1');
        } else {
            int ops = (end - start - 1) / 2;
            result = new Pair(0, 0);
            for (int i = 0; i < ops; i++) {
                int j = start + (i * 2) + 1;
                Pair leftPair = doEvaluate(exp, start, j, cache);
                Pair rightPair = doEvaluate(exp, j + 1, end, cache);
                char operator = exp.charAt(j);
                Pair combined = combine(leftPair, rightPair, operator);
                result = plus(result, combined);
            }
        }
        cache[start][end] = result;
        return result;
    }

    private Pair plus(Pair p1, Pair p2) {
        return new Pair(p1.trueCount + p2.trueCount, p1.falseCount + p2.falseCount);
    }

    private Pair combine(Pair left, Pair right, char operator) {
        int tt = left.trueCount * right.trueCount;
        int tf = left.trueCount * right.falseCount;
        int ft = left.falseCount * right.trueCount;
        int ff = left.falseCount * right.falseCount;
        switch (operator) {
            case '&':
                return new Pair(tt, tf + ft + ff);
            case '|':
                return new Pair(tt + tf + ft, ff);
            case '^':
                return new Pair(tf + ft, tt + ff);
            default:
                throw new UnsupportedOperationException();
        }
    }

    private Pair countPair(boolean result) {
        return result ? new Pair(1, 0) : new Pair(0, 1);
    }


    static class Pair {
        int trueCount;
        int falseCount;

        Pair(int trueCount, int falseCount) {
            this.trueCount = trueCount;
            this.falseCount = falseCount;
        }
    }

}
