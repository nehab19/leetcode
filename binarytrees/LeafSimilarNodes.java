package guru.springframework.spring5webapp.leetcode.binarytrees;

public class LeafSimilarNodes {
    public boolean leafSimilar(TreeNode root1, TreeNode root2){
        StringBuilder tree1=new StringBuilder("");
        StringBuilder tree2=new StringBuilder("");
        inOrder(root1,tree1);
        inOrder(root2,tree2);
        if(tree1.compareTo(tree2) == 0){
            return true;
        }
        return false;
    }

    private void inOrder(TreeNode root, StringBuilder tree) {
        if(root==null){
            return ;
        }
        if(root.left==null && root.right==null){
            tree.append(root.val).append("_");
            return;
        }
        inOrder(root.left,tree);
        inOrder(root.right,tree);
    }
}
