package guru.springframework.spring5webapp.leetcode.binarytrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PerfectSubTree {
    private List<Integer> perfectSizes;

    // Helper method for DFS traversal
    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 1}; // Height, IsPerfect
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        // Check if current node forms a perfect binary subtree
        if (left[1] == 1 && right[1] == 1 && left[0] == right[0]) {
            int currentHeight = left[0] + 1;
            int size = (int) Math.pow(2, currentHeight + 1) - 1; // Size of perfect binary tree
            perfectSizes.add(size);
            return new int[]{currentHeight, 1}; // Return height and is perfect
        }

        return new int[]{Math.max(left[0], right[0]) + 1, 0}; // Return height and not perfect
    }

    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        perfectSizes = new ArrayList<>();
        dfs(root);

        // If no perfect subtrees found
        if (perfectSizes.isEmpty()) return -1;

        // Sort sizes in descending order
        Collections.sort(perfectSizes, Collections.reverseOrder());

        // Check if k is valid
        if (k > perfectSizes.size())
            return -1;

        return perfectSizes.get(k - 1); // Return the size of kth largest
    }

    public static void main(String[] args) {
        // Constructing the binary tree from the example
        // Input: [5, 3, 6, 5, 2, 5, 7, 1, 8, null, null, 6, 8]
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(8);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(8);

        int k = 3; // Change k as needed

        PerfectSubTree solution = new PerfectSubTree();
        int result = solution.kthLargestPerfectSubtree(root, k);
        System.out.println(result); // Output: Size of the kth largest perfect binary subtree or -1
    }
}
