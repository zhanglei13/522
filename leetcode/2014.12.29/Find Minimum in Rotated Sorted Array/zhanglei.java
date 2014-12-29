public class Solution {
    public int findMin(int[] num) {
        if (num.length <= 0) {
            return -1;
        }

        int low = 0;
        int high = num.length - 1;
        int min = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (num[mid] < num[high]) {
                min = Math.min(min, num[mid]);
                high = mid - 1;
            } else {
                min = Math.min(min, num[low]);
                low = mid + 1;
            }
        }
        return min;
    }
}