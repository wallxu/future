package com.wallxu.datastructure.linkedlist;

/**
 * @author wallxu
 */
public interface Linked {

    /**
     * 在指定位置插入元素
     *
     * @param index
     * @param heroNode
     * @return: void
     * @author: wallxu
     * @date: 2020/6/29 17:48
     * @since 1.0.0
     */
    void add(int index, HeroNode heroNode);


    /**
     * 按num顺序插入新的元素
     *
     * @param insertNode
     * @return: void
     * @author: wallxu
     * @date: 2020/6/29 19:11
     * @since 1.0.0
     */
    void addByOrder(HeroNode insertNode);

    /**
     * 在末尾插入元素
     *
     * @param heroNode
     * @return: void
     * @author: wallxu
     * @date: 2020/6/29 17:48
     * @since 1.0.0
     */
    void add(HeroNode heroNode);

    /**
     * 移除某个元素
     *
     * @param index
     * @return: HeroNode
     * @author: wallxu
     * @date: 2020/6/29 17:54
     * @since 1.0.0
     */
    HeroNode remove(int index);

    /**
     * 更新几点信息
     *
     * @param updateNode
     * @return: HeroNode
     * @author: wallxu
     * @date: 2020/6/29 17:54
     * @since 1.0.0
     */
    HeroNode update(HeroNode updateNode);


    /**
     * 获取第一个元素
     *
     * @return: HeroNode
     * @author: wallxu
     * @date: 2020/6/29 17:53
     * @since 1.0.0
     */
    HeroNode getFirst();

    /**
     * 获取最后一个元素
     *
     * @return: HeroNode
     * @author: wallxu
     * @date: 2020/6/29 17:53
     * @since 1.0.0
     */
    HeroNode getLast();

    /**
     * 打印数据
     *
     * @return: HeroNode
     * @author: wallxu
     * @date: 2020/6/29 17:53
     * @since 1.0.0
     */
    void print();

}
