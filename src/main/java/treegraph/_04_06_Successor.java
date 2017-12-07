package treegraph;

/**
 * Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a binary search tree.
 * You may assume that each node has a link to its parent.
 */
class _04_06_Successor {
    ParentAwareBinaryTreeNode findInOrderSuccessor(ParentAwareBinaryTreeNode node) {
        if (node == null) return null;
        if (node.right != null) {
            return leftMost(node.right);
        }
        ParentAwareBinaryTreeNode p = node.parent;
        while (p != null && p.parent != null) {
            if (p.parent.left == p) {
                return p.parent;
            } else {
                p = p.parent;
            }
        }
        return p;
    }

    private ParentAwareBinaryTreeNode leftMost(ParentAwareBinaryTreeNode node) {
        if (node == null) return null;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

}
