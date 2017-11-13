package com.truelaurel.ctci.arraystring;

/**
 * There are three types of edits that can be performed on strings:
 * insert a character, remove a character, or replace a character.
 * Given two strings, write a function to check if they are one edit (or zero edits) away.
 * <p>
 * EXAMPLE
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bake -> false
 */
class _01_05_OneAway {
    boolean isOneAway(String a, String b) {
        int[][] table = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i < a.length() + 1; i++) {
            for (int j = 0; j < b.length() + 1; j++) {
                if (i == 0) {
                    table[i][j] = j;
                } else if (j == 0) {
                    table[i][j] = i;
                } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    table[i][j] = table[i - 1][j - 1];
                } else {
                    int replace = table[i - 1][j - 1];
                    int insert = table[i - 1][j];
                    int delete = table[i][j - 1];
                    table[i][j] = Math.min(replace, Math.min(insert, delete)) + 1;
                }
            }
        }
        return table[a.length()][b.length()] <= 1;
    }
}
