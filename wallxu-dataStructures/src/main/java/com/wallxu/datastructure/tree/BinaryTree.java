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

        TreeNode root = treeNodes();

        //前、中、后序查找
        takeSearch(root, "老A");

        //前、中、后序遍历
//        takeOrder(root);

    }


    /**
     * 前、中、后序查找
     *
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

            if (root.getName().equals(key)) {
                count++;
                return root;
            } else {
                count++;
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

            if (root.getName().equals(key)) {
                count++;
                return root;
            } else {
                count++;
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
     *
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
     *
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
     *
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
     *
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

    /**
     * 生成TreeNode数据
     *
     * @return: com.wallxu.datastructure.tree.TreeNode
     * @author: wallxu
     * @date: 2020/7/21 22:14
     * @since 1.0.0
     */
    private static TreeNode treeNodes() {
        TreeNode rootNodeA = new TreeNode("老A");
        TreeNode rootNodeB = new TreeNode("老B");
        TreeNode rootNodeC = new TreeNode("老C");
        TreeNode rootNodeD = new TreeNode("老D");
        TreeNode rootNodeE = new TreeNode("老E");
        TreeNode rootNodeF = new TreeNode("老F");
        TreeNode rootNodeG = new TreeNode("老G");

        // -----------A----------
        // ------B-       -C-----
        // ----D----E-   -F---G--

        rootNodeA.left = rootNodeB;
        rootNodeA.right = rootNodeC;

        rootNodeB.left = rootNodeD;
        rootNodeB.right = rootNodeE;

        rootNodeC.left = rootNodeF;
        rootNodeC.right = rootNodeG;
        return rootNodeA;
    }
}
