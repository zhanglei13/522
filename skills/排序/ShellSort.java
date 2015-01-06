package sort;

/**
 * Created by zhanglei on 2015/1/6.
 * 希尔排序
 * 基本思想：算法先将要排序的一组数按某个增量gap（n/2,n为要排序数的个数）分成若干组，每组中记录的下标相差gap。
 * 对每组中全部元素进行直接插入排序，然后再用一个较小的增量（gap/2）对它进行分组，在每组中再进行直接插入排序。
 * 当增量减到1时，进行直接插入排序后，排序完成。
 */

public class ShellSort implements Solution {
    @Override
    public int[] sort(int[] num) {
        int key = 0;

        for (int gap = num.length / 2; gap > 0; gap /= 2) {
            for (int last = gap; last < num.length; last++) {
                if (num[last] >= num[last - gap])
                    continue;

                key = num[last];
                int prev = last - gap;
                while (prev >= 0 && num[prev] > key) {
                    num[prev + gap] = num[prev];
                    prev -= gap;
                }
                num[prev + gap] = key;
            }
        }

        return num;
    }
}
