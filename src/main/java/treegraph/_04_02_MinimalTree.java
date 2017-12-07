package treegraph;

/**
 * Given a sorted (increasing order) array with unique integer elements, write an algorithm
 * to create a binary search tree with minimal height.
 */
class _04_02_MinimalTree {

    // time o(N), space o(logN)
    BinaryTreeNode buildMinimalTree(int[] vals) {
        return build(vals, 0, vals.length - 1);
    }

    private BinaryTreeNode build(int[] vals, int start, int end) {
        if (start == end) {
            return new BinaryTreeNode(vals[start]);
        } else if (start > end) {
            return null;
        } else {
            int mid = start + (end - start) / 2;
            BinaryTreeNode binaryTreeNode = new BinaryTreeNode(vals[mid]);
            binaryTreeNode.left = build(vals, start, mid - 1);
            binaryTreeNode.right = build(vals, mid + 1, end);
            return binaryTreeNode;
        }
    }
}
