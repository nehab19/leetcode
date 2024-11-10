package guru.springframework.spring5webapp.leetcode.binarytrees;

import org.apache.commons.lang3.tuple.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidth {

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<Pair<TreeNode, Long>> queue = new LinkedList<>();
        queue.offer(Pair.of(root, 0L));
        long maxWidth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            long first = queue.peek().getValue();
            long last = first; // initialise the last element as the first

            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Long> current = queue.poll();
                TreeNode currentNode = current.getKey();
                long currentIndex = current.getValue();

                last = currentIndex;
                if (currentNode.left != null) {
                    queue.offer(Pair.of(currentNode.left, 2 * currentIndex + 1));
                }
                if (currentNode.right != null) {
                    queue.offer(Pair.of(currentNode.right, 2 * currentIndex + 2));
                }

            }
            maxWidth = Math.max(maxWidth, last - first + 1);
        }
        return (int) maxWidth;
    }

}
