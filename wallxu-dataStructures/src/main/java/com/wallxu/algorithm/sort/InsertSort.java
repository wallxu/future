package com.wallxu.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author: xukf
 * @email: xukf1@ziroom.com
 * @date: 2020/7/7 15:03
 * @since 1.0.0
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 32, 2, 4, -1, -20};

        System.out.println("排序前---->>>>" + Arrays.toString(arr));
        insertSort(arr);
        System.out.println("排序后---->>>>" + Arrays.toString(arr));

    }


    private static void insertSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            //要插入的数据
            int insertIndex = i;
            int insertValue = arr[i];
5
            //循环前，每次遍历到的第一个元素
            for (int j = 0; j <= i; j++) {
                if (arr[j] > insertValue) {
                    //数据移动
                    arr[j+1] = arr[j];
                }
            }

        }
    }
}
