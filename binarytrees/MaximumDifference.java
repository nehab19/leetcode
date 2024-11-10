package guru.springframework.spring5webapp.leetcode.binarytrees;

public class MaximumDifference {
    int maximumDifference;
    public int maxAncestorDiff(TreeNode root){
        maximumDifference=-1;
        maxAncestor(root);
        return maximumDifference;
    }

    public void maxAncestor(TreeNode root){
        if(root==null || root.left==null && root.right==null){
            return;
        }
        findDifference(root,root.left);
        findDifference(root,root.right);
        maxAncestorDiff(root.left);
        maxAncestorDiff(root.right);

    }


    private void findDifference(TreeNode root, TreeNode child) {
        if(root==null || child==null){
            return;
        }
        maximumDifference=Math.max(maximumDifference,Math.abs(root.val-child.val));
        findDifference(root,child.left);
        findDifference(root,child.right);
    }




    public int maxAncestorDiffApproach2(TreeNode root){
       int minValue=root.val;
       int maxValue=root.val;
       return findAncestor(root,minValue,maxValue);

    }

    private int findAncestor(TreeNode root, int minValue, int maxValue) {
        if(root==null){
            return Math.abs(maxValue-minValue);
        }
        maxValue=Math.max(maxValue,root.val);
        minValue=Math.min(minValue,root.val);

        int leftTree=findAncestor(root.left,minValue,maxValue);
        int rightTree=findAncestor(root.right,minValue,maxValue);
        return Math.max(rightTree,leftTree);
    }
}
