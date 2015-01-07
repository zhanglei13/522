package sort;

/**
 * Created by zhanglei on 2015/1/7.
 * 快速排序
 * 基本思想：选择一个基准元素，通过一趟扫描，将待排序列分成两部分，一部分比基准元素小，一部分大于等于基准元素
 * 此时基准元素在其排好序后的正确位置，然后再用同样的方法递归地排序划分的两部分。
 */

public class QuickSort implements Solution {
    @Override
    public int[] sort(int[] num) {
        quickSort(num, 0, num.length - 1);
        return num;
    }

    private void quickSort(int[] num, int low, int high) {
        if (low < high) {
            int mid = partition(num, low, high);
            quickSort(num, low, mid - 1);
            quickSort(num, mid + 1, high);
        }
    }

    private int partition(int[] num, int low, int high) {
        //基准选取策略：固定，随机，三数取中
        //int pivot = num[low];   //数组第一个数字作为基准
        int pivot = medianThree(num, low, high);

        while (low < high) {
            while (low < high && num[high] >= pivot)
                high--;
            num[low] = num[high];   //小于基准的移到左侧
            while (low < high && num[low] <= pivot)
                low++;
            num[high] = num[low];   //大于基准的移到右侧
        }

        num[low] = pivot;   //基准所在位置
        return low;
    }

    private int medianThree(int[] num, int low, int high) {
        int mid = (low + high) / 2;

        if (num[mid] > num[high])
            swap(num, mid, high);
        if (num[low] > num[high])
            swap(num, low, high);
        if (num[mid] > num[low])
            swap(num, mid, low);

        //此时，num[mid] <= num[low] <= num[high]
        return num[low];
    }

    private void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
