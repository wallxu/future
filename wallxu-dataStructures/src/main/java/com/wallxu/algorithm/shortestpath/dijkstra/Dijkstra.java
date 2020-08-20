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
                /*A*/ {INF,5,7,INF,INF,INF,2},
                /*B*/ {5,INF,INF,9,INF,INF,3},
                /*C*/ {7,INF,INF,INF,8,INF,INF},
                /*D*/ {INF,9,INF,INF,INF,4,INF},
                /*E*/ {INF,INF,8,INF,INF,5,4},
                /*F*/ {INF,INF,INF,4,5,INF,6},
                /*G*/ {2,3,INF,INF,4,6,INF}};

        //创建MGraph 对象
        MstGraph mstGraph = new MstGraph(vertexes, matrix);

        //打印图中数据
        mstGraph.showGraph(mstGraph);

//        mstGraph.kruskal(mstGraph);
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
    }



}
