package com.truelaurel.ctci.bitmanipulation;

/**
 * Given a positive integer,
 * print the next smallest and the next largest number that
 * have the same number of 1 bits in their binary representation.
 */
class _05_04_NextNumber {

    int nextLargest(int n) {
        int zeroToOneMask = findZeroToOneMask(n);
        int oneToZeroMask = zeroToOneMask >> 1;
        int zeroToOneFlipped = n | zeroToOneMask;
        int oneToZeroFlipped = zeroToOneFlipped & ~oneToZeroMask;
        int onesToShiftRight = oneToZeroFlipped & (oneToZeroMask - 1);
        int onesCleared = oneToZeroFlipped & ~(oneToZeroMask - 1);
        while (onesToShiftRight > 0 && (onesToShiftRight & 1) == 0) {
            onesToShiftRight >>= 1;
        }
        return onesCleared | onesToShiftRight;
    }

    private int findZeroToOneMask(int n) {
        int mask = 1;
        boolean oneFound = false;
        while (mask > 0) {
            if ((n & mask) > 0) {
                oneFound = true;
                mask <<= 1;
            } else if (oneFound) {
                return mask;
            } else {
                mask <<= 1;
            }
        }
        throw new IllegalArgumentException("Unable to find bigger integer with same number of ones");
    }
}
