package com.wallxu.algorithm.sort;

import java.util.Arrays;

/**
 * 基数排序
 * 将所有待比较数值统一为同样的数位长度，数位较短的数前面补零。
 * 从最低位开始，依次进行一次排序。这样从最低位排序一直到最高位排序完成以后, 数列就变成一个有序序列。
 *
 * @author: xukf
 * @email: xukf1@ziroom.com
 * @date: 2020/7/17 14:02
 * @since 1.0.0
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 38, 9, 34, 41, 220, 57, 26};

        System.out.println("排序前---->>>>" + Arrays.toString(arr));

        radixSort(arr);

        System.out.println("排序后---->>>>" + Arrays.toString(arr));

    }


    private static void radixSort(int[] arr) {
        //按每一位数值的大小放到相应的二维数组里
        //1. 二维数组包含10 个一维数组 放0-9
        //2. 为了防止在放入数的时候，数据溢出，则每个一维数组(桶)，大小定为arr.length
        int[][] bucket = new int[10][arr.length];

        //数组中最大值的位数
        int valueLength = 0;
        for (int a : arr) {
            if (valueLength < String.valueOf(a).length()) {
                valueLength = String.valueOf(a).length();
            }
        }

        //存放0-9，每个元素的出现的个数
        //countBucket[0],记录的就是bucket[0]桶的放入数据个数
        int[] countBucket = new int[10];

        //遍历每个数据的最大次数
        for (int i = 0, k = 1; i < valueLength; i++, k *= 10) {
            //从头到尾遍历数组
            for (int j = 0; j < arr.length; j++) {
                //(针对每个元素的对应位进行排序处理)， 第一次是个位，第二次是十位，第三次是百位..
                int digitOfElement = arr[j] / k % 10;
                //将元素放到对应桶中
                bucket[digitOfElement][countBucket[digitOfElement]] = arr[j];
                //该元素在桶中出现的次数+1
                countBucket[digitOfElement]++;
            }

            //把bucket中的元素放回arr数组里
            int c = 0;
            for (int m = 0; m < countBucket.length; m++) {
                //该元素出现次数不为0，才有必要放回原数据
                if (countBucket[m] != 0) {
                    for (int n = 0; n < countBucket[m]; n++) {
                        //把bucket中的元素放回arr数组里
                        arr[c] = bucket[m][n];
                        c++;
                    }

                    //统计次数清空
                    countBucket[m] = 0;
                }
            }
            System.out.println("第" + (i + 1) + "次排序后：" + Arrays.toString(arr));
        }
    }
}
