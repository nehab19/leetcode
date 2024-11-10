package guru.springframework.spring5webapp.leetcode.binarytrees;

public class MaximumProduct {
    int maximumProduct = 0;
    int totalSum = 0;

    private int totalSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftTree = totalSum((root.left));
        int rightTree = totalSum((root.right));
        return root.val + leftTree + rightTree;
    }

    private int findProduct(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftTreeProduct = findProduct(root.left);
        int rightTreeProduct = findProduct(root.right);
        int subTreeSum = root.val + leftTreeProduct + rightTreeProduct;
        int remainingSubTreeProduct = totalSum - subTreeSum;
        maximumProduct = Math.max(maximumProduct, remainingSubTreeProduct * subTreeSum);
        return subTreeSum;
    }

    public int maxProduct(TreeNode root) {
        if (root == null) {
            return 0;
        }
        totalSum = totalSum(root);
        findProduct(root);
        return maximumProduct;

    }

}
