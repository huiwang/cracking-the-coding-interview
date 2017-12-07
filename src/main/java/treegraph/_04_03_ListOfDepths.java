package treegraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class _04_03_ListOfDepths {

    //time o(N) space o(N)
    List<LinkedList<Integer>> create(BinaryTreeNode node) {
        List<LinkedList<Integer>> result = new ArrayList<>();
        dfs(result, node, 0);
        return result;
    }

    private void dfs(List<LinkedList<Integer>> result, BinaryTreeNode node, int depth) {
        if (node == null) return;
        if (result.size() == depth) {
            result.add(new LinkedList<>());
        }
        result.get(depth).add(node.val);
        dfs(result, node.left, depth + 1);
        dfs(result, node.right, depth + 1);
    }
}
