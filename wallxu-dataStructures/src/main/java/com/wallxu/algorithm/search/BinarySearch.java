package com.wallxu.algorithm.search;

/***
 * 二分查找，必须是一个有序数组
 * @author hxfdl
 */
public class BinarySearch {

    /***
     * 请对一个有序数组进行二分查找 {1,8, 10, 89, 1000, 1234}，
     * @param args
     */
    public static void main(String[] args) {
        int[] arr =  {1,8, 10, 89, 1000, 1234};
        int index = binarySearch(arr, 89);
        System.out.println("数组下标：" + index);
    }

    /***
     * 输入一个数看看该数组是否存在此数，并且求出下标，如果没有就提示"没有这个数"。
     * @param arr
     * @param target
     * @return
     */
    private static int binarySearch(int[] arr, int target) {
        return binarySearch(arr, 0, arr.length, target);
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
        if(left > right){
            System.out.println("未找到数据");
        }
        int midIndex = (left + right) /2;
        if(arr[midIndex] < target){
            //小于目标值，往右边找
            binarySearch(arr, midIndex, right, target);
        }else  if(arr[midIndex] > target){
            //大于目标值，往左边找
            binarySearch(arr, left, midIndex, target);
        }else if(arr[midIndex] == target){
            System.out.println("找到数据了");
            return midIndex;
        }

        return -1;
    }

}
