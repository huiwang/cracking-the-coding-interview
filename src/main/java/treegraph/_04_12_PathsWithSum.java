package treegraph;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given a binary tree in which each node contains an integer value (which might be positive or negative).
 * Design an algorithm to count the number of paths that target to a given value.
 * The path does not need to start or end at the root or a leaf, but it must go downwards
 * (traveling only from parent nodes to child nodes).
 */
class _04_12_PathsWithSum {


    private int target;
    private Map<Integer, Integer> runningSumToCount;
    private int count;

    int countPathWithSum(BinaryTreeNode node, int sum) {
        count = 0;
        runningSumToCount = new HashMap<>();
        runningSumToCount.put(0, 1);
        target = sum;
        countHelper(node, 0);
        return count;
    }

    private void countHelper(BinaryTreeNode node, int acc) {
        if (node == null) return;
        int runningSum = acc + node.val;
        runningSumToCount.merge(runningSum, 1, Math::addExact);
        count += runningSumToCount.getOrDefault(runningSum - target, 0);
        countHelper(node.left, runningSum);
        countHelper(node.right, runningSum);
        runningSumToCount.computeIfPresent(runningSum, (k, v) -> v == 1 ? null : v - 1);
    }
}
