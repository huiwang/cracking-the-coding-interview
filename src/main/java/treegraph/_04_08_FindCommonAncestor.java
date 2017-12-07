package treegraph;

/**
 * Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree.
 * Avoid storing additional nodes in a data structure. NOTE: This is not necessarily a binary search tree.
 */
class _04_08_FindCommonAncestor {

    ParentAwareBinaryTreeNode findCommonAncestor(ParentAwareBinaryTreeNode a, ParentAwareBinaryTreeNode b) {
        int da = depthOf(a);
        int db = depthOf(b);
        ParentAwareBinaryTreeNode deeper = da > db ? a : b;
        ParentAwareBinaryTreeNode other = da > db ? b : a;
        ParentAwareBinaryTreeNode c = goUp(deeper, Math.abs(da - db));
        while (other != null && c != null) {
            if (other == c) return other;
            other = other.parent;
            c = c.parent;
        }
        return null;
    }

    private ParentAwareBinaryTreeNode goUp(ParentAwareBinaryTreeNode deeper, int delta) {
        while (delta > 0 && deeper != null) {
            deeper = deeper.parent;
            delta--;
        }
        return deeper;
    }

    private int depthOf(ParentAwareBinaryTreeNode node) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.parent;
        }
        return depth;
    }
}
