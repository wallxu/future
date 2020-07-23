package com.wallxu.datastructure.tree;

/**
 * 顺序存储二叉树
 *
 * @author: xukf
 * @email: xukf1@ziroom.com
 * @date: 2020/7/23 12:30
 * @since 1.0.0
 */
public class ArrayBinaryTree {

    private int[] arr;

    /**
     * 顺序存储二叉树的特点:
     * 顺序二叉树通常只考虑完全二叉树
     * 第n个元素的左子节点为  2 * n + 1
     * 第n个元素的右子节点为  2 * n + 2
     * 第n个元素的父节点为  (n-1) / 2
     *
     * @param arr
     * @return:
     * @author: xukf
     * @date: 2020/7/23 12:32
     * @since 1.0.0
     */
    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree tree = new ArrayBinaryTree(arr);

        //前序遍历的结果应当为 1,2,4,5,3,6,7
        System.out.println("前序遍历");
        tree.preOrder();
        System.out.println("");

        //中序遍历的结果应当为 4,2,5,1,6,3,7
        System.out.println("中序遍历");
        tree.inOrder();
        System.out.println("");
    }

    private void inOrder() {
        inOrderIndex(0);
    }

    /**
     * 中序遍历
     *
     * @param index
     * @return: void
     * @author: xukf
     * @date: 2020/7/23 15:43
     * @since 1.0.0
     */
    private void inOrderIndex(int index) {
        int length = this.arr.length;

        if (index < length) {
            if (2 * index + 1 < length) {
                inOrderIndex(2 * index + 1);
            }

            System.out.print(this.arr[index] + "->");

            if (2 * index + 2 < length) {
                inOrderIndex(2 * index + 2);
            }
        }
    }


    private void preOrder() {
        //根节点
        preOrderIndex(0);
    }

    /**
     * 前序遍历
     * 第n个元素的左子节点为  2 * n + 1
     * * 第n个元素的右子节点为  2 * n + 2
     * * 第n个元素的父节点为  (n-1) / 2
     *
     * @return: void
     * @author: xukf
     * @date: 2020/7/23 14:59
     * @since 1.0.0
     */
    private void preOrderIndex(int index) {
        if (index < this.arr.length) {
            System.out.print(this.arr[index] + "->");

            if (2 * index + 1 < this.arr.length) {
                preOrderIndex(2 * index + 1);
            }

            if (2 * index + 2 < this.arr.length) {
                preOrderIndex(2 * index + 2);
            }
        }
    }

}
