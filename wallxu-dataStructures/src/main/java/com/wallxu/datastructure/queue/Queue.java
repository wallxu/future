package com.wallxu.datastructure.queue;

/**
 * 队列
 * 队列是一种先进先出的数据结构
 * First In First Out(FIFO)
 */
public interface Queue<E> {


    /**
     * 入队
     * @param e
     * @return: void
     * @author: wallxu
     * @date: 2020/6/28 9:39
     * @since 1.0.0
     */
    public void enqueue(E e);

    /**
     * 出队
     * @return: E
     * @author: wallxu
     * @date: 2020/6/28 9:39
     * @since 1.0.0
     */
    public E dequeue();


    /**
     * 取出队首
     * @return: E
     * @author: wallxu
     * @date: 2020/6/28 9:38
     * @since 1.0.0
     */
    public E getFront();

    public int getSize();

    public boolean isEmpty();

}
