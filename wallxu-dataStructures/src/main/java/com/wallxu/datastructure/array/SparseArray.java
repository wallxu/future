package com.wallxu.datastructure.array;

/**
 * 稀疏数组
 * @author: wallxu
 * @date: 2020/6/28 14:56
 * @since 1.0.0
 */
public class SparseArray {
    public static void main(String[] args) {
        int[][] arr = new int[12][11];

        arr[1][2] = 1;
        arr[2][3] = 2;
        arr[4][5] = 2;
        arr[6][3] = 2;
        arr[7][7] = 1;

        System.out.println("原二维数组数据===============start==============");
        printTwoArrays(arr);
        System.out.println("原二维数组数据===============end==============");


        System.out.println("稀疏数组数据===============start==============");
        int[][] sparseArray = convert2SparseArray(arr);
        printTwoArrays(sparseArray);
        System.out.println("稀疏数组数据===============end==============");


        System.out.println("新的二维数组数据===============start==============");
        int[][] newArray = convert2Array(sparseArray);
        printTwoArrays(newArray);
        System.out.println("新的二维数组数据===============end==============");
    }

    /**
     * 稀疏数组转换为普通二维数据
     *
     * @param sparseArray
     * @return: int[][]
     * @author: wallxu
     * @date: 2020/6/28 12:26
     * @since 1.0.0
     */
    private static int[][] convert2Array(int[][] sparseArray) {
        int[][] newArray = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            for (int j = 0; j < sparseArray[i].length; j++) {
                int row = sparseArray[i][0];
                int col = sparseArray[i][1];
                newArray[row][col] = sparseArray[i][j];
            }
        }
        return newArray;
    }

    /**
     * 二维数据转换为稀疏数据
     *
     * @param arr
     * @return: int[][]
     * @author: wallxu
     * @date: 2020/6/28 11:44
     * @since 1.0.0
     */
    private static int[][] convert2SparseArray(int[][] arr) {

        //有效值个数
        int valueCount = getValueCount(arr);

        int[][] sparseArray = new int[valueCount + 1][3];
        //原数组行数
        sparseArray[0][0] = arr.length;
        //原数组列数
        sparseArray[0][1] = arr[0].length;
        //原数组有几个有效值
        sparseArray[0][2] = valueCount;

        int i = 1;
        for (int m = 0; m < arr.length; m++) {
            for (int n = 0; n < arr[m].length; n++) {
                if (arr[m][n] > 0) {
                    //原数组有效值所在行数
                    sparseArray[i][0] = m;
                    //原数组有效值所在列数
                    sparseArray[i][1] = n;
                    //原数组有效值
                    sparseArray[i][2] = arr[m][n];
                    i++;
                }
            }
        }
        return sparseArray;
    }

    /**
     * 获取二维数组有效数据的个数
     *
     * @param arr
     * @return: int
     * @author: wallxu
     * @date: 2020/6/28 11:03
     * @since 1.0.0
     */
    private static int getValueCount(int[][] arr) {
        int val = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > 0) {
                    val++;
                }
            }
        }
        return val;
    }

    /**
     * 控制台打印二维数据数据
     * @param towArrays
     * @return: void
     * @author: wallxu
     * @date: 2020/6/28 14:55
     * @since 1.0.0
     */
    private static void printTwoArrays(int[][] towArrays) {
        for (int i = 0; i < towArrays.length; i++) {
            for (int j = 0; j < towArrays[i].length; j++) {
                System.out.print(towArrays[i][j] + ",");
            }
            System.out.println("");
        }
    }
}
