package guru.springframework.spring5webapp.leetcode.binarytrees;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root){
        if(root==null){
            return true;
        }
        return checkSymmeteric(root.left,root.right);
    }

    private boolean checkSymmeteric(TreeNode rootLeft,TreeNode rootRight) {
        if(rootLeft==null && rootRight==null){
            return true;
        }
        if(rootLeft==null || rootRight==null){
            return false;
        }

        if(rootLeft.val == rootRight.val && checkSymmeteric(rootLeft.left,rootRight.right) && checkSymmeteric(rootLeft.right,rootRight.left)){
            return true;
        }
        return false;
    }
}
