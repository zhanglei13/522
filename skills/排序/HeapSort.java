package sort;

/**
 * Created by zhanglei on 2015/1/6.
 * 堆排序
 * 堆是一个近似完全二叉树的结构，满足性质：子结点的键值或索引总是小于（或者大于）它的父节点。
 */

public class HeapSort implements Solution {
    @Override
    public int[] sort(int[] num) {
        createMaxHeap(num);
        for (int i = num.length - 1; i > 0; i--) {
            swap(num, 0, i);
            maxHeapify(num, i, 0);
        }
        return num;
    }


    private void createMaxHeap(int[] num) {
        for (int i = num.length / 2 - 1; i >= 0; i--)
            maxHeapify(num, num.length, i);
    }

    private void maxHeapify(int[] num, int heapSize, int index) {
        int left = index * 2;
        int right = left + 1;
        int largest = index;

        if (left < heapSize && num[index] < num[left]) {
            largest = left;
        }

        if (right < heapSize && num[largest] < num[right]) {
            largest = right;
        }

        if (largest != index) {
            swap(num, index, largest);
            maxHeapify(num, heapSize, largest);
        }
    }

    private void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
