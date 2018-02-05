package sortingsearching;

import java.util.Arrays;

/**
 * Given a sorted array of n integers that has been rotated an unknown number of times,
 * write code to find an element in the array. You may assume that the array was originally sorted in increasing order.
 * EXAMPLE
 * input:find 5 in {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}
 * output: 8 (index of 5 in the array)
 */
public class _10_03_SearchInRotatedArray {

    int find(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            if (arr[start] <= arr[end]) {
                return binarySearch(arr, start, end, target);
            } else {
                int middle = start + (end - start) / 2;
                if (arr[middle] >= arr[start]) {
                    if (target >= arr[start] && target <= arr[middle]) {
                        return binarySearch(arr, start, middle, target);
                    } else {
                        start = middle + 1;
                    }
                } else {
                    if (target >= arr[middle] && target <= arr[end]) {
                        return binarySearch(arr, middle, end, target);
                    } else {
                        end = middle - 1;
                    }
                }
            }
        }
        return -1;
    }

    private int binarySearch(int[] arr, int start, int end, int target) {
        return Math.max(-1, Arrays.binarySearch(arr, start, end + 1, target));
    }

}
