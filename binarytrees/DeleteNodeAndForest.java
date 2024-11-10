package guru.springframework.spring5webapp.leetcode.binarytrees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodeAndForest {
    public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        Set<Integer> toDelete = new HashSet<>();
        for (int num : to_delete) {
            toDelete.add(num);
        }
        deleteHelper(root, toDelete, result);
        if (!toDelete.contains(root.val)) {
            result.add(root);
        }
        return result;
    }

    private static TreeNode deleteHelper(TreeNode root, Set<Integer> toDelete, List<TreeNode> result) {
        if (root == null) {
            return null;
        }
        root.left = deleteHelper(root.left, toDelete, result);
        root.right = deleteHelper(root.right, toDelete, result);
        if (toDelete.contains(root.val)) {
            if (root.left != null) {
                result.add(root.left);
            }
            if (root.right != null) {
                result.add(root.right);
            }
            return null;
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode();
        treeNode.left=new TreeNode(2);
        treeNode.right=new TreeNode(3);
        treeNode.left.left=new TreeNode(4);
        treeNode.left.right=new TreeNode(5);
        treeNode.right.left=new TreeNode(6);
        treeNode.right.right=new TreeNode(7);
        delNodes(treeNode,new int[]{3,5});
    }

}
