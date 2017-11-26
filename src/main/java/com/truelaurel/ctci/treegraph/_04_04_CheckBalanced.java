package com.truelaurel.ctci.treegraph;

/**
 * Implement a function to check if a binary tree is balanced.
 * For the purposes of this question, a balanced tree is defined to be a tree such that
 * the heights of the two subtrees of any node never differ by more than one.
 */
class _04_04_CheckBalanced {

    boolean isBalanced(BinaryTreeNode root) {

        if (root == null) return true;
        if (Math.abs(height(root.left) - height(root.right)) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(BinaryTreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
