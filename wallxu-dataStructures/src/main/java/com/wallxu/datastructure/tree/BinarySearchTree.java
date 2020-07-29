package com.wallxu.datastructure.tree;

/**
 * BST 链表实现二叉搜索树
 *
 * @author: wallxu
 * @date: 2020/7/29 15:01
 * @since 1.0.0
 */
public class BinarySearchTree {
    private static Node treeNode;


    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9};

        for (int i : arr) {
            treeInsert(i);
        }

        System.out.println(treeSearch(10));
    }

    /**
     * 二叉搜索树中，插入数据
     *
     * @param num
     * @return: void
     * @author: wallxu
     * @date: 2020/7/29 15:19
     * @since 1.0.0
     */
    private static void treeInsert(int num) {
        if (treeNode == null) {
            //根节点为空，创建新的
            treeNode = new Node(num);
            return;
        }

        //记录下treeNode
        Node node = treeNode;

        while (true) {
            if (node.data > num) {
                //num<根节点，走左节点
                if (node.left == null) {
                    //左节点为空，创建新的
                    node.left = new Node(num);
                    return;
                }

                //左节点不为空，插入到左节点下
                node = node.left;
            } else if (node.data < num) {
                //num>根节点，走右节点
                if (node.right == null) {
                    //右节点为空，创建新的
                    node.right = new Node(num);
                    return;
                }
                //右节点不为空，插入到右节点下
                node = node.right;
            }
        }
    }

    /**
     * 二叉搜索树中，查找数据
     *
     * @param num
     * @return: void
     * @author: wallxu
     * @date: 2020/7/29 15:08
     * @since 1.0.0
     */
    private static Node treeSearch(int num) {
        Node node = treeNode;
        while (node != null) {
            if (node.data > num) {
                //左子树
                node = node.left;
            } else if (node.data < num) {
                //右子树
                node = node.right;
            } else {
                return node;
            }
        }
        return null;
    }


    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

}
