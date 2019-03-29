package arraystring;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees. Can you do this in place?
 *
 * refer to leetcode 48
 */
class _01_07_RotateMatrix {
    int[][] rotate(int[][] m) {
        int start = 0, end = m.length - 1;
        while (start < end) { // rotate from outside to inside, each rotation is a level
            rotateBoundary(m, start, end);
            start++;
            end--;
        }
        return m;
    }

    /**
     * rotate the ring area of the matrix bounded by start and end
     * @param m the matrix for rotation
     * @param start the start index of the boundary
     * @param end the end index of the boundary
     */
    private void rotateBoundary(int[][] m, int start, int end) {
        if (start >= end) {
        }
        for (int i = start; i < end; i++) {
            int x = i, y = start;
            int last = m[x][y];
            for (int j = 0; j < 4; j++) {
                // new coordinate:
                // x' = y
                // y' = n - x, here n = matrix size minus 1
                int tmp = x;
                x = y;
                y = m.length - 1 - tmp;
                tmp = m[x][y];
                m[x][y] = last;
                last = tmp;
            }
        }
    }

    int[][] rotate_better(int[][] m) {
        swapRow(m);
        transpose(m);
        return m;
    }

    private void swapRow(int[][] m) {
        for (int start = 0, end = m.length - 1; start < end; ++start, ++end) {
            int[] tmp = m[start];
            m[start] = m[end];
            m[end] = tmp;
        }
    }

    private void transpose(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = i + 1; j < m.length; j++) {
                int tmp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = tmp;
            }
        }
    }
}
