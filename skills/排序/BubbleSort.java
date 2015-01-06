package sort;

/**
 * Created by zhanglei on 2015/1/6.
 * 冒泡排序
 * 优化版，如果一次扫描没有发生任何交换，说明已经排好序，可以不再执行循环
 * 如果有100个数的数组，仅前面10个无序，后面90个都已排好序且都大于前面10个数字，
 * 那么在第一趟遍历后，最后发生交换的位置必定小于10，且这个位置之后的数据必定已经有序了，
 * 记录下这位置，第二次只要从数组头部遍历到这个位置就可以了。
 */

public class BubbleSort implements Solution {
    @Override
    public int[] sort(int[] num) {
        int flag = num.length;

        while (flag > 0) {
            int end = flag;
            flag = 0;

            for (int start = 1; start < end; start++) {
                if (num[start - 1] > num[start]) {
                    int temp = num[start - 1];
                    num[start - 1] = num[start];
                    num[start] = temp;
                    flag = start;
                }
            }
        }

        return num;
    }
}
