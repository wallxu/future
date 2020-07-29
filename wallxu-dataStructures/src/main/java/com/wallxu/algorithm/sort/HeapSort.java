package com.wallxu.algorithm.sort;

/**
 * 堆排序
 *
 * @return:
 * @author: wallxu
 * @date: 2020/7/26 22:02
 * @since 1.0.0
 */
public class HeapSort {
    /**
     * 堆用数据存储数据
     */
    private static int[] arr;

    /**
     * 堆中插入一个数据
     * 新插入的节点与父节点对比大小。如果不满足子节点小于等于父节点的大小关系，
     * 我们就互换两个节点。一直重复这个过程，直到父子节点之间满足刚说的那种大小关系
     *
     * @param array
     * @param val
     * @return: void
     * @author: wallxu
     * @date: 2020/7/26 22:04
     * @since 1.0.0
     */
    public void insertVal(int[] array, int val) {
        arr = array;
    }

    /**
     * 堆中删除堆顶数据
     * 堆顶是最大的元素。删除堆顶元素之后，把最后一个节点放到堆顶，然后利用同样的父子节点对比方法。对于不满足父子节点大小关系的，互换两个节点，并且重复进行这个过程，直到父子节点之间满足大小关系为止。这就是从上往下的堆化方法。
     *
     * @param array
     * @return: void
     * @author: wallxu
     * @date: 2020/7/26 22:04
     * @since 1.0.0
     */
    public void delHeapTopVal(int[] array) {
        arr = array;
    }


    /**
     * 直接从第一个非叶子节点开始，依次堆化, 大顶堆
     *
     * @param array
     * @return: void
     * @author: wallxu
     * @date: 2020/7/26 22:04
     * @since 1.0.0
     */
    public void buildBigHeap(int[] array) {
        arr = array;
        //将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆
        for (int index = arr.length / 2 - 1; index >= 0; index--) {
            heapify(array, index, arr.length);
        }
    }

    /**
     * 堆化
     *
     * @param array
     * @param i      表示非叶子结点在数组中索引
     * @param length 表示对多少个元素继续调整，length是在逐渐的减少
     * @return: void
     * @author: wallxu
     * @date: 2020/7/28 16:52
     * @since 1.0.0
     */
    private void heapify(int[] array, int i, int length) {

        //存储当前节点数据
        int temp = array[i];
        //1. k = i*2 +1 ，k是i结点的左子结点
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            //说明左子结点的值小于右子结点的值
            if (k + 1 < length && array[k] < array[k + 1]) {
                //k指向右节点
                k = k + 1;
            }

            //子节点大于父节点
            if (temp < array[k]) {
                //把较大的值赋给当前结点
                array[i] = array[k];
                //!!! i 指向k,继续循环比较
                i = k;
            } else {
                break;
            }
        }
        //当for 循环结束后，我们已经将以i 为父结点的树的最大值，放在了最顶(局部)
        //将temp 值放到调整后的位置
        arr[i] = temp;
    }

    /**
     * 1).将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
     * 2).重新调整结构，使其满足堆定义，反复执行调整+交换步骤，直到整个序列有序。
     */
    private void sort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            //堆顶元素与末尾元素交换
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
    }

    /**
     * 堆排序，大顶堆
     *
     * @param arr
     * @return: void
     * @author: wallxu
     * @date: 2020/7/28 21:10
     * @since 1.0.0
     */
    private static void heapSort(int[] arr) {
        HeapSort heapSort = new HeapSort();
        heapSort.buildBigHeap(arr);
//        heapSort.sort(arr);
    }


    private void swap(int[] arr, int m, int n) {
        int temp = arr[m];
        arr[m] = arr[n];
        arr[n] = temp;
    }

    private static void heapPrint() {
        System.out.println("");
        for (int i : arr) {
            System.out.print(i + ",");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] arr = {7, 5, 19, 8, 4, 1, 20, 13, 16};
        heapSort(arr);
        heapPrint();
    }

}
