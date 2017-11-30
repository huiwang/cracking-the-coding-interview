package com.truelaurel.ctci.treegraph;

/**
 * You are given a binary tree in which each node contains an integer value (which might be positive or negative).
 * Design an algorithm to count the number of paths that sum to a given value.
 * The path does not need to start or end at the root or a leaf, but it must go downwards
 * (traveling only from parent nodes to child nodes).
 */
class _04_12_PathsWithSum {


    int countPathWithSum(BinaryTreeNode node, int sum) {
        return countHelper(node, sum, sum);
    }

    private int countHelper(BinaryTreeNode node, int sum, int original) {
        if (node == null) return 0;
        int count = 0;
        if (node.val == sum) {
            count += 1;
        } else {
            count += countHelper(node.left, sum - node.val, original)
                    + countHelper(node.right, sum - node.val, original);
        }
        count += countPathWithSum(node.left, original);
        count += countPathWithSum(node.right, original);
        return count;
    }
}
