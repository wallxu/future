package com.wallxu.algorithm.mst.prim;

import java.util.Arrays;

/**
 * 最小生成树-普里姆(Prim)算法
 * 用邻接矩阵存放
 *
 * @author: wallxu
 * @date: 2020/8/13 19:34
 * @since 1.0.0
 */
public class PrimMst {

    public static void main(String[] args) {
        //测试看看图是否创建ok
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int verxs = data.length;

        //邻接矩阵的关系使用二维数组表示,10000 这个大数，表示两个点不联通
        int[][] weight = new int[][]{
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000},};

        //创建MGraph 对象
        MstGraph mstGraph = new MstGraph(verxs, data, weight);

        mstGraph.showGraph(mstGraph);

        //测试普利姆算法
        mstGraph.prim(mstGraph, 0);
    }


    static class MstGraph {
        int verxs; //表示图的节点个数
        char[] data;//存放结点数据
        int[][] weight; //存放边，就是我们的邻接矩阵

        public MstGraph(int verxs, char[] data, int[][] weight) {
            this.verxs = verxs;
            this.data = new char[verxs];
            this.weight = new int[verxs][verxs];

            for (int i = 0; i < data.length; i++) {
                this.data[i] = data[i];
                for (int j = 0; j < verxs; j++) {
                    this.weight[i][j] = weight[i][j];
                }
            }
        }


        /**
         * 显示图的邻接矩阵
         */
        public void showGraph(MstGraph graph) {
            System.out.println("邻接矩阵为:");
            for (int[] intArr : graph.weight) {
                System.out.println(Arrays.toString(intArr));
            }
        }

        /**
         * 测试普利姆算法
         */
        public void prim(MstGraph mstGraph, int v) {
            //边起点
            int s1 = -1;
            //边终点
            int t1 = -1;
            //标记结点(顶点)是否被访问过
            int[] visitedArr = new int[mstGraph.verxs];

            //初始节点，已访问
            visitedArr[v] = 1;

            //k,循环次数，边数n-1次
            //最小生成树，要选出n-1条边
            for (int k = 0; k < mstGraph.data.length - 1; k++) {
                //初始成一个大数，后面在遍历过程中，会被替换
                int minKey = 10000;

                //这个是确定每一次生成的子图，和哪个结点的距离最近
                for (int m = 0; m < mstGraph.verxs; m++) {
                    for (int n = 0; n < mstGraph.verxs; n++) {
                        if (visitedArr[m] == 1
                                && visitedArr[n] == 0
                                && mstGraph.weight[m][n] < minKey) {
                            //给minKey赋值
                            minKey = mstGraph.weight[m][n];
                            s1 = m;
                            t1 = n;
                        }
                    }
                }

                //将当前这个结点标记为已经访问
                //将当前这个结点标记为已经访问
                //将当前这个结点标记为已经访问
                visitedArr[t1] = 1;
                //找到一条边是最小
                System.out.println("边<" + mstGraph.data[s1] + "," + mstGraph.data[t1] + "> 权值:" + minKey);
            }
        }
    }
}
