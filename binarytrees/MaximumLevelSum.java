package guru.springframework.spring5webapp.leetcode.binarytrees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaximumLevelSum {
    int maxLevelSumApproachBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxSum = Integer.MIN_VALUE;
        int resultLevel = 0;
        int currentLevel = 1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                sum = sum + currentNode.val;

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            if (sum > maxSum) {
                maxSum = sum;
                resultLevel = currentLevel;
            }
            currentLevel++;
        }
        return resultLevel;
    }

    Map<Integer, Integer> map = new HashMap<>();

    int maxLevelSumApproachDFS(TreeNode root) {
        DFS(root, 1);
        int maxSum = Integer.MIN_VALUE;
        int resultLevel = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int level = entry.getKey();
            int sum = entry.getValue();

            if (sum > maxSum) {
                maxSum = sum;
                resultLevel = level;
            }
        }
        return resultLevel;
    }

    private void DFS(TreeNode root, int currentLevel) {
        if (root == null) {
            return;
        }
        map.put(currentLevel, map.getOrDefault(currentLevel, 0) + root.val);
        DFS(root.left, currentLevel + 1);
        DFS(root.right, currentLevel + 1);
    }
}
