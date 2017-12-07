package arraystring;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
 */
class _01_08_ZeroMatrix {
    int[][] zero(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return matrix;
        int n = matrix[0].length;
        if (n == 0) return matrix;

        boolean hasZeroInFirstRow = findZeroInFirstRow(matrix[0], n);

        boolean hasZeroInFirstCol = findZeroInFirstCol(matrix, m);

        detectZeroRowCol(matrix, m, n);

        zeroRows(matrix, m, n);

        zeroCols(matrix, m, n);

        if (hasZeroInFirstRow) {
            zeroFirstRow(matrix, n);
        }

        if (hasZeroInFirstCol) {
            zeroFirstCol(matrix, m);
        }

        return matrix;

    }

    private void zeroFirstCol(int[][] matrix, int m) {
        for (int i = 0; i < m; i++) {
            matrix[i][0] = 0;
        }
    }

    private void zeroFirstRow(int[][] matrix, int n) {
        for (int j = 0; j < n; j++) {
            matrix[0][j] = 0;
        }
    }

    private void zeroCols(int[][] matrix, int m, int n) {
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    private void zeroRows(int[][] matrix, int m, int n) {
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    private void detectZeroRowCol(int[][] matrix, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
    }

    private boolean findZeroInFirstCol(int[][] matrix, int m) {
        boolean hasZeroInFirstCol = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) hasZeroInFirstCol = true;
        }
        return hasZeroInFirstCol;
    }

    private boolean findZeroInFirstRow(int[] matrix, int n) {
        boolean hasZeroInFirstRow = false;
        for (int j = 0; j < n; j++) {
            if (matrix[j] == 0) hasZeroInFirstRow = true;
        }
        return hasZeroInFirstRow;
    }
}
