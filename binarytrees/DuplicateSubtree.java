package guru.springframework.spring5webapp.leetcode.binarytrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateSubtree {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        DFS(root, result, map);
        return result;
    }

    private String DFS(TreeNode root, List<TreeNode> result, Map<String, Integer> map) {
        if (root == null) {
            return "null";
        }
        String subTreeString = root.val + "," + DFS(root.left, result, map) + "," + DFS(root.right, result, map);
        map.put(subTreeString, map.getOrDefault(subTreeString, 0) + 1);
        if (map.get(subTreeString) == 2) {
            result.add(root);
        }
        return subTreeString;

    }
}
