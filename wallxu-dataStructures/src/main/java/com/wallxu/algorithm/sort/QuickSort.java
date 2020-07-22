package com.wallxu.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * 我们遍历p到r之间的数据，将小于pivot的放到左边，将大于pivot的放到右边，将pivot放到中间。
 * 经过这一步骤之后，数组p到r之间的数据就被分成了三个部分，前面p到q-1之间都是小于pivot的，
 * 中间是pivot，后面的q+1到r之间是大于pivot的。
 * @author: wallxu
 * @email:
 * @date: 2020/7/15 15:03
 * @since 1.0.0
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{6, -1, 5, -1, 32, 2, 4, -1, -20};

        System.out.println("排序前---->>>>" + Arrays.toString(arr));
        quickSort(arr);
        System.out.println("排序后---->>>>" + Arrays.toString(arr));

    }

    private static void quickSort(int[] arr) {
        quickSortArray(arr, 0, arr.length - 1);
    }

    private static void quickSortArray(int[] arr, int p, int r) {
        if (p >= r) {
            return;
        }
        //找到分区的位置
        int q = partition(arr, p, r);
        quickSortArray(arr, p, q - 1);
        quickSortArray(arr, q + 1, r);
    }

    private static int partition(int[] arr, int p, int r) {
        //取最后一个数
        int pivot = arr[r];
        int index = r;

        for (int i = index - 1; i >= 0; i--) {
            if (arr[i] > pivot) {
                //大于pivot，交换
                swap(arr, index - 1, i);
                index--;
            }
        }

        //循环结束后pivot放到index上并返回index
        swap(arr, index, r);
        return index;
    }

    /**
     * i的元素和pivot交换位置，并变更index值
     *
     * @param arr
     * @param i
     * @param j
     * @return: void
     * @author: wallxu
     * @date: 2020/7/15 19:47
     * @since 1.0.0
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
