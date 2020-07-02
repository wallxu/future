package com.wallxu.datastructure.stack;


/**
 * 栈
 * 栈是一种后进先出的数据结构
 * Last In First Out(LIFO)
 *
 * @param <E>
 */

public interface Stack<E> {

    /**
     * 栈-是否为空  O(1)
     *
     * @return: boolean
     * @author: wallxu
     * @date: 2020/7/2 11:19
     * @since 1.0.0
     */
    public boolean isEmpty();

    /**
     * 栈的大小  O(1)
     *
     * @return: int
     * @author: wallxu
     * @date: 2020/7/2 11:20
     * @since 1.0.0
     */
    public int getSize();

    /**
     * 入栈操作  O(1)均摊
     *
     * @param e
     * @return: void
     * @author: wallxu
     * @date: 2020/7/2 11:20
     * @since 1.0.0
     */
    public void push(E e);

    /**
     * 出栈操作  O(1)均摊
     *
     * @return: E
     * @author: wallxu
     * @date: 2020/7/2 11:20
     * @since 1.0.0
     */
    public E pop();

    /**
     * 查看栈顶元素 O(1)
     *
     * @return: E
     * @author: wallxu
     * @date: 2020/7/2 11:20
     * @since 1.0.0
     */
    public E peek();

    /**
     * 遍历栈元素
     *
     * @return: E
     * @author: wallxu
     * @date: 2020/7/2 11:20
     * @since 1.0.0
     */
    public void print();

}
