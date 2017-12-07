package treegraph;

/**
 * T1 and T2 are two very large binary trees, with T1 much bigger than T2. Create an
 * algorithm to determine if T2 is a subtree of T1.
 * <p>
 * A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical to T2.
 * That is, if you cut off the tree at node n, the two trees would be identical.
 */
class _04_10_CheckSubTree {

    private StringBuilder sb;

    boolean isSubTree(BinaryTreeNode a, BinaryTreeNode b) {
        sb = new StringBuilder();
        preOrder(a);
        String preorderA = sb.toString();
        sb = new StringBuilder();
        preOrder(b);
        String preorderB = sb.toString();
        return preorderA.contains(preorderB);
    }


    private void preOrder(BinaryTreeNode a) {
        if (a == null) {
            sb.append('x');
        } else {
            sb.append(a.val);
            preOrder(a.left);
            preOrder(a.right);
        }

    }

}
