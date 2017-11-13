package com.truelaurel.ctci.arraystring;

class _01_03_URLify {
    char[] urlify(char[] chars, int trueLength) {
        int spaces = 0;
        for (int i = 0; i < trueLength; i++) {
            if (chars[i] == ' ') {
                spaces++;
            }
        }

        if (spaces * 2 + trueLength != chars.length) {
            throw new IllegalArgumentException("Given chars is not big enough to hold all chars");
        }

        for (int i = trueLength - 1, j = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                chars[j--] = '0';
                chars[j--] = '2';
                chars[j--] = '%';
            } else {
                chars[j--] = chars[i];
            }
        }
        return chars;
    }
}
