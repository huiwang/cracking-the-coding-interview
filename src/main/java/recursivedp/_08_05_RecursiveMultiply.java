package recursivedp;

/**
 * Write a recursive function to multiply two positive integers without using the * operator.
 * You can use addition, subtraction, and bit shifting, but you should minimize the number of those operations.
 */
class _08_05_RecursiveMultiply {

    int multiple(int a, int b) {
        int small = Math.min(a, b);
        int big = Math.max(a, b);
        return multipleRecursive(big, small);
    }

    private int multipleRecursive(int big, int small) {
        if (small == 0) return 0;
        if (small == 1) return big;
        int half = multipleRecursive(big, small >> 1);
        if (small % 2 == 0) return half + half;
        else return half + half + big;
    }
}
