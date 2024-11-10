package guru.springframework.spring5webapp.leetcode.binarytrees;

public class CountNodes {
    int countNodes(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftTree=leftHeight(root);
        int rightTree=rightHeight(root);
        if(leftTree==rightTree){
            return (int) (Math.pow(2,leftTree)-1);
        }
        return 1+ countNodes(root.left) + countNodes(root.right);
    }

    private int rightHeight(TreeNode root) {
        if(root==null){
            return 0;
        }
        int rightNodeHeight=0;
        TreeNode temp=root;
        while(temp!=null){
            temp=temp.right;
            rightNodeHeight++;
        }
        return rightNodeHeight;
    }

    private int leftHeight(TreeNode root) {
        if (root==null){
            return 0;
        }
        int leftNodeHeight=0;
        TreeNode temp=root;
        while(temp!=null){
            temp=temp.left;
            leftNodeHeight++;
        }
        return leftNodeHeight;
    }
}
