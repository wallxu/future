package com.wallxu.datastructure.tree;

/**
 * TODO
 *
 * @author: wallxu
 * @email:
 * @date: 2020/7/21 22:09
 * @since 1.0.0
 */
public class TreeNode {
    private String name;

    TreeNode left;
    TreeNode right;

    public TreeNode(String name) {
        this.name = name;
        this.left = null;
        this.right = null;
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
}
