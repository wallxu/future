package com.wallxu.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 把n个待排序的元素看成为一个有序表和一个无序表，开始时有序表中只包含一个元素，无序表中包含有n-1个元素，
 * 排序过程中每次从无序表中取出第一个元素，把它的排序码依次与有序表元素的排序码进行比较，
 * 将它插入到有序表中的适当位置，使之成为新的有序表。
 * @author: xukf
 * @email: xukf1@ziroom.com
 * @date: 2020/7/7 15:03
 * @since 1.0.0
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = new int[]{6, -1, 5, -1, 32, 2, 4, -1, -20};

        System.out.println("排序前---->>>>" + Arrays.toString(arr));
///
//        insertSortByStep(arr);
        insertSort(arr);
        System.out.println("排序后---->>>>" + Arrays.toString(arr));

    }

    /**
     * 按步骤插入排序
     *
     * @param arr
     * @return: void
     * @author: xukf
     * @date: 2020/7/12 12:02
     * @since 1.0.0
     */
    private static void insertSortByStep(int[] arr) {
        int i;
        //i=0不用排序
        i = 0;
        i = 1;
        //i=1时，和第一个元素比较
        if (arr[0] > arr[1]) {
            int temp = arr[0];
            arr[0] = arr[1];
            arr[1] = temp;
        }

        //i=2时，与0，1比较
        i = 2;
        int index = 2;
        int value = 5;
        while (i > 0 && arr[index] < arr[i - 1]) {
            if (arr[index] < arr[i - 1]) {
                int temp = arr[index];
                arr[index] = arr[i - 1];
                arr[i - 1] = temp;
            }
            i--;
        }

    }


    private static void insertSort(int[] arr) {

        int insertIndex = 0;
        int insertValue = 0;

        for (int i = 1; i < arr.length; i++) {
            //要插入的位置
            insertIndex = i;
            //要插入的数据
            insertValue = arr[i];

            //要插入的元素和前面的元素进行比较
            while (insertIndex > 0 && insertValue < arr[insertIndex - 1]) {
                //数据后移，为要插入的数据留出空间
                arr[insertIndex] = arr[insertIndex - 1];
                insertIndex--;
            }
            //退出while循环，要插入的位置找到了
            arr[insertIndex] = insertValue;
        }
    }
}
