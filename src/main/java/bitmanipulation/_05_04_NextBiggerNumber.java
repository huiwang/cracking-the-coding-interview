package bitmanipulation;

/**
 * Given a positive integer,
 * print the next largest number that
 * have the same number of 1 bits in their binary representation.
 */
class _05_04_NextBiggerNumber {

    int nextBigger(int n) {
        if (n <= 0) return -1;

        int tmp = n;
        int zeros = 0;
        int ones = 0;
        while (tmp != 0 && (tmp & 1) == 0) {
            zeros++;
            tmp >>= 1;
        }
        while ((tmp & 1) == 1) {
            ones++;
            tmp >>= 1;
        }

        if (zeros + ones == 31) return -1;

        //flip zero to one
        n = n | 1 << (zeros + ones);

        //clear right part
        n = n & ~((1 << (zeros + ones)) - 1);

        //add ones
        n = n | ((1 << (ones - 1)) - 1);

        return n;
    }

}
