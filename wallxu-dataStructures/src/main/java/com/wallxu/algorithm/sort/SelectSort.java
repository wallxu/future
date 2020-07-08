package com.wallxu.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 每次选出最小的，与头部元素交换
 *
 * @author: xukf
 * @email: xukf1@ziroom.com
 * @date: 2020/7/7 14:02
 * @since 1.0.0
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[]{-1, 32, 2, 4, -1, -20};

        System.out.println("排序前---->>>>" + Arrays.toString(arr));
        selectSort(arr);
        System.out.println("排序后---->>>>" + Arrays.toString(arr));

    }


    private static void selectSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            //循环前，每次遍历到的第一个元素最小
            int minIndex = i;
            int min = arr[i];
            for (int j = i; j < arr.length; j++) {
                if (min > arr[j]) {
                    //找到更小的数据
                    minIndex = j;
                    min = arr[j];
                }
            }

            //循环后，与每次遍历的第一个元素交换数据
            arr[minIndex] = arr[i];
            arr[i] = min;
        }
    }
}
