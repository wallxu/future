package com.wallxu.algorithm.backtracking;

import java.util.Arrays;

/**
 * 在8×8格的国际象棋上摆放八个皇后，使其不能互相攻击，
 * 即：任意两个皇后都不能处于同一行、同一列或同一斜线上，问有多少种摆法。
 *
 * @author: wallxu
 * @date: 2020/8/28 15:31
 * @since 1.0.0
 */
public class Queue8 {

    /**
     * 定义一个max 表示共有多少个皇后
     */
    int max = 8;

    /**
     * 定义数组array, 保存皇后放置位置的结果,比如arr = {0 , 4, 7, 5, 2, 6, 1, 3}
     */
    int[] array = new int[max];

    /**
     * 比较次数
     */
    int compareCount = 0;

    /**
     * 正确解法个数
     */
    int resultCount = 0;


    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);

        System.out.println("比较次数:" + queue8.compareCount);
        System.out.println("正确解法个数:" + queue8.resultCount);
    }

    /**
     * 特别注意： check 是每一次递归时，进入到check 中都有for(int i = 0; i < max; i++)，因此会有回溯
     * @param n
     * @return: void
     * @author: wallxu
     * @date: 2020/8/28 16:51
     * @since 1.0.0
     */
    private void check(int n) {
        if (n == this.max) {
            //找到正确位置，解法之一
            this.resultCount++;
            print();
            return;
        }

        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < this.max; i++) {
            //先把当前这个皇后n, 放到该行的第1列
            this.array[n] = i;

            //判断当放置第n个皇后到i列时，是否冲突
            if (judge(n)) {
                //不冲突
                //接着放n+1个皇后,即开始递归
                check(n + 1);
            }

            //如果冲突，就继续执行array[n] = i; 即将第n 个皇后，放置在本行得后移的一个位置
        }
    }

    /**
     * 判断是否合格
     *
     * @param n
     * @return: boolean
     * @author: wallxu
     * @date: 2020/8/28 16:34
     * @since 1.0.0
     */
    private boolean judge(int n) {
        this.compareCount++;
        //和n前边的皇后，进行比较
        for (int i = 0; i < n; i++) {
            //任意两个皇后都不能处于同一行、同一列或同一斜线上
            // 说明
            //1. array[i] == array[n] 表示判断第n 个皇后是否和前面的n-1 个皇后在同一列
            //2. Math.abs(n-i) == Math.abs(array[n] - array[i]) 表示判断第n 个皇后是否和第i 皇后是否在同一斜线
                // n = 1 放置第2 列1 n = 1 array[1] = 1
                // Math.abs(1-0) == 1 Math.abs(array[n] - array[i]) = Math.abs(1-0) = 1
            //3. 判断是否在同一行, 没有必要，n 每次都在递增
            if (this.array[i] == this.array[n]
                    || Math.abs(n - i) == Math.abs(this.array[n] - this.array[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 输出结果
     *
     * @return: void
     * @author: wallxu
     * @date: 2020/8/28 16:34
     * @since 1.0.0
     */
    private void print() {
        System.out.println("解法：" + Arrays.toString(this.array));
    }
}
