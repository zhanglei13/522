public class Solution {
    public int trap(int[] A) {
        if (A.length == 0)
            return 0;

        int[] maxLeft = new int[A.length];
        int[] maxRight = new int[A.length];

        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            maxLeft[i] = max;
            max = Math.max(max, A[i]);
        }

        max = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; i--) {
            maxRight[i] = max;
            max = Math.max(max, A[i]);
        }

        int ret = 0;
        for (int i = 1; i < A.length - 1; i++) {
            int trap = Math.min(maxLeft[i], maxRight[i]) - A[i];
            if (trap > 0)
                ret += trap;
        }
        return ret;
    }
}