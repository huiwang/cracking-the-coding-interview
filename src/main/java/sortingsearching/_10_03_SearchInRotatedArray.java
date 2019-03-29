package sortingsearching;

/**
 * Given a sorted array of n integers that has been rotated an unknown number of times,
 * write code to find an element in the array. You may assume that the array was originally sorted in increasing order.
 * EXAMPLE
 * input:find 5 in {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}
 * output: 8 (index of 5 in the array)
 */
public class _10_03_SearchInRotatedArray {

    int find(int[] arr, int target) {
        return findRotate(arr, 0, arr.length - 1, target);
    }

    private int findRotate(int[] arr, int low, int high, int target) {
        if (low >= high) {
            return arr[low] == target ? low : -1;
        }
        int mid = low + (high - low) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[low] < arr[mid]) {
            // left part is ordered
            int found = binarySearch(arr, low, mid - 1, target);
            if (found >= 0) {
                return found;
            }
            found = findRotate(arr, mid + 1, high, target);
            if (found >= 0) {
                return found;
            }
        } else {
            int found = findRotate(arr, low, mid - 1, target);
            if (found >= 0) {
                return found;
            }
            found = binarySearch(arr, mid + 1, high, target);
            if (found >= 0) {
                return found;
            }
        }
        return -1;
    }

    private int binarySearch(int[] arr, int low, int high, int target) {
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

}
