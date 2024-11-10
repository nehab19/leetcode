package guru.springframework.spring5webapp.leetcode.binarytrees;

public class PreOrder {
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}
