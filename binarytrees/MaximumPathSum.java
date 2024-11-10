package guru.springframework.spring5webapp.leetcode.binarytrees;

public class MaximumPathSum {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        findMaxSum(root);
        return maxSum;
    }

    private int findMaxSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftTree = findMaxSum(root.left);
        int rightTree = findMaxSum(root.right);
        int dono_achee_hai = leftTree + rightTree + root.val;
        int koi_ek_achaa_hai = Math.max(leftTree, rightTree) + root.val;
        int only_root_achaa_hai = root.val;
        maxSum = Math.max(maxSum, Math.max(dono_achee_hai, Math.max(koi_ek_achaa_hai, only_root_achaa_hai)));
        return Math.max(koi_ek_achaa_hai, only_root_achaa_hai);
    }
}
