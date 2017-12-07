package treegraph;

/**
 * Implement a function to check if a binary tree is a binary search tree.
 */
class _04_05_ValidateBST {

    private int pre = Integer.MIN_VALUE;

    boolean isBST(BinaryTreeNode root) {
        return inOrder(root);
    }

    private boolean inOrder(BinaryTreeNode node) {
        if (node == null) return true;

        if (!inOrder(node.left)) return false;
        if (node.val < pre) return false;
        pre = node.val;
        return inOrder(node.right);
    }
}
