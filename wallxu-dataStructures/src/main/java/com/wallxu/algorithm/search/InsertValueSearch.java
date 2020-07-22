package com.wallxu.algorithm.search;

/***
 * 插值查找，必须是一个有序数组
 * @author wallxu
 */
public class InsertValueSearch {

    /***
     * 请对一个有序数组进行插值查找 {1,8, 10, 89, 1000, 1234}，
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        int index = insertValueSearch(arr, 1000);
        System.out.println("数组下标：" + index);
    }


    /***
     * 输入一个数看看该数组是否存在此数，并且求出下标，如果没有就提示"没有这个数"。
     * @param arr
     * @param target
     * @return
     */
    private static int insertValueSearch(int[] arr, int target) {
        return insertValueSearch(arr, 0, arr.length - 1, target);
    }

    /***
     * 递归查找数据
     * @param arr
     * @param left
     * @param right
     * @param target
     * @return
     */
    private static int insertValueSearch(int[] arr, int left, int right, int target) {
        //注意：target < arr[0] target > arr[arr.length - 1] 必须需要
        //否则我们得到的mid 可能越界
        if (left > right || target < arr[0] || target > arr[arr.length - 1]) {
            System.out.println("未找到数据");
            return -1;
        }
        int mid = left + (right - left) * (target - arr[left]) / (arr[right] - arr[left]);
        if (arr[mid] < target) {
            //小于目标值，往右边找
            return insertValueSearch(arr, mid + 1, right, target);
        } else if (arr[mid] > target) {
            //大于目标值，往左边找
            return insertValueSearch(arr, left, mid - 1, target);
        } else {
            System.out.println("找到数据了");
            return mid;
        }
    }

}
