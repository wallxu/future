package com.wallxu.algorithm.shortestpath.dijkstra;

import java.util.Arrays;

/**
 * TODO
 *
 * @author: wallxu
 * @date: 2020/8/19 16:45
 * @since 1.0.0
 */
public class Dijkstra {

    /**
     * 使用INF 表示两个顶点不能连通
     */
    private static final int INF = 65535;

    public static void main(String[] args) {
        //测试看看图是否创建ok
        char[] vertexes = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};

        //克鲁斯卡尔算法的邻接矩阵
        int[][] matrix = {
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {INF, 5, 7, INF, INF, INF, 2},
                /*B*/ {5, INF, INF, 9, INF, INF, 3},
                /*C*/ {7, INF, INF, INF, 8, INF, INF},
                /*D*/ {INF, 9, INF, INF, INF, 4, INF},
                /*E*/ {INF, INF, 8, INF, INF, 5, 4},
                /*F*/ {INF, INF, INF, 4, 5, INF, 6},
                /*G*/ {2, 3, INF, INF, 4, 6, INF}};

        //创建MGraph 对象
        MstGraph mstGraph = new MstGraph(vertexes, matrix);

        //打印图中数据
        mstGraph.showGraph(mstGraph);

        //测试迪杰斯特拉算法, C
        mstGraph.dsj(2);
        mstGraph.showDijkstra();
    }


    static class MstGraph {
        /**
         * 顶点数组
         */
        private char[] vertexes;
        /**
         * 邻接矩阵
         */
        private int[][] matrix;

        /**
         * 已经访问的顶点的集合
         */
        private VisitedVertex vv;

        public MstGraph(char[] vertexes, int[][] weight) {
            this.vertexes = vertexes;
            this.matrix = new int[vertexes.length][vertexes.length];

            int len = weight.length;
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    this.matrix[i][j] = weight[i][j];
                }
            }
        }

        /**
         * 显示图的邻接矩阵
         */
        public void showGraph(MstGraph graph) {
            System.out.println("邻接矩阵为:");
            for (int[] intArr : graph.matrix) {
                System.out.println(Arrays.toString(intArr));
            }
        }

        public void dsj(int i) {
        }

        public void showDijkstra() {
        }
    }


    /**
     * 已访问顶点集合
     */
    static class VisitedVertex {
        /**
         * 记录各个顶点是否访问过1 表示访问过,0 未访问,会动态更新
         */
        public int[] already_arr;

        /**
         * 每个下标对应的值为前一个顶点下标, 会动态更新
         */
        public int[] pre_visited;

        /**
         * 记录出发顶点到其他所有顶点的距离,比如G 为出发顶点，就会记录G 到其它顶点的距离，会动态更新，
         * 求的最短距离就会存放到dis
         */
        public int[] dis;

        /**
         * 显示最后的结果
         * 即将三个数组的情况输出
         *
         * @return: void
         * @author: wallxu
         * @date: 2020/8/24 18:32
         * @since 1.0.0
         */
        public void show() {
            System.out.println("==========================");
            //输出already_arr
            for (int i : already_arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            //输出pre_visited
            for (int i : pre_visited) {
                System.out.print(i + " ");
            }
            System.out.println();
            //输出dis
            for (int i : dis) {
                System.out.print(i + " ");
            }
            System.out.println();
            //为了好看最后的最短距离，我们处理
            char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
            int count = 0;
            for (int i : dis) {
                if (i != 65535) {
                    System.out.print(vertex[count] + "(" + i + ") ");
                } else {
                    System.out.println("N ");
                }
                count++;
            }
            System.out.println();
        }
    }
}
