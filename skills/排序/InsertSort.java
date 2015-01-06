package sort;

/**
 * Created by zhanglei on 2015/1/6.
 * 插入排序
 * 基本思想：在要排序的一组数中，假设前面(n-1)个数已经是排好顺序的，现在要把第n个数插到前面的有序数中，
 * 使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序。
 */

public class InsertSort implements Solution {
    @Override
    public int[] sort(int[] num) {
        int key = 0;

        for (int last = 1; last < num.length; last++) {
            if (num[last] >= num[last - 1])
                continue;

            int prev = last - 1;
            key = num[last];
            while (prev >= 0 && num[prev] > key) {
                num[prev + 1] = num[prev];
                prev--;
            }
            num[prev + 1] = key;
        }

        return num;
    }
}
