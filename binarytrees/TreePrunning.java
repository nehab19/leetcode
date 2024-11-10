package guru.springframework.spring5webapp.leetcode.binarytrees;

/**
 * Remove subtree if it does not have one
 **/
public class TreePrunning {
    public TreeNode pruneTreeApproach1(TreeNode root) {
        if(root==null){
            return null;
        }
        pruneTreeApproach1(root.left);
        pruneTreeApproach1(root.right);
        /** if it does not contain one make its left and right child as null **/
        if(!checkOne(root.left)){
            root.left=null;
        }
        if(!checkOne(root.right)){
            root.right=null;
        }
        if(root.left==null && root.right==null && root.val==0){
            return null;
        }
        return root;
    }

    private boolean checkOne(TreeNode root) {
        if(root==null){
            return false;
        }
        if(root.val==1){
            return true;
        }
        return checkOne(root.left) || checkOne(root.right);
    }

    public TreeNode pruneTreeApproach2(TreeNode root) {
        if(root==null){
            return null;
        }
        pruneTreeApproach1(root.left);
        pruneTreeApproach1(root.right);
        if(root.left==null && root.right==null && root.val==0){
            return null;
        }
        return root;
    }
}
