package arraystring;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
 */
class _01_08_ZeroMatrix {
    int[][] zero_mine(int[][] matrix) {
        Set<Integer> clearRows = new HashSet<>();
        Set<Integer> clearColumns = new HashSet<>();
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] == 0) {
                    clearRows.add(i);
                    clearColumns.add(j);
                }
            }
        }
        clearRows.forEach(row -> {
            for (int i = 0; i < matrix[0].length; ++i) {
                matrix[row][i] = 0;
            }
        });
        clearColumns.forEach(column -> {
            for (int i = 0; i < matrix.length; ++i) {
                matrix[i][column] = 0;
            }
        });
        return matrix;
    }

    int[][] zero(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        if (columns == 0) return matrix;
        boolean firstColumn = false;
        for (int i = 0; i < rows; ++i) {
            if (matrix[i][0] == 0) {
                // for the first column we don't change the matrix[0][0] to 0
                // as it holds the zero indication for both first row and first column
                // instead, additional variable is used to mark the zero first column
                // as a result, matrix[0][0] is used to mark zero first row only
                firstColumn = true;
            }
            for (int j = 1; j < columns; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < rows; ++i) {
            for (int j = 1; j < columns; ++j) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // deal with the first row
        if (matrix[0][0] == 0) {
            for (int j = 1; j < columns; ++j) {
                matrix[0][j] = 0;
            }
        }

        // deal with the first column
        if (firstColumn) {
            for (int i = 0; i < rows; ++i) {
                matrix[i][0] = 0;
            }
        }
        return matrix;
    }
}
