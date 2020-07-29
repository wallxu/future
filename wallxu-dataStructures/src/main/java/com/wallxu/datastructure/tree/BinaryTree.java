package com.wallxu.datastructure.tree;

/**
 * 二叉树遍历
 *
 * @author: wallxu
 * @email:
 * @date: 2020/7/21 22:09
 * @since 1.0.0
 */
public class BinaryTree {

    private static Integer count = 0;

    public static void main(String[] args) {

        TreeNode root = TreeNode.createTreeNodes();

        //转换为数组的形式存储
        TreeNode[] arr = covert2Array(root);
        System.out.println("转换后数组：");
        for (TreeNode i : arr) {
            System.out.println(i.getName() + ",");
        }

        //前、中、后序查找
//        takeSearch(root, "老A");

        //前、中、后序遍历
//        takeOrder(root);

    }

    /**
     * 转换为数组的形式存储
     * 顺序二叉树通常只考虑完全二叉树
     * 第n个元素的左子节点为  2 * n + 1
     * 第n个元素的右子节点为  2 * n + 2
     * 第n个元素的父节点为  (n-1) / 2
     *
     * @param root
     * @return: com.wallxu.datastructure.tree.TreeNode[]
     * @author: wallxu
     * @date: 2020/7/23 12:35
     * @since 1.0.0
     */
    private static TreeNode[] covert2Array(TreeNode root) {
        int length = root.getSize();

        TreeNode[] arr = new TreeNode[length];
        for (int i = 0; i < length; i++) {
            if(root != null){
                arr[i] = root;
            }
        }
        return arr;
    }


    /**
     * 前、中、后序查找
     * @param root
     * @param key
     * @return: void
     * @author: wallxu
     * @date: 2020/7/21 23:05
     * @since 1.0.0
     */
    private static void takeSearch(TreeNode root, String key) {
        //前序查找
        System.out.println("前序查找-----");
        TreeNode keyNode = preOrderSearch(root, key);
        System.out.println(keyNode);
        System.out.println("查找次数：" + count);
        System.out.println("");

        count = 0;
        //中序查找
        System.out.println("中序查找-----");
        keyNode = inOrderSearch(root, key);
        System.out.println(keyNode);
        System.out.println("查找次数：" + count);
        System.out.println("");

        //后序查找
        count = 0;
        System.out.println("后序查找-----");
        keyNode = postOrderSearch(root, key);
        System.out.println(keyNode);
        System.out.println("查找次数：" + count);
        System.out.println("");

    }

    /**
     * 后序查找 左，右，根
     *
     * @param root
     * @param key
     * @return: void
     * @author: wallxu
     * @date: 2020/7/22 9:01
     * @since 1.0.0
     */
    private static TreeNode postOrderSearch(TreeNode root, String key) {
        if (root != null) {

            if (root.left != null) {
                TreeNode leftNode = postOrderSearch(root.left, key);
                if (leftNode != null) {
                    return leftNode;
                }
            }
            if (root.right != null) {
                TreeNode rightNode = postOrderSearch(root.right, key);
                if (rightNode != null) {
                    return rightNode;
                }
            }

            count++;
            if (root.getName().equals(key)) {
                return root;
            }
        }
        return null;
    }

    /**
     * 中序查找 左，根，右
     *
     * @param root
     * @param key
     * @return: void
     * @author: wallxu
     * @date: 2020/7/22 9:00
     * @since 1.0.0
     */
    private static TreeNode inOrderSearch(TreeNode root, String key) {
        if (root != null) {
            if (root.left != null) {
                TreeNode leftNode = inOrderSearch(root.left, key);
                if (leftNode != null) {
                    return leftNode;
                }
            }

            count++;
            if (root.getName().equals(key)) {
                return root;
            }

            if (root.right != null) {
                TreeNode rightNode = inOrderSearch(root.right, key);
                if (rightNode != null) {
                    return rightNode;
                }
            }
        }
        return null;
    }

    /**
     * 前序查找 根，左，右
     * @param root
     * @param key
     * @return: void
     * @author: wallxu
     * @date: 2020/7/21 23:07
     * @since 1.0.0
     */
    private static TreeNode preOrderSearch(TreeNode root, String key) {
        if (root != null) {
            count++;
            if (root.getName().equals(key)) {
                return root;
            }
            if (root.left != null) {
                TreeNode leftNode = preOrderSearch(root.left, key);
                if (leftNode != null) {
                    return leftNode;
                }
            }
            if (root.right != null) {
                TreeNode rightNode = preOrderSearch(root.right, key);
                if (rightNode != null) {
                    return rightNode;
                }
            }
        }
        return null;
    }

    /**
     * 前、中、后序遍历
     * @param root
     * @return: void
     * @author: wallxu
     * @date: 2020/7/21 23:05
     * @since 1.0.0
     */
    private static void takeOrder(TreeNode root) {
        //前序遍历
        System.out.println("前序遍历-----");
        preOrder(root);
        System.out.println("");

        //中序遍历
        System.out.println("中序遍历-----");
        inOrder(root);
        System.out.println("");

        //后序遍历
        System.out.println("后序遍历-----");
        postOrder(root);
        System.out.println("");
    }

    /**
     * 后序遍历， 左，右，根
     * @param root
     * @return: void
     * @author: wallxu
     * @date: 2020/7/21 22:38
     * @since 1.0.0
     */
    private static void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.getName() + "->");
        }
    }

    /**
     * 中序遍历 左，根，右
     * @param root
     * @return: void
     * @author: wallxu
     * @date: 2020/7/21 22:34
     * @since 1.0.0
     */
    private static void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.getName() + "->");
            inOrder(root.right);
        }
    }

    /**
     * 前序遍历，左，根，右
     *
     * @param root
     * @return: void
     * @author: wallxu
     * @date: 2020/7/21 22:29
     * @since 1.0.0
     */
    private static void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.getName() + "->");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

}
