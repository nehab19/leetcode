package guru.springframework.spring5webapp.leetcode.binarytrees;

public class NodesEqualToAverage {
    private static int result = 0;

    public static int averageOfSubtree(TreeNode root) {
        solve(root);
        return result;
    }

    private static void solve(TreeNode root) {
        if (root == null) {
            return;
        }
        int[] count = {0};
        int totalSum = findSum(root, count);
        if (totalSum / count[0] == root.val) {
            result++;
        }
        solve(root.left);
        solve(root.right);

    }

    private static int findSum(TreeNode root, int[] count) {
        if(root==null){
            return 0;
        }
        count[0]++;
        int leftSum=findSum(root.left,count);
        int rightSum=findSum(root.right,count);
        return leftSum+rightSum+ root.val;
    }

    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode();
        treeNode.left=new TreeNode(8);
        treeNode.right=new TreeNode(5);
        treeNode.left.left=new TreeNode(0);
        treeNode.left.right=new TreeNode(1);
        treeNode.right.right=new TreeNode(6);
        System.out.println(averageOfSubtree(treeNode));

    }
}
