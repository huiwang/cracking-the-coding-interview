package sortingsearching;

import java.util.Objects;

/**
 * Given a sorted array of strings that is interspersed with empty strings,
 * write a method to find the location of a given string.
 */
public class _10_05_SparseSearch {

    int find(String[] arr, String target) {
        if (target == null || Objects.equals("", target)) return -1;
        return doFind(arr, target, 0, arr.length - 1);
    }

    private int doFind(String[] arr, String target, int start, int end) {
        if (start > end) return -1;
        int mid = start + (end - start) / 2;


        if (arr[mid].isEmpty()) {
            int left = mid;
            int right = mid;
            while (true) {
                if (left < start && right > end) return -1;
                if (left >= start && !arr[left].isEmpty()) {
                    mid = left;
                    break;
                }

                if (right <= end && !arr[right].isEmpty()) {
                    mid = right;
                    break;
                }
                left--;
                right++;
            }
        }

        if (arr[mid].equals(target)) {
            return mid;
        } else if (target.compareTo(arr[mid]) < 0) {
            return doFind(arr, target, start, mid - 1);
        } else {
            return doFind(arr, target, mid + 1, end);
        }
    }


}
