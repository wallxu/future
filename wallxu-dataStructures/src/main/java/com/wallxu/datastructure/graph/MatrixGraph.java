package com.wallxu.datastructure.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 邻接矩阵-存储图信息
 *
 * @author: wallxu
 * @email: wallxu1@.com
 * @date: 2020/8/3 18:21
 * @since 1.0.0
 */
public class MatrixGraph implements Graph {

    public static void main(String[] args) {
        MatrixGraph matrixGraph = new MatrixGraph(8);
        String[] arr = {"A", "B", "C", "D", "E", "F", "G", "H"};

        //图中插入顶点元素
        for (String s : arr) {
            matrixGraph.insertVertex(s);
        }

        //维护下顶点元素之间的边
        matrixGraph.insertEdge("A", "B");
        matrixGraph.insertEdge("A", "C");
        matrixGraph.insertEdge("B", "D");
        matrixGraph.insertEdge("B", "E");
        matrixGraph.insertEdge("C", "F");
        matrixGraph.insertEdge("C", "G");
        matrixGraph.insertEdge("D", "H");
        matrixGraph.insertEdge("E", "H");
        System.out.println("图中边的条数：" + matrixGraph.getNumOfEdges());

        System.out.println("图中存储的矩阵数据：");
        matrixGraph.printGraph();


        System.out.println("深度优先遍历");
        matrixGraph.dst("A");
        System.out.println();
        System.out.println("广度优先遍历");

        matrixGraph.bst("A");
    }

    /**
     * 输出矩阵信息
     *
     * @return: void
     * @author: wallxu
     * @date: 2020/8/3 19:19
     * @since 1.0.0
     */
    @Override
    public void printGraph() {
        int[][] edges = getEdges();
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }


    /**
     * 顶点集合
     */
    private ArrayList<String> vertexList;

    /**
     * 保存矩阵
     */
    private int[][] edges;

    /**
     * 边的个数
     */
    private int numOfEdges;

    /**
     * 已访问过的节点
     */
    private int[] visitedArr;

    /**
     * 队列
     */
    private LinkedList<Integer> queue;


    /**
     * 初始化图-矩阵
     *
     * @param n 元素个数
     * @return:
     * @author: wallxu
     * @date: 2020/8/3 18:27
     * @since 1.0.0
     */
    public MatrixGraph(int n) {
        this.vertexList = new ArrayList<>(n);
        this.visitedArr = new int[n];
        this.edges = new int[n][n];
        this.numOfEdges = 0;
        this.queue = new LinkedList<Integer>();
    }

    /**
     * 插入顶点元素
     *
     * @param vertex
     * @return: void
     * @author: wallxu
     * @date: 2020/8/3 19:07
     * @since 1.0.0
     */
    @Override
    public void insertVertex(String vertex) {
        this.vertexList.add(vertex);
    }

    /**
     * 插入元素的关系
     *
     * @param v1
     * @param v2
     * @return: void
     * @author: wallxu
     * @date: 2020/8/3 19:09
     * @since 1.0.0
     */
    @Override
    public void insertEdge(String v1, String v2) {
        int indexV1 = getVertexList().indexOf(v1);
        int indexV2 = getVertexList().indexOf(v2);
        insertEdge(indexV1, indexV2, 1);
    }


    /**
     * 插入元素的关系
     *
     * @param i
     * @param j
     * @param key 是否能够直接连接，1能；0不能
     * @return: void
     * @author: wallxu
     * @date: 2020/8/3 19:09
     * @since 1.0.0
     */
    public void insertEdge(int i, int j, int key) {
        this.edges[i][j] = key;
        this.edges[j][i] = key;
        this.numOfEdges++;
    }

    /**
     * 获取图中元素的集合
     *
     * @return: java.util.ArrayList<java.lang.String>
     * @author: wallxu
     * @date: 2020/8/3 19:10
     * @since 1.0.0
     */
    public ArrayList<String> getVertexList() {
        return vertexList;
    }

    /**
     * 获取图中矩阵信息
     *
     * @return: int[][]
     * @author: wallxu
     * @date: 2020/8/3 19:11
     * @since 1.0.0
     */
    public int[][] getEdges() {
        return edges;
    }

    /**
     * 获取图中边的条数
     *
     * @return: int
     * @author: wallxu
     * @date: 2020/8/3 19:11
     * @since 1.0.0
     */
    @Override
    public int getNumOfEdges() {
        return numOfEdges;
    }

    /**
     * 图的广度优先遍历
     *
     * @return: int
     * @author: wallxu
     * @date: 2020/8/3 22:26
     * @since 1.0.0
     */
    @Override
    public void bst(String startVertex) {
        visitedArr = new int[vertexList.size()];
        //1)访问初始结点v并标记结点v为已访问。
        //当前节点的坐标
        int index = vertexList.indexOf(startVertex);
        visitedArr[index] = 1;
        //2)结点v入队列
        queue.addLast(index);
        System.out.print("" + startVertex + "->");

        //3)当队列非空时，继续执行，否则算法结束。
        while (!queue.isEmpty()) {
            //4)出队列，取得队头结点u。
            Integer u = queue.removeFirst();
            //5)查找结点u的第一个邻接结点w。
            int w = getFirstNeighbor(u);
            //6)若结点u的邻接结点w不存在，则转到步骤3；否则循环执行以下三个步骤：
            while (w != -1) {
                //6.1 若结点w尚未被访问，则访问结点w并标记为已访问。
                if (visitedArr[w] == 0) {
                    visitedArr[w] = 1;
                    //6.2 结点w入队列
                    queue.addLast(w);
                    System.out.print("" + vertexList.get(w) + "->");
                }
                //6.3 查找结点u的继w邻接结点后的下一个邻接结点w，转到步骤6。
                w = getNextNeighbor(u, w);
            }
        }
    }


    //返回结点i(下标)对应的数据0->"A" 1->"B" 2->"C"
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    /**
     * 图的深度优先遍历
     *
     * @return: int
     * @author: wallxu
     * @date: 2020/8/3 22:26
     * @since 1.0.0
     */
    @Override
    public void dst(String startVertex) {

        //当前节点的坐标
        int index = vertexList.indexOf(startVertex);
        //1)访问初始结点v，并标记结点v为已访问。
        visitedArr[index] = 1;
        System.out.print("" + startVertex + "->");

        //2)查找结点v的第一个邻接结点w。
        int w = getFirstNeighbor(index);

        //3)若w存在，则继续执行4，如果w不存在，则回到第1步，将从v的下一个结点继续。
        if (w == -1) {
            dst(vertexList.get(index++));
        }

        while (w != -1) {
            //4)若w未被访问，对w进行深度优先遍历递归（即把w当做另一个v，然后进行步骤123）。
            if (visitedArr[w] == 0) {
                dst(vertexList.get(w));
            }
            //5)查找结点v的w邻接结点的下一个邻接结点，转到步骤3。
            w = getNextNeighbor(index, w);
        }
    }

    /**
     * 获取某一行中的有效节点数据
     *
     * @param index
     * @return: java.util.List<java.lang.Integer>
     * @author: wallxu
     * @date: 2020/8/4 11:13
     * @since 1.0.0
     */
    private List<Integer> getRowKeys(int index) {
        //当前节点关联的顶点集合
        int[] vEdges = this.edges[index];

        //结点v的第一个邻接结点w。
        List<Integer> keys = new ArrayList<Integer>();
        for (int i = 0; i < vEdges.length; i++) {
            if (vEdges[i] != 0) {
                //找到第一个邻接点
                keys.add(i);
            }
        }
        return keys;
    }

    /**
     * 得到第一个邻接结点的下标w
     *
     * @param index
     * @return 如果存在就返回对应的下标，否则返回-1
     */
    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    /**
     * 根据前一个邻接结点的下标来获取下一个邻接结点
     *
     * @param v1
     * @param v2
     * @return: int
     * @author: wallxu
     * @date: 2020/8/5 10:20
     * @since 1.0.0
     */
    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

}
