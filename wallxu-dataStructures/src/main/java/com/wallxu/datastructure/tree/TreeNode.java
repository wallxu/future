package com.wallxu.datastructure.tree;

import com.wallxu.datastructure.stack.ArrayStack;
import com.wallxu.datastructure.stack.Stack;

/**
 * 树节点
 *
 * @author: wallxu
 * @email:
 * @date: 2020/7/21 22:09
 * @since 1.0.0
 */
public class TreeNode {
    private String name;

    /***
     * 左节点
     */
    TreeNode left;
    /***
     * 右节点
     */
    TreeNode right;

    /***
     * 左节点类型，0左子树，1前驱节点
     */
    private Integer leftType;
    /***
     * 右节点类型，0左子树，1前驱节点
     */
    private Integer rightType;

    public TreeNode(String name) {
        this.name = name;
    }

    public TreeNode(String name, TreeNode left, TreeNode right) {
        this.name = name;
        this.left = left;
        this.right = right;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode preSearch(String name) {
        if (this.getName().equals(name)) {
            //当前节点就是要找的，返回
            return this;
        }

        //左节点
        if (this.left != null) {
            TreeNode node = this.left.preSearch(name);
            if (node != null) {
                return node;
            }
        }

        //右节点
        if (this.right != null) {
            TreeNode node = this.right.preSearch(name);
            if (node != null) {
                return node;
            }
        }
        return null;
    }

    /**
     * 删除节点
     * 如果删除的节点是叶子节点，则删除该节点
     * 如果删除的节点是非叶子节点，则删除该子树.
     *
     * @param name
     * @return: com.wallxu.datastructure.tree.TreeNode
     * @author: xukf
     * @date: 2020/7/23 11:58
     * @since 1.0.0
     */
    public void delNode(String name) {
    }


    public static void main(String[] args) {
        TreeNode rootNode = createTreeNodes();

//        TreeNode node = rootNode.preSearch("老C");
//        System.out.println(node.getName() +
//                "， 左：" + (node.left == null? "": node.left.getName()) +
//                "， 右：" + (node.right == null? "": node.right.getName()));
    }


    /**
     * 生成TreeNode数据
     *
     * @return: com.wallxu.datastructure.tree.TreeNode
     * @author: wallxu
     * @date: 2020/7/21 22:14
     * @since 1.0.0
     */
    public static TreeNode createTreeNodes() {
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

    /**
     * 返回二叉树中节点个数，非递归形式
     *
     * @return: int
     * @author: xukf
     * @date: 2020/7/23 14:11
     * @since 1.0.0
     */
    public int getSize() {
        Stack<TreeNode> stack = new ArrayStack<>();
        int size = 0;
        TreeNode node = this;
        //node为null，同时栈里没数据的时候，退出循环
        while (node != null || !stack.isEmpty()) {
            //左边走
            if (node != null) {
                stack.push(node);
                //指向左节点
//              System.out.println(node.getName());
                size++;
                node = node.left;
            } else {
                //从栈中取出元素，展示右节点
                TreeNode pop = stack.pop();
                node = pop.right;
            }
        }
        return size;
    }

    public Integer getLeftType() {
        return leftType;
    }

    public void setLeftType(Integer leftType) {
        this.leftType = leftType;
    }

    public Integer getRightType() {
        return rightType;
    }

    public void setRightType(Integer rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "name='" + name + '\'' +
                ", leftType=" + leftType +
                ", rightType=" + rightType +
                ", left=" + (left != null ? left.getName() : "") +
                ", right=" + (right != null ? right.getName() : "") +
                '}';
    }
}
