package guru.springframework.spring5webapp.leetcode.binarytrees;

public class Fliptree {
    public static boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return treeChecker(root1,root2);
    }

    private static boolean treeChecker(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }
        return ((treeChecker(root1.left, root2.left)) || (treeChecker(root1.left, root2.right)))
                && ((treeChecker(root1.right, root2.left)) || (treeChecker(root1.right, root2.right)));
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(3);
        treeNode1.right = new TreeNode(2);
        System.out.println(flipEquiv(treeNode,treeNode1));

    }
}
