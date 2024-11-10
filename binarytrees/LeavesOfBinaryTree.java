package guru.springframework.spring5webapp.leetcode.binarytrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeavesOfBinaryTree {
    private Map<Integer, List<Integer>> mp = new HashMap<>();

    public List<List<Integer>> findLeaves(TreeNode root) {
        mp.clear();
        List<List<Integer>> result=new ArrayList<>();
        collectNodesWithHeight(root);
        for(List<Integer> nodes:mp.values()){
            result.add(nodes);
        }
        return result;

    }

    private int collectNodesWithHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = collectNodesWithHeight(root.left);
        int rightHeight = collectNodesWithHeight(root.right);
        int height = 1 + Math.max(leftHeight, rightHeight);
        mp.computeIfAbsent(height,k->new ArrayList<>()).add(root.val);
        return height;
    }
}
