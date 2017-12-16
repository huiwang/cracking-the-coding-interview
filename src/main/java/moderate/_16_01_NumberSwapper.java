package moderate;

/**
 * Write a function to swap a number in place (that is, without temporary variables).
 */
class _16_01_NumberSwapper {

    void swap(int[] ab) {
        ab[0] = ab[0] ^ ab[1];
        ab[1] = ab[0] ^ ab[1];
        ab[0] = ab[0] ^ ab[1];
    }
}
