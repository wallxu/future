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
        int[] arr = {7, 3, 10, 12, 5, 1, 2, 9};

        for (int i : arr) {
            treeInsert(i);
        }

        System.out.println("删除前");
        inOrderShow();
        System.out.println("");

//        System.out.println(treeSearch(7));
//        System.out.println(treeSearchParentNode(7));
        delNode(10);
        delNode(3);
//        delNode(7);
//        delNode(5);
//        delNode(2);
//        delNode(12);
//        delNode(9);
        System.out.println("删除后");
        inOrderShow();

//        System.out.println(treeSearch(10));
    }

    /**
     * 中序遍历
     *
     * @return: void
     * @author: xukf
     * @date: 2020/7/30 19:57
     * @since 1.0.0
     */
    private static void inOrderShow() {
        inOrder(treeNode);
    }

    private static void inOrder(Node data) {
        if (data != null) {
            inOrder(data.left);
            System.out.print(data.data + "->");
            inOrder(data.right);
        }
    }

    /**
     * 二叉搜索树-删除节点
     * 删除叶子节点 (比如：2, 5, 9, 12)
     * 删除只有一颗子树的节点 (比如：1)
     * 删除有两颗子树的节点. (比如：7, 3，10 )
     *
     * @param num
     * @return: void
     * @author: xukf
     * @date: 2020/7/29 17:20
     * @since 1.0.0
     */
    public static void delNode(int num) {
        //当前节点
        Node targetNode = treeSearch(num);
        //父节点
        Node parentNode = treeSearchParentNode(num);

        if (targetNode == null) {
            System.out.println("没找到要删除的节点");
            return;
        }

        //找到了要删除的节点
        //1、删除叶子节点
        if (targetNode.left == null && targetNode.right == null) {
            //要删除的节点是父节点的左节点还是右节点？
            if (parentNode.left != null && parentNode.left.data == num) {
                //要删除的是左子节点
                parentNode.left = null;
            } else if (parentNode.right != null && parentNode.right.data == num) {
                //要删除的是右子节点
                parentNode.right = null;
            }

        } else if (targetNode.left != null && targetNode.right != null) {
            //3、要删除的节点有左节点和右节点（删除有两颗子树的节点）
            //从targetNode 的右子树找到最小的结点,并删除该最小结点
            // 用一个临时变量，将最小结点的值保存temp
            int temp = delRightTreeMin(targetNode.right);
            targetNode.data = temp;

        } else {
            //2、要删除的节点有左节点或右节点（删除只有一颗子树的节点）
            if (parentNode == null) {
                //要删除的是根节点
                System.out.println("要删除的是根节点");
                return;
            }

            //targetNode 是parent 的左子结点还是右子结点
            //如果targetNode 有左子结点
            if (targetNode.left != null) {
                if (parentNode.left != null && parentNode.left.data == num) {
                    //如果targetNode 是parent 的左子结点
                    parentNode.left = targetNode.left;

                } else if (parentNode.right != null && parentNode.right.data == num) {
                    //如果targetNode 是parent 的右子结点
                    parentNode.right = targetNode.left;
                }
            }

            //如果targetNode 有右子结点
            if (targetNode.right != null) {
                if (parentNode.left != null && parentNode.left.data == num) {
                    //如果targetNode 是parent 的左子结点
                    parentNode.left = targetNode.right;

                } else if (parentNode.right != null && parentNode.right.data == num) {
                    //如果targetNode 是parent 的右子结点
                    parentNode.right = targetNode.right;
                }
            }
        }
    }

    /**
     * 从targetNode 的右子树找到最小的结点,并删除该最小结点
     *
     * @param node
     * @return: int 最小节点的值
     * @author: xukf
     * @date: 2020/8/1 10:48
     * @since 1.0.0
     */
    private static int delRightTreeMin(Node node) {
        while (node != null) {
            //最小的节点在左边
            if (node.left != null) {
                node = node.left;
            } else {
                //没有左节点，说明是最小的了
                //删除最小的节点
                delNode(node.data);
                return node.data;
            }
        }
        return -1;
    }


    /**
     * 二叉搜索树，插入数据
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
                //节点数据 > num，走左节点
                if (node.left == null) {
                    //左节点为空，创建新的
                    node.left = new Node(num);
                    return;
                }
                //左节点不为空，插入到左节点下
                node = node.left;

            } else if (node.data < num) {
                //节点数据 < num，走右节点
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
     * 二叉搜索树，查找数据所在节点，没有返回null
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

    /**
     * 二叉搜索树，查找该数据的父节点，没有返回null
     *
     * @param num
     * @return: void
     * @author: wallxu
     * @date: 2020/7/29 15:08
     * @since 1.0.0
     */
    private static Node treeSearchParentNode(int num) {
        Node node = treeNode;
        while (node != null) {
            if ((node.left != null && node.left.data == num)
                    || (node.right != null && node.right.data == num)) {
                return node;
            }
            if (node.data > num) {
                //左子树
                node = node.left;
            } else if (node.data < num) {
                //右子树
                node = node.right;
            } else if (node.data == num) {
                return null;
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
