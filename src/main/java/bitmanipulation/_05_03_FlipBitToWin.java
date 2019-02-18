package bitmanipulation;

import java.util.ArrayList;
import java.util.List;

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
        /*
        int num = 0;
        for (byte i = 0; i < 32; ++i) {
            boolean isZero = isZeroAt(n, i);
            if (isZero) {
                int len = getMaxLengthOfOnes(n, i);
                if (len > num) {
                    num = len;
                }
            }
        }
        if (num == 0) {
            // there is no zero in the binary representation
            num = 32;
        }
        System.out.println("The answer to number " + n + " is " + num);
        return num;
        */

        return sampleSolution(n);
    }

    private boolean isZeroAt(int n, byte pos) {
        int mask = 1 << pos;
        return (n & mask) == 0;
    }

    private int getMaxLengthOfOnes(int n, byte flipOn) {
        int len = 0;
        int maxLen = len;
        int mask = 1;
        for (byte i = 0; i < 32; ++i, mask <<= 1) {
            if ((n & mask) != 0 || i == flipOn) {
                ++len;
            } else {
                if (len > maxLen) {
                    maxLen = len;
                }
                len = 0;
            }
        }
        System.out.println(String.format("Flipping to %d(%s) @%d got %d 1s", n, toBinaryString(n), flipOn, maxLen));
        return maxLen;
    }

    private static String toBinaryString(int n) {
        int mask = Integer.MIN_VALUE;
        StringBuilder sb = new StringBuilder();
        for (byte i = 1; i <= 32; ++i) {
            sb.append((n & mask) == 0 ? "0" : "1");
            if (i % 8 == 0) {
                sb.append(' ');
            }
            mask >>>= 1;
        }
        return sb.toString();
    }

    private static int sampleSolution(int n) {
        if (n == -1) {
            return 32;
        }
        int pre = 0;
        int cur = 0;
        int max = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                ++cur;
            } else {
                // check if the next bit is "0", which means current counting is not applicable for next round of count
                pre = (n & 2) == 0 ? 0 : cur;
                cur = 0;
            }
            max = Math.max(max, pre + cur + 1);
            n >>>= 1;
        }
        return max;
    }
}
