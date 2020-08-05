package com.wallxu.datastructure.graph;

import java.util.LinkedList;

/**
 * 邻接表-存储图
 *
 * @author: wallxu
 * @email: wallxu1@.com
 * @date: 2020/8/3 22:19
 * @since 1.0.0
 */
public class ListGraph implements Graph {

    public static void main(String[] args) {
        ListGraph listGraph = new ListGraph(5);

        //维护下顶点元素之间的边
        listGraph.insertEdge(0, 1);
        listGraph.insertEdge(0, 2);
        listGraph.insertEdge(1, 2);
        listGraph.insertEdge(1, 3);
        listGraph.insertEdge(1, 4);
        System.out.println("图中边的条数：" + listGraph.getNumOfEdges());

        System.out.println("图中存储的矩阵数据：");

        listGraph.printGraph();
    }


    /**
     * 维护下顶点元素之间的边
     *
     * @param v1
     * @param v2
     * @return: void
     * @author: wallxu
     * @date: 2020/8/3 22:33
     * @since 1.0.0
     */
    public void insertEdge(Integer v1, Integer v2) {
        vertexListArr[v1].add(v2);
        vertexListArr[v2].add(v1);
        this.numOfEdges++;
    }

    /**
     * 维护下顶点元素之间的边
     *
     * @param v1
     * @param v2
     * @return: void
     * @author: wallxu
     * @date: 2020/8/3 22:33
     * @since 1.0.0
     */
    @Override
    public void insertEdge(String v1, String v2) {
//        for (LinkedList<Integer> linkedList : vertexListArr) {
//            if (linkedList.size() > 0 && linkedList.get(0).equals(v1)) {
//                //插入到链表末尾
//                linkedList.add(v2);
//                this.numOfEdges++;
//                return;
//            }
//        }
    }

    @Override
    public void insertVertex(String vertex) {

    }


    /**
     * 打印图的链表数据
     *
     * @return: void
     * @author: wallxu
     * @date: 2020/8/3 22:26
     * @since 1.0.0
     */
    @Override
    public void printGraph() {
        for (LinkedList<Integer> linkedList : vertexListArr) {
            System.out.println("");
            for (Integer s : linkedList) {
                System.out.print(s + "->");
            }
        }
    }

    /**
     * 保存图数据
     */
    private LinkedList<Integer>[] vertexListArr;

    /**
     * 边的个数
     */
    private int numOfEdges;

    /**
     * 构造图
     *
     * @param n
     * @return:
     * @author: wallxu
     * @date: 2020/8/3 22:26
     * @since 1.0.0
     */
    public ListGraph(int n) {
        this.vertexListArr = new LinkedList[n];
        for (int i = 0; i < n; ++i) {
            vertexListArr[i] = new LinkedList<>();
        }
        this.numOfEdges = 0;
    }

    /**
     * 图中边的条数
     *
     * @return: int
     * @author: wallxu
     * @date: 2020/8/3 22:26
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

    }

}
