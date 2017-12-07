package treegraph;

import java.util.Random;

/**
 * You are implementing a binary tree class from scratch
 * which, in addition to insert, find, and delete, has a method getRandomNode()
 * which returns a random node from the tree.
 * <p>
 * All nodes should be equally likely to be chosen.
 * Design and implement an algorithm for getRandomNode,
 * and explain how you would implement the rest of the methods.
 */
class _04_11_RandomNode {

    public static class Node {
        private int size = 1;
        private Node left;
        private Node right;
        private int val;

        Node(int val) {
            this.val = val;
        }

        void insert(int val) {
            if (val <= this.val) {
                if (left != null) {
                    left.insert(val);
                } else {
                    left = new Node(val);
                }
            } else {
                if (right != null) {
                    right.insert(val);
                } else {
                    right = new Node(val);
                }
            }
            size++;
        }

        Node find(int val) {
            if (val == this.val) {
                return this;
            } else if (val <= this.val) {
                return left == null ? null : left.find(val);
            } else {
                return right == null ? null : right.find(val);
            }
        }

        Node getIthNode(int i) {
            int leftSize = left == null ? 0 : left.size;
            if (i < leftSize) {
                return left.getIthNode(i);
            } else if (i == leftSize) {
                return this;
            } else {
                return right.getIthNode(i - left.size - 1);
            }
        }

        public int getVal() {
            return val;
        }
    }

    static class Tree {
        private Node root;

        void insert(int val) {
            if (root == null) root = new Node(val);
            root.insert(val);
        }

        Node find(int val) {
            return root == null ? null : root.find(val);
        }

        Node getRandomNode() {
            Random random = new Random();
            int i = random.nextInt(root.size);
            return root.getIthNode(i);
        }
    }
}
