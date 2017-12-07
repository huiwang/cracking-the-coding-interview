package bitmanipulation;

/**
 * You have an integer and you can flip exactly one bit from a 0 to a 1.
 * Write code to find the length of the longest sequence of 1s you could create.
 * <p>
 * EXAMPLE
 * Input: 1775 (or: 11011101111)
 * Output: 8
 */
class _05_03_FlipBitToWin {
    int flip(int n) {
        if (n == -1) return 32;
        int pre = 0;
        int cur = 0;
        int max = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                cur++;
            } else {
                pre = (n & 2) == 0 ? 0 : cur;
                cur = 0;
            }
            max = Math.max(max, pre + cur + 1);
            n >>>= 1;
        }
        return max;
    }
}
