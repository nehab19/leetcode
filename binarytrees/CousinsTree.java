package guru.springframework.spring5webapp.leetcode.binarytrees;

import java.util.Arrays;

public class CousinsTree {
    public static TreeNode replaceValueInTree(TreeNode root) {
        replaceValues(new TreeNode[]{root});
        return root;
    }

    private static void replaceValues(TreeNode[] array) {
        if (array.length == 0) {
            return;
        }
        int sum = 0;
        for (TreeNode node : array) {
            if (node.left != null) {
                sum = sum + node.left.val;
            }
            if (node.right != null) {
                sum = sum + node.right.val;
            }
        }

        TreeNode[] childArray = new TreeNode[array.length * 2];
        int index = 0;

        for (TreeNode node : array) {
            int currentSum = 0;
            if (node.left != null) {
                currentSum = currentSum + node.left.val;
            }
            if (node.right != null) {
                currentSum = currentSum + node.right.val;
            }
            if (node.left != null) {
                node.left.val = sum - currentSum;
                childArray[index++] = node.left;
            }
            if (node.right != null) {
                node.right.val = sum - currentSum;
                childArray[index++] = node.right;
            }
        }
        replaceValues(Arrays.copyOf(childArray, index));


    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(9);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(10);
        treeNode.right.right = new TreeNode(7);
        replaceValueInTree(treeNode);
    }
}
