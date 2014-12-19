public class Solution {
    public int trap(int[] A) {
        if (A.length == 0)
			return 0;

		int curMaxHeight = 0;
		int mid = 0;
		int ret = 0;

		for (int i = 0; i < A.length; i++) {
			if (A[i] > A[mid])
				mid = i;
		}

		for (int i = 0; i < mid; i++) {
			if (A[i] < curMaxHeight) {
				ret += curMaxHeight - A[i];
			} else
				curMaxHeight = A[i];
		}

		curMaxHeight = 0;
		for (int i = A.length - 1; i > mid; i--) {
			if (A[i] < curMaxHeight) {
				ret += curMaxHeight - A[i];
			} else
				curMaxHeight = A[i];
		}
		return ret;
    }
}