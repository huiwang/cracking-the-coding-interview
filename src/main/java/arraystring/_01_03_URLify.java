package arraystring;

import java.util.Arrays;

/**
 * Write a method to replace all spaces in a string with '%20'
 * You may assume that the string has sufficient space at the end to hold the additional characters,
 * and that you are given the "true" length of the string.
 * (Note: If implementing in Java,please use a character array so that you can perform this operation in place.)
 * <p>
 * EXAMPLE
 * Input:  "Mr John Smith    ", 13
 * Output: "Mr%20John%20Smith"
 */
class _01_03_URLify {
    char[] urlify(char[] chars, int trueLength) {
        int spaces = 0;
        for (int i = 0; i < trueLength; i++) {
            if (chars[i] == ' ') {
                spaces++;
            }
        }
        if ((chars.length - trueLength) != (2 * spaces)) {
            throw new IllegalArgumentException("incorrect length " + chars.length + ": " + (trueLength + 2 * spaces) + " required.");
        }
        /* this my own way is not efficient, the master one is better
        int j = trueLength;
        for (int i = trueLength; i > 0; i--) {
            if (chars[i-1] == ' ') {
                char[] tmp = Arrays.copyOfRange(chars, i, j);
                chars[i-1] = '%';
                chars[i] = '2';
                chars[i+1] = '0';
                System.arraycopy(tmp, 0, chars, i+2, tmp.length);
                j += 2;
            }
        }
        */
        for (int i = trueLength - 1, j = chars.length - 1; i >= 0; i--) {
           if (chars[i] == ' ') {
               chars[j--] = '0';
               chars[j--] = '2';
               chars[j--] = '%';
           }
           else {
               chars[j--] = chars[i];
           }
        }
        return chars;
    }
}
