package com.wallxu.datastructure.tree;

/***
 * 线索二叉树
 * @author hxfdl
 */
public class ThreadedBinaryTree {
    /***
     * 递归线索化时，preNode总是指向前一个节点
     */
    static TreeNode preNode = null;

    public static void main(String[] args) {
        TreeNode rootNode = TreeNode.createTreeNodes();

        //中序线索化
        inOrderThreaded(rootNode);

        System.out.println("完成线索化");
        System.out.println(rootNode.left.left);

        System.out.println("线索化后，中序遍历");
        //线索化后，中序遍历
        inOrder(rootNode);
    }

    /***
     * 线索化后，各个结点指向有变化，因此原来的遍历方式不能使用，这时需要使用新的方式遍历线索化二叉树，
     * 各个节点可以通过线型方式遍历，因此无需使用递归方式，这样也提高了遍历的效率。
     * 遍历的次序应当和中序遍历保持一致。
     * @param rootNode
     */
    private static void inOrder(TreeNode rootNode) {
        while (rootNode != null) {
            //循环找到第一个，leftType=1的节点
            while (rootNode.getLeftType() == 0) {
                rootNode = rootNode.left;
            }

            //输出当前节点
            System.out.println(rootNode);
            //如果当前节点的rightType =1,就一直输出
            while (rootNode.getRightType() != null && rootNode.getRightType() == 1) {
                rootNode = rootNode.right;
                System.out.println(rootNode);
            }
            //移动节点
            rootNode = rootNode.right;
        }
    }

    /***
     * 中序线索化
     */
    private static void inOrderThreaded(TreeNode node) {
        if (node != null) {
            //1、线索化左子树
            inOrderThreaded(node.left);

            //2、线索化当前节点
            //左节点有数据
            if (node.left != null) {
                node.setLeftType(0);
            } else {
                //左节点没数据，指向前驱节点
                node.setLeft(preNode);
                node.setLeftType(1);
            }

            //前一个节点，右节点有数据
            if (preNode != null) {
                if (preNode.right != null) {
                    preNode.setRightType(0);
                } else {
                    //右节点没数据，指向后继节点
                    preNode.setRight(node);
                    preNode.setRightType(1);
                }
            }

            //指向下一个节点
            preNode = node;

            System.out.println(node.toString());
            //3、线索化右子树
            inOrderThreaded(node.right);
        }
    }
}
