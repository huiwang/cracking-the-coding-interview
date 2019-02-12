package bitmanipulation;

import java.util.BitSet;

/**
 * You are given two 32-bit numbers, N and M, and two bit positions, i and j.
 * Write a method to insert M into N such that M starts at bit j and ends at bit i.
 * You can assume that the bits j through i have enough space to fit all of M.
 * That is, if M = 10011, you can assume that there are at least 5 bits between j and i.
 * You would not, for example, have j = 3 and i = 2, because M could not fully fit between bit 3 and bit 2.
 * <p>
 * EXAMPLE
 * Input: N   10000000000, M 10011, i 2, j 6
 * Output:N = 10001001100
 */
class _05_01_Insertion {

    int insert(int n, int m, int i, int j) {
        printBits(n);
        printBits(m);
        int allOnes = -1;
        int left = allOnes << (j + 1);
        int right = (1 << i) - 1;
        int mask = left | right;
        int offset = m << i;
        int cleared = n & mask;
        int result = cleared | offset;
        printBits(result);
        return result;
    }

    private void printBits(int n) {
        System.out.print(n + ": ");
        int mask = 1 << 31; // get "10000000 00000000 00000000 00000000"
        for (int i = 1; i <= 32; ++i, n <<= 1) {
            System.out.print((n & mask) == 0 ? "0" : "1");
            if (i % 8 == 0) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
