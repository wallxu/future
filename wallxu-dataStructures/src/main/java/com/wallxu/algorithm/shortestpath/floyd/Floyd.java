package com.wallxu.algorithm.shortestpath.floyd;

import java.util.Arrays;

/**
 * 弗洛伊德(Floyd)算法
 *
 * @author: wallxu
 * @date: 2020/8/19 16:45
 * @since 1.0.0
 */
public class Floyd {

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
                /*A*/ {0, 5, 7, INF, INF, INF, 2},
                /*B*/ {5, 0, INF, 9, INF, INF, 3},
                /*C*/ {7, INF, 0, INF, 8, INF, INF},
                /*D*/ {INF, 9, INF, 0, INF, 4, INF},
                /*E*/ {INF, INF, 8, INF, 0, 5, 4},
                /*F*/ {INF, INF, INF, 4, 5, 0, 6},
                /*G*/ {2, 3, INF, INF, 4, 6, 0}};

        //创建MGraph 对象
        MstGraph mstGraph = new MstGraph(vertexes, matrix);

        //打印图中数据
        mstGraph.showGraph(mstGraph);

        //调用弗洛伊德算法
        mstGraph.floyd();
        System.out.println("");
        System.out.println("弗洛伊德算法");
        mstGraph.show();
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
         * 保存，从各个顶点出发到其它顶点的距离，最后的结果，也是保留在该数组
         */
        private int[][] dis;
        /**
         * 保存到达目标顶点的前驱顶点
         */
        private int[][] pre;


        public MstGraph(char[] vertexes, int[][] weight) {
            this.vertexes = vertexes;
            this.matrix = new int[vertexes.length][vertexes.length];
            this.dis = new int[vertexes.length][vertexes.length];
            this.pre = new int[vertexes.length][vertexes.length];

            int len = weight.length;
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    this.matrix[i][j] = weight[i][j];
                }
            }

            //dis初始值
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    this.dis[i][j] = weight[i][j];
                }
            }

            //pre初始值都是自己
            for (int i = 0; i < len; i++) {
                Arrays.fill(this.pre[i], i);
            }
        }


        /**
         * 弗洛伊德算法
         * 1) 以A 顶点作为中间顶点是，B->A->C的距离由N->9，同理C到B；C->A->G的距离由N->12，同理G到C。
         * 2) 把A作为中间顶点的所有情况都进行遍历，就会得到更新距离表和前驱关系。
         * 3) 更换中间顶点，循环执行操作，直到所有顶点都作为中间顶点更新后，计算结束。
         *
         * @return: void
         * @author: wallxu
         * @date: 2020/8/24 17:31
         * @since 1.0.0
         */
        public void floyd() {
            //循环处理所有元素，作为中间节点,k就是中间顶点的下标[A,B,C,D,E,F,G]
            for (int k = 0; k < this.vertexes.length; k++) {
                //先处理更新，A为中间节点的情况。
                //开始节点
                for (int i = 0; i < this.vertexes.length; i++) {
                    //i 作为开始节点
                    for (int j = 0; j < this.vertexes.length; j++) {
                        //j 作为结束节点
                        int l1 = this.dis[i][k];
                        int l2 = this.dis[k][j];
                        if (l1 + l2 < this.dis[i][j]) {
                            //小于直达，则更新最短距离，前驱节点
                            this.dis[i][j] = l1 + l2;
                            //更新前驱顶点
                            //更新前驱顶点
                            //更新前驱顶点
                            this.pre[i][j] = this.pre[k][j];
                        }
                    }
                }
            }
        }


        /**
         * 显示pre 数组和dis 数组
         *
         * @return: void
         * @author: wallxu
         * @date: 2020/8/24 17:30
         * @since 1.0.0
         */
        public void show() {
            //为了显示便于阅读，我们优化一下输出
            char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
            for (int k = 0; k < dis.length; k++) {
                // 先将pre 数组输出一行
                for (int i = 0; i < dis.length; i++) {
                    System.out.print(vertex[pre[k][i]] + " ");
                }

                System.out.println();

                // 输出dis 数组的一行数据
                for (int i = 0; i < dis.length; i++) {
                    System.out.print("(" + vertex[k] + "到" + vertex[i] + "的最短路径是" + dis[k][i] + ") ");
                }
                System.out.println();
                System.out.println();
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
