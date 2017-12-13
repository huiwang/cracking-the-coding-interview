package recursivedp;

/**
 * Magic Index: A magic index in an array A[0...n-1] is defined to be an index such that A[i] = i.
 * Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A.
 */
class _08_03_MagicIndex {

    int findMagicIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == mid) {
                return mid;
            } else if (arr[mid] > mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
