package bitmanipulation;

/**
 * Given a real number between O and 1 (e.g., 0.72) that is passed in as a double, print the binary representation.
 * If the number cannot be represented accurately in binary with at most 32 characters, print "ERROR:'
 */
class _05_02_BinaryToString {
    String print(double num) {
        if (num <= 0 || num >= 1) return "ERROR";
        StringBuilder sb = new StringBuilder();
        sb.append(".");
        for (int i = 0; i < 32; i++) {
            if (num == 0) return sb.toString();
            num *= 2;
            if (num >= 1.0) {
                sb.append('1');
                num -= 1;
            } else {
                sb.append('0');
            }
        }
        return "ERROR";
    }
}
