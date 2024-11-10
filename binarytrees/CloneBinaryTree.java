package guru.springframework.spring5webapp.leetcode.binarytrees;

public class CloneBinaryTree {
   public TreeNode createClone(TreeNode root){
       if(root==null){
           return null;
       }
        TreeNode treeNode=new TreeNode(root.val);
       treeNode.left=createClone(root.left);
       treeNode.right=createClone(root.right);
       return treeNode;
    }
}
