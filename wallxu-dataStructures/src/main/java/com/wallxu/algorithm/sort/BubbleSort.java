package com.wallxu.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 对排序序列从前向后（从下标较小的元素开始）,依次比较相邻的两个元素的值，若发现逆序则交换，使值较大的元素逐渐从前移向后部。
 *
 * @author: xukf
 * @email: xukf1@ziroom.com
 * @date: 2020/7/7 10:14
 * @since 1.0.0
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{-1, 32, 2, 4, 1, 20};

        System.out.println("排序前---->>>>" + Arrays.toString(arr));

        bubbleSort(arr);

        System.out.println("排序后---->>>>" + Arrays.toString(arr));

    }

    private static void bubbleSort(int[] arr) {
        if(arr.length <= 1){
            return;
        }

        for(int i=0; i<arr.length; i++){
            boolean swapFlag = false;
            //外层循环
            for(int j=0; j<arr.length -1; j++){
                //内层循环，前后数据进行大小比较
                if(arr[j] > arr[j+1]){
                    //数据有位置交换
                    swapFlag = true;
                    //前边比后边数大，交换位置
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("第"+ (i+1) + "次排序");

            if(!swapFlag){
                //某次排序没有数据交换，说明数据已经有序了，结束循环
                break;
            }
        }
    }
}
