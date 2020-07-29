package com.wallxu.datastructure.tree;

import java.util.Arrays;

/**
 * BST 数组实现二叉查找树（Binary Search,Sort Tree）
 *
 * @author: wallxu
 * @date: 2020/7/29 11:23
 * @since 1.0.0
 */
public class ArrayBinarySearchTree {

    private static int[] bstArr;

    public ArrayBinarySearchTree() {
    }

    public static void main(String[] args) {
        int[] array = {7, 3, 10, 12, 5, 1, 9};
        //数组转换为二叉排序树
        convert2BST(array);

        ArrayBinarySearchTree binarySearchTree = new ArrayBinarySearchTree();
        System.out.println("bstArr:" + Arrays.toString(bstArr));
        //中序遍历二叉排序树
        System.out.println("中序遍历");
        binarySearchTree.inOrder(0);

    }

    /**
     * 中序遍历二叉排序树
     *
     * @return: void
     * @author: wallxu
     * @date: 2020/7/29 11:33
     * @since 1.0.0
     */
    private void inOrder(int index) {
        if (index < bstArr.length) {
            //左子树
            inOrder(2 * index + 1);
            //根节点
            System.out.print(bstArr[index] + "->");
            //右子树
            inOrder(2 * index + 2);
        }
    }

    /**
     * 一个数组创建成对应的二叉排序树，并使用中序遍历二叉排序树
     *
     * @param arr
     * @return: int[]
     * @author: wallxu
     * @date: 2020/7/29 11:29
     * @since 1.0.0
     */
    private static int[] convert2BST(int[] arr) {
        //创建一个数组
        bstArr = new int[arr.length];
        for (int a : arr) {
            insertVal(bstArr, 0, a);
        }

        return bstArr;
    }

    /**
     * 向二叉排序树中，插入节点数据
     *
     * @param bstArr
     * @param key
     * @return: void
     * @author: wallxu
     * @date: 2020/7/29 11:26
     * @since 1.0.0
     */
    public static void insertVal(int[] bstArr, int index, int key) {
        if (bstArr[index] == 0) {
            //根节点为空，直接放到根节点
            bstArr[index] = key;
        }

        if (2 * index + 1 < bstArr.length && key < bstArr[index]) {
            //小于根节点，左边
            if (bstArr[2 * index + 1] == 0) {
                //左节点之前没有值，直接赋值
                bstArr[2 * index + 1] = key;
            } else {
                //左节点之前有值，插入左节点
                insertVal(bstArr, 2 * index + 1, key);
            }
        }

        if (2 * index + 2 < bstArr.length && key > bstArr[index]) {
            //大于根节点，右边
            if (bstArr[2 * index + 2] == 0) {
                //右节点之前没有值，直接赋值
                bstArr[2 * index + 2] = key;
            } else {
                //右节点之前有值，插入右节点
                insertVal(bstArr, 2 * index + 2, key);
            }
        }
    }
}
