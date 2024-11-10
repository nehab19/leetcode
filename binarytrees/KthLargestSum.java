package guru.springframework.spring5webapp.leetcode.binarytrees;

import java.util.*;

public class KthLargestSum {
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> result=new ArrayList<>();
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                sum = sum + currentNode.val;

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            result.add(sum);

        }
        if(k>result.size()){
            return -1;
        }
        result.sort(Collections.reverseOrder());//descending order
        return result.get(k-1);

    }

}
