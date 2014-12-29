public class Solution {
    public int searchInsert(int[] A, int target) {
        if (A.length == 0) {
            return -1;
        }

        int low = 0;
        int high = A.length - 1;
        int mid = 0;

        while (low <= high) {
            mid = (low + high) / 2;
            if (A[mid] == target)
                return mid;
            if (A[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return (A[mid] > target) ? mid : mid + 1;
    }
}