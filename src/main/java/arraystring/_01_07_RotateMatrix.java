package arraystring;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees. Can you do this in place?
 */
class _01_07_RotateMatrix {
    int[][] rotate(int[][] m) {
        int n = m.length;
        swapRow(m, n);
        transpose(m, n);
        return m;
    }

    private void transpose(int[][] m, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = tmp;
            }
        }
    }

    private void swapRow(int[][] m, int n) {
        for (int start = 0, end = n - 1; start < end; start++, end--) {
            int[] tmp = m[start];
            m[start] = m[end];
            m[end] = tmp;
        }
    }
}
