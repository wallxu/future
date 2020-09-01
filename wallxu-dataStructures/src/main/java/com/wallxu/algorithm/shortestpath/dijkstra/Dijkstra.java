package com.wallxu.algorithm.shortestpath.dijkstra;

import java.util.Arrays;

/**
 * 迪杰斯特拉算法
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

        //迪杰斯特拉算法的邻接矩阵
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

        //测试迪杰斯特拉算法, G
        mstGraph.dsj(6);
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

        public void dsj(int index) {
            vv = new VisitedVertex(vertexes.length, index);
            //更新此节点到其他节点的距离等
            update(index);

            for (int i = 0; i < matrix.length; i++) {
                // 选择并返回新的访问顶点
                index = updateArr();
                // 更新index 顶点到周围顶点的距离和前驱顶点
                update(index);
            }
        }


        /**
         * 更新index 顶点到周围顶点的距离和前驱顶点
         *
         * @param index
         * @return: void
         * @author: xukf
         * @date: 2020/9/1 14:46
         * @since 1.0.0
         */
        public void update(int index) {
            for (int i = 0; i < this.matrix[index].length; i++) {

                // len含义是: 出发顶点到index顶点的距离 + 从index顶点到i顶点的距离的和
                int len = vv.getDis(index) + this.matrix[index][i];

                // 如果i顶点没有被访问过，并且len小于出发顶点到i顶点的距离，就需要更新
                if (!vv.in(index) && len < vv.dis[i]) {
                    //距离比之前的小，更新距离
                    vv.updateDis(i, len);
                    //距离比之前的小，更新前置元素
                    vv.updatePre(i, index);
                }
            }

            //当前节点设为已访问
            vv.already_arr[index] = 1;
        }


        /**
         * 选择并返回新的访问顶点
         *
         * @return: int
         * @author: xukf
         * @date: 2020/9/1 14:54
         * @since 1.0.0
         */
        public int updateArr() {
            int minDis = INF;
            int index = 0;
            for (int j = 0; j < matrix.length; j++) {
                if (!vv.in(j) && vv.getDis(j) > 0 && vv.getDis(j) < minDis) {
                    //更新最新距离
                    minDis = vv.getDis(j);
                    index = j;
                }
            }
            return index;
        }

        public void showDijkstra() {
            vv.show();
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

        public VisitedVertex(int length, int index) {
            this.already_arr = new int[length];
            this.pre_visited = new int[length];
            this.dis = new int[length];

            //already_arr默认未访问
            Arrays.fill(this.already_arr, 0);
            //pre_visited默认-1，前置默认不存在
            Arrays.fill(this.pre_visited, -1);
            //dis默认最大
            Arrays.fill(this.dis, INF);

            //前置指向自己
            this.pre_visited[index] = 0;
            //到自己的距离是0
            this.dis[index] = 0;
        }

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
            System.out.println("输出already_arr:");
            for (int i : already_arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            System.out.println("输出pre_visited:");
            //输出pre_visited
            for (int i : pre_visited) {
                System.out.print(i + " ");
            }
            System.out.println();
            System.out.println("输出dis:");
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
                    System.out.print("N ");
                }
                count++;
            }
            System.out.println();
            System.out.println("==========================");
        }

        /**
         * 更新距离
         *
         * @param index 更新元素
         * @param dis   距离
         * @return: void
         * @author: xukf
         * @date: 2020/9/1 14:20
         * @since 1.0.0
         */
        public void updateDis(int index, int dis) {
            this.dis[index] = dis;
        }

        /**
         * 更新前置元素
         *
         * @param i 更新元素
         * @param k 目标元素
         * @return: void
         * @author: xukf
         * @date: 2020/9/1 14:22
         * @since 1.0.0
         */
        public void updatePre(int i, int k) {
            this.pre_visited[i] = k;
        }


        public int getDis(int index) {
            return this.dis[index];
        }

        public boolean in(int index) {
            return this.already_arr[index] == 1;
        }
    }
}
