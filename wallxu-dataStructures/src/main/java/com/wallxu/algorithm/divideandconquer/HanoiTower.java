package com.wallxu.algorithm.divideandconquer;

/**
 * 分治算法-汉诺塔
 *
 * @author: wallxu
 * @date: 2020/8/5 10:59
 * @since 1.0.0
 */
public class HanoiTower {
    public static void main(String[] args) {
        hanoiTower(3, 'A', 'B', 'C');
    }

    /**
     * 汉诺塔-将n个圆盘从A移动C，小盘不能放到大盘上
     *
     * @param n n个圆盘
     * @param a 柱子A
     * @param b 柱子B
     * @param c 柱子C
     * @return: void
     * @author: wallxu
     * @date: 2020/8/5 11:02
     * @since 1.0.0
     */
    private static void hanoiTower(int n, char a, char b, char c) {

        //1、只有一个圆盘，直接从A移到C
        if (n == 1) {
            System.out.println("圆盘" + n + ",从" + a + "->" + c);
        } else {
            //2、n>=2时，将圆盘分成两部分
            //部分一：(先把最上面的盘)第一个最小的圆盘, A->B, A移动到B柱
            hanoiTower(n-1, a, c, b);
            //部分二：(把最下边的盘),A->C, A移动到C柱
            System.out.println("圆盘" + n + ",从" + a + "->" + c);
            //最后再把，B柱的所有盘，B->C, B移动到C柱
            hanoiTower(n-1, b, a, c);
        }
    }
}
