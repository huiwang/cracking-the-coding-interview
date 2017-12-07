package treegraph;

class ParentAwareBinaryTreeNode {
    ParentAwareBinaryTreeNode parent;
    ParentAwareBinaryTreeNode left;
    ParentAwareBinaryTreeNode right;
    int val;

    ParentAwareBinaryTreeNode(int val) {
        this.val = val;
    }

    ParentAwareBinaryTreeNode addLeft(int val) {
        ParentAwareBinaryTreeNode left = new ParentAwareBinaryTreeNode(val);
        this.left = left;
        left.parent = this;
        return left;
    }

    ParentAwareBinaryTreeNode addRight(int val) {
        ParentAwareBinaryTreeNode right = new ParentAwareBinaryTreeNode(val);
        this.right = right;
        right.parent = this;
        return right;
    }
}
