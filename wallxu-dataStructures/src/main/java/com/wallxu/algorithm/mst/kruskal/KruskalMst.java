package com.wallxu.algorithm.mst.kruskal;

import java.util.Arrays;

/**
 * 最小生成树-克鲁斯卡尔算法
 *
 * @author: wallxu
 * @date: 2020/8/13 19:33
 * @since 1.0.0
 */
public class KruskalMst {

    /**
     * 使用INF 表示两个顶点不能连通
     */
    private static final int INF = 10000;

    public static void main(String[] args) {
        //测试看看图是否创建ok
        char[] vertexes = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};

        //克鲁斯卡尔算法的邻接矩阵
        int[][] matrix = {
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {0, 12, INF, INF, INF, 16, 14},
                /*B*/ {12, 0, 10, INF, INF, 7, INF},
                /*C*/ {INF, 10, 0, 3, 5, 6, INF},
                /*D*/ {INF, INF, 3, 0, 4, INF, INF},
                /*E*/ {INF, INF, 5, 4, 0, 2, 8},
                /*F*/ {16, 7, 6, INF, 2, 0, 9},
                /*G*/ {14, INF, INF, INF, 8, 9, 0}};


        //创建MGraph 对象
        MstGraph mstGraph = new MstGraph(vertexes);

        //创建MinTree 对象
        MinTree minTree = new MinTree();
        minTree.createGraph(mstGraph, matrix);

        //打印图中数据
        minTree.showGraph(mstGraph);

        minTree.kruskal(mstGraph);
    }


    /**
     * 创建最小生成树->村庄的图
     */
    static class MinTree {
        //创建图的邻接矩阵

        /**
         * @param graph  图对象
         * @param weight 图的邻接矩阵
         */
        public void createGraph(MstGraph graph, int[][] weight) {
            int len = weight.length;
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    graph.matrix[i][j] = weight[i][j];
                }
            }

            //统计边的条数
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    if (graph.matrix[i][j] > 0
                            && graph.matrix[i][j] != INF) {
                        //有效边
                        graph.edgeNum++;
                    }
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

        public void kruskal(MstGraph mstGraph) {
            //表示最后结果数组的索引
            int index = 0;
            //用于保存"已有最小生成树" 中的每个顶点在最小生成树中的终点
            int[] ends = new int[mstGraph.edgeNum];
            //创建结果数组, 保存最后的最小生成树
            Edge[] retArr = new Edge[mstGraph.edgeNum];
            //图中边的数组
            Edge[] edges = new Edge[mstGraph.edgeNum];

            for (int i = 0; i < mstGraph.vertexes.length; i++) {
                for (int j = i + 1; j < mstGraph.vertexes.length; j++) {
                    if (mstGraph.matrix[i][j] > 0
                            && mstGraph.matrix[i][j] != INF) {
                        edges[index++] = new Edge(mstGraph.vertexes[i], mstGraph.vertexes[j], mstGraph.matrix[i][j]);
                    }
                }
            }

            //按照边的权值大小进行排序(从小到大)
            sortEdges(edges);

            index = 0;
            //取出图中的边，构建最小生成树
            for (int i = 0; i < edges.length; i++) {
                //获取到第i 条边的第一个顶点(起点)
                int s = getPosition(mstGraph, edges[i].start);
                //获取到第i 条边的第2 个顶点
                int t = getPosition(mstGraph, edges[i].target);

                //获取p1 这个顶点在已有最小生成树中的终点
                int sEnd = getEnd(ends, s);
                //获取p2 这个顶点在已有最小生成树中的终点
                int tEnd = getEnd(ends, t);

                //判断该边的两个顶点的终点是否重合，重合的话则会构成回路
                if (sEnd != tEnd) {
                    //不构成回路，符合条件
                    // 设置m 在"已有最小生成树"中的终点<E,F> [0,0,0,0,5,0,0,0,0,0,0,0]
                    // 设置m 在"已有最小生成树"中的终点<E,F> [0,0,0,0,5,0,0,0,0,0,0,0]
                    ends[sEnd] = tEnd;
                    //有一条边加入到retArr数组
                    retArr[index++] = edges[i];
                }
            }

            //统计并打印"最小生成树", 输出retArr
            System.out.println("");
            System.out.println("最小生成树为:");
            for (int i = 0; i < index; i++) {
                System.out.println(retArr[i]);
            }

        }

        /**
         * 获取元素的index位置
         *
         * @return: int
         * @author: wallxu
         * @date: 2020/8/18 14:57
         * @since 1.0.0
         */
        public int getPosition(MstGraph mstGraph, char v) {
            for (int i = 0; i < mstGraph.vertexes.length; i++) {
                if (mstGraph.vertexes[i] == v) {
                    return i;
                }
            }
            return -1;
        }


        /**
         * 功能: 获取下标为i 的顶点的终点(), 用于后面判断两个顶点的终点是否相同
         *
         * @param ends  ： 数组就是记录了各个顶点对应的终点是哪个, ends数组是在遍历过程中，逐步形成
         * @param index : 表示传入的顶点对应的下标
         * @return: int 返回的就是下标为i 的这个顶点对应的终点的下标, 一会回头还有来理解
         * @author: wallxu
         * @date: 2020/8/18 14:56
         * @since 1.0.0
         */
        public int getEnd(int[] ends, int index) {
            //TODO；
            //TODO；
            while (ends[index] != 0) {
                index = ends[index];
            }
            return index;
        }

        /**
         * 边的集合，按权重进行排序,冒泡排序
         * 对图的所有边按照权值大小进行排序
         *
         * @param edges
         * @return: void
         * @author: wallxu
         * @date: 2020/8/18 14:43
         * @since 1.0.0
         */
        public void sortEdges(Edge[] edges) {
            for (int i = 0; i < edges.length - 1; i++) {
                for (int j = 0; j < edges.length - 1 - i; j++) {
                    if (edges[j].weight > edges[j + 1].weight) {
                        //交换，小的前移动
                        Edge temp = edges[j + 1];
                        edges[j + 1] = edges[j];
                        edges[j] = temp;
                    }
                }
            }
        }
    }


    static class MstGraph {
        /**
         * 边的个数
         */
        private int edgeNum;
        /**
         * 顶点数组
         */
        private char[] vertexes;
        /**
         * 邻接矩阵
         */
        private int[][] matrix;

        public MstGraph(char[] vertexes) {
            this.vertexes = vertexes;
            matrix = new int[vertexes.length][vertexes.length];
        }
    }


    /**
     * 边的信息
     */
    static class Edge {
        /**
         * 边的起点
         */
        private char start;
        /**
         * 边的终点
         */
        private char target;
        /**
         * 边的权重
         */
        private int weight;

        public Edge(char start, char target, int weight) {
            this.start = start;
            this.target = target;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge [<" + start + ", " + target + ">= " + weight + "]";
        }
    }

}
