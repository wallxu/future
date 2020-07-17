package com.wallxu.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author: xukf
 * @email: xukf1@ziroom.com
 * @date: 2020/7/15 15:03
 * @since 1.0.0
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{6, -1, 5, -1, 32, 2, 4, -1, -20};
//        int[] arr = new int[]{3, 6, 5, 7, 2, 4};

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
     * @author: xukf
     * @date: 2020/7/15 19:47
     * @since 1.0.0
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
