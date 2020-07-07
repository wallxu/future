package com.wallxu.datastructure.linkedlist;

/**
 * @author wallxu
 */
public interface Linked<E> {

    /**
     * 在指定位置插入元素
     *
     * @param index
     * @param node
     * @return: void
     * @author: wallxu
     * @date: 2020/6/29 17:48
     * @since 1.0.0
     */
    void add(int index, E node);


    /**
     * 按num顺序插入新的元素
     *
     * @param insertNode
     * @return: void
     * @author: wallxu
     * @date: 2020/6/29 19:11
     * @since 1.0.0
     */
    void addByOrder(E insertNode);

    /**
     * 在末尾插入元素
     *
     * @param node
     * @return: void
     * @author: wallxu
     * @date: 2020/6/29 17:48
     * @since 1.0.0
     */
    void addLast(E node);

    /**
     * 移除某个元素
     *
     * @param index
     * @return: E
     * @author: wallxu
     * @date: 2020/6/29 17:54
     * @since 1.0.0
     */
    void remove(int index);

    /**
     * 更新几点信息
     *
     * @param updateNode
     * @return: E
     * @author: wallxu
     * @date: 2020/6/29 17:54
     * @since 1.0.0
     */
    E update(E updateNode);

    /**
     * 打印数据
     *
     * @return: E
     * @author: wallxu
     * @date: 2020/6/29 17:53
     * @since 1.0.0
     */
    void print();

    /**
     * 队列是否为空
     * @return: boolean
     * @author: wallxu
     * @date: 2020/7/4 8:57
     * @since 1.0.0
     */
    boolean isEmpty();
}
