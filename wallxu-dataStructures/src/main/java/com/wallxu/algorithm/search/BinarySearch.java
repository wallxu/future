package com.wallxu.algorithm.search;

import java.util.ArrayList;
import java.util.List;

/***
 * 二分查找，必须是一个有序数组
 * @author wallxu
 */
public class BinarySearch {

    /***
     * 请对一个有序数组进行二分查找 {1,8, 10, 89, 1000, 1234}，
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        int index = binarySearch(arr, 12345);
        System.out.println("binarySearch数组下标：" + index);

        //个有序数组中，有多个相同的数值时，如何将所有的数值都查找到
        int[] arrList = {1, 8, 10, 89, 1000, 1000, 1000, 1000, 1000, 1000, 1234};
        List indexList = binarySearchAll(arrList, 1000);
        System.out.println("binarySearchAll 数组下标：" + indexList.toString());
    }

    /**
     * 当一个有序数组中，有多个相同的数值时，如何将所有的数值都查找到
     *
     * @param arrList
     * @param target
     * @return: java.util.List<java.lang.Integer>
     * @author: wallxu
     * @date: 2020/7/18 10:40
     * @since 1.0.0
     */
    private static List binarySearchAll(int[] arrList, int target) {
        //左下标
        int left = 0;
        //右下标
        int right = arrList.length - 1;
        ArrayList indexList = new ArrayList();

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arrList[mid] == target) {

                System.out.println("已找到");
                indexList.add(mid);

                //向左边扫描，找到所有满足的放到indexList里
                int temp = mid - 1;
                while (true) {
                    if (temp < 0 || arrList[temp] != target) {
                        break;
                    }
                    System.out.println("已找到");
                    indexList.add(temp);
                    temp -= 1;
                }

                temp = mid + 1;
                while (true) {
                    if (temp > arrList.length - 1 || arrList[temp] != target) {
                        break;
                    }
                    System.out.println("已找到");
                    indexList.add(temp);
                    temp += 1;
                }

                return indexList;
            } else if (arrList[mid] < target) {
                //小于目标值，left右移动
                left = mid + 1;
            } else if (arrList[mid] > target) {
                //大于目标值，right左移动
                right = mid - 1;
            }
        }

        return indexList;
    }

    /***
     * 输入一个数看看该数组是否存在此数，并且求出下标，如果没有就提示"没有这个数"。
     * @param arr
     * @param target
     * @return
     */
    private static int binarySearch(int[] arr, int target) {
        return binarySearch(arr, 0, arr.length - 1, target);
    }

    /***
     * 递归查找数据
     * @param arr
     * @param left
     * @param right
     * @param target
     * @return
     */
    private static int binarySearch(int[] arr, int left, int right, int target) {
        if (left > right) {
            System.out.println("未找到数据");
            return -1;
        }
        int mid = (left + right) / 2;
        if (arr[mid] < target) {
            //小于目标值，left往右边找
            return binarySearch(arr, mid + 1, right, target);
        } else if (arr[mid] > target) {
            //大于目标值，right往左边找
            return binarySearch(arr, left, mid - 1, target);
        } else {
            System.out.println("找到数据了");
            return mid;
        }
    }

}
