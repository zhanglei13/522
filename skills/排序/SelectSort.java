package sort;

/**
 * Created by zhanglei on 2015/1/6.
 * 选择排序
 * 基本思想：在要排序的一组数中，选出最小的一个数与第一个位置的数交换，然后在剩下的数当中再找最小的与第二个位置的数交换，
 * 如此循环到倒数第二个数和最后一个数比较为止。
 */

public class SelectSort implements Solution {
    @Override
    public int[] sort(int[] num) {
        int index;

        for (int i = 0; i < num.length; i++) {
            index = i;

            for (int j = i + 1; j < num.length; j++) {
                if (num[j] < num[index]) {
                    index = j;
                }
            }

            if (index != i)
                swap(num, i, index);
        }

        return num;
    }

    private void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}