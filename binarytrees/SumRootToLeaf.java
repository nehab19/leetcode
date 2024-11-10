package guru.springframework.spring5webapp.leetcode.binarytrees;

public class SumRootToLeaf {
    public int sumNumbers(TreeNode root) {
        return sumNumberToLeaf(root, 0);
    }

    private int sumNumberToLeaf(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return sum * 10 + root.val;
        }
        int leftTree = sumNumberToLeaf(root.left, sum * 10 + root.val);
        int rightTree = sumNumberToLeaf(root.right, sum * 10 + root.val);
        return leftTree + rightTree;
    }
}
