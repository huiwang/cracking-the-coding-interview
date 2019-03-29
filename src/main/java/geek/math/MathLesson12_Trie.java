package geek.math;

import java.util.*;

public class MathLesson12_Trie {
    TreeNode root = new TreeNode(Character.MIN_VALUE, null, null);

    public void put(String word, String explaination) {
        TreeNode curr = root;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            curr = getSon(curr, c, true);
        };
        curr.explanation = explaination;
    }

    public TreeNode find(String word) {
        TreeNode found = null;
        char[] chars = word.toCharArray();
        TreeNode curr = root;
        for (char c : chars) {
            curr = getSon(curr, c, false);
            if (curr == null) {
                break;
            }
        }
        return curr;
    }

    private static TreeNode getSon(TreeNode parent, char c, boolean createIfNotFound) {
        TreeNode found = null;
        if (parent.sons != null && parent.sons.containsKey(c)) {
            found = parent.sons.get(c);
        } else if (createIfNotFound) {
            String prefix = parent.prefix == null ? "" : parent.prefix + parent.label;
            found = new TreeNode(c, prefix, null);
            parent.offer(found);
        }
        return found;
    }

    /**
     * Depth First Search to traverse the tree and print all words in order
     *
     * @return list of words
     */
    public List<String> dfsTraverse() {
        if (root == null) {
            return null;
        }
        return dfsWords(root);
    }

    private static List<String> dfsWords(TreeNode node) {
        if (node.sons == null || node.sons.isEmpty()) {
            // leave node, return it
            List<String> leaveWord = new ArrayList<>();
            if (node.label != Character.MIN_VALUE) {
                leaveWord.add(node.prefix + node.label);
            }
            return leaveWord;
        }
        List<String> results = new ArrayList<>();
        if (node.explanation != null) {
            results.add(node.prefix + node.label);
        }
        Character[] chars = node.sons.keySet().toArray(new Character[node.sons.size()]);
        Arrays.sort(chars);
        for (char c : chars) {
            results.addAll(dfsWords(node.sons.get(c)));
        }
        return results;
    }

    /**
     * traverse all nodes in order using stack
     *
     * @return
     */
    public List<String> dfsTraverseByStack() {
        if (root == null) {
            return null;
        }
        List<String> results = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node.explanation != null) {
                results.add(node.prefix + node.label);
            }
            if (node.sons == null || node.sons.isEmpty()) {
                continue;
            }
            Character[] chars = node.sons.keySet().toArray(new Character[node.sons.size()]);
            Arrays.sort(chars);
            for (int i = chars.length - 1; i >= 0; --i) {
                stack.push(node.sons.get(chars[i]));
            }
        }
        return results;
    }

    /**
     * BFS traverse
     *
     * @return
     */
    public List<String> bfsTraverse() {
        if (root == null) {
            return null;
        }
        List<String> results = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.explanation != null) {
                results.add(node.prefix + node.label);
            }
            if (node.sons == null || node.sons.isEmpty()) {
                continue;
            }
            Character[] chars = node.sons.keySet().toArray(new Character[node.sons.size()]);
            Arrays.sort(chars);
            for (char c : chars) {
                queue.offer(node.sons.get(c));
            }
        }
        return results;
    }

    @Override
    public String toString() {
        List<String> words = dfsTraverse();
        StringBuilder sb = new StringBuilder("Dictionary Words:\n");
        words.forEach(w -> sb.append("\t").append(w).append("\n"));
        sb.append("[END]\n");
        return sb.toString();
    }
}

class TreeNode {
    char label;
    HashMap<Character, TreeNode> sons;
    String prefix;
    String explanation;

    public TreeNode(char label, String prefix, String explanation) {
        this.label = label;
        this.prefix = prefix;
        this.explanation = explanation;
    }

    void offer(TreeNode node) {
        if (sons == null) {
            sons = new HashMap<>(26);
        }
        sons.put(node.label, node);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (label == Character.MIN_VALUE) {
            sb.append("[ROOT]\n");
        } else {
            sb.append("[").append(prefix).append(label).append("]");
            if (explanation != null) {
                sb.append(" - Explanation:").append(explanation);
            }
            sb.append("\n");
        }
        if (sons != null) {
            sons.keySet().stream().sorted().forEach(c -> sb.append(sons.get(c).toString()));
        }
        return sb.toString();
    }
}