package sort;

/**
 * Created by zhanglei on 2015/1/7.
 * 归并排序
 * 基本思想：把待排序序列分为若干个子序列，每个子序列是有序的,
 * 然后再把有序子序列合并为整体有序序列。
 */

public class MergeSort implements Solution {
    @Override
    public int[] sort(int[] num) {
        mergeSort(num, 0, num.length - 1);
        return num;
    }

    private void mergeSort(int[] num, int low, int high) {
        if (low >= high)
            return;

        int mid = (low + high) / 2;
        mergeSort(num, low, mid);
        mergeSort(num, mid + 1, high);
        merge(num, low, mid, high);
    }

    private void merge(int[] num, int low, int mid, int high) {
        int[] result = new int[num.length];
        int rbegin = mid + 1; //划分左侧low->mid以及右侧mid+1->high
        int index = low, start = low;

        while (low <= mid && rbegin <= high) {
            //从两个数组中取出最小的放入临时数组
            if (num[low] <= num[rbegin])
                result[index++] = num[low++];
            else
                result[index++] = num[rbegin++];
        }

        //剩余部分依次放入临时数组，仅执行其中之一
        while (low <= mid)
            result[index++] = num[low++];
        while (rbegin <= high)
            result[index++] = num[rbegin++];

        //将临时数组中的内容拷贝回原数组中
        while (start <= high)
            num[start] = result[start++];
    }
}
