package treegraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * A binary search tree was created by traversing through an array from left to right and inserting each element.
 * Given a binary search tree with distinct elements, print all possible arrays that could have led to this tree.
 */
class _04_09_BSTSequences {

    List<LinkedList<Integer>> sequences(BinaryTreeNode root) {
        List<LinkedList<Integer>> result = new ArrayList<>();
        if (root == null) {
            result.add(new LinkedList<>());
            return result;
        }
        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(root.val);
        List<LinkedList<Integer>> leftSeqs = sequences(root.left);
        List<LinkedList<Integer>> rightSeqs = sequences(root.right);
        for (LinkedList<Integer> leftSeq : leftSeqs) {
            for (LinkedList<Integer> rightSeq : rightSeqs) {
                List<LinkedList<Integer>> weaved = new ArrayList<>();
                weave(leftSeq, rightSeq, weaved, prefix);
                result.addAll(weaved);
            }
        }
        return result;
    }

    private void weave(LinkedList<Integer> first, LinkedList<Integer> second, List<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
        if (first.isEmpty() || second.isEmpty()) {
            LinkedList<Integer> result = new LinkedList<>(prefix);
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }

        Integer headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weave(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);

        Integer headSecond = second.removeFirst();
        prefix.addLast(headSecond);
        weave(first, second, results, prefix);
        prefix.removeLast();
        second.addFirst(headSecond);
    }

}
