package com.wallxu.datastructure.graph;

/**
 * @author wallxu
 */
public interface Graph {

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
    void insertEdge(String v1, String v2);

    /**
     * 图中插人顶点数据
     *
     * @param vertex
     * @return: void
     * @author: wallxu
     * @date: 2020/8/3 22:29
     * @since 1.0.0
     */
    void insertVertex(String vertex);

    /**
     * 打印图的链表数据
     *
     * @return: void
     * @author: wallxu
     * @date: 2020/8/3 22:26
     * @since 1.0.0
     */
    void printGraph();

    /**
     * 图中边的条数
     *
     * @return: int
     * @author: wallxu
     * @date: 2020/8/3 22:26
     * @since 1.0.0
     */
     int getNumOfEdges();

    /**
     * 图的广度优先遍历
     *
     * @return: int
     * @author: wallxu
     * @date: 2020/8/3 22:26
     * @since 1.0.0
     */
     void bst();


    /**
     * 图的深度优先遍历
     * @param startVertex 初始顶点
     * @return: void
     * @author: wallxu
     * @date: 2020/8/4 9:18
     * @since 1.0.0
     */
     void dst(String startVertex);
}
