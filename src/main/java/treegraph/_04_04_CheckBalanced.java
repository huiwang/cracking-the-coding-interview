package treegraph;

/**
 * Implement a function to check if a binary tree is balanced.
 * For the purposes of this question, a balanced tree is defined to be a tree such that
 * the heights of the two subtrees of any node never differ by more than one.
 */
class _04_04_CheckBalanced {

    //time o(N) space o(logN)
    boolean isBalanced(BinaryTreeNode root) {
        return isBalancedWithHeight(root) != -1;
    }

    private int isBalancedWithHeight(BinaryTreeNode root) {
        if (root == null) return 0;
        int hl = isBalancedWithHeight(root.left);
        int hr = isBalancedWithHeight(root.right);
        if (Math.abs(hl - hr) > 1 || hr == -1 || hl == -1) return -1;
        return Math.max(hl, hr) + 1;
    }

}
