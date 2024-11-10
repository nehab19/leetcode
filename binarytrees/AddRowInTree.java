package guru.springframework.spring5webapp.leetcode.binarytrees;

public class AddRowInTree {
    public TreeNode addOneRow(TreeNode root, int val, int depth){
        if(depth==1){
            TreeNode treeNode=new TreeNode(val);
            treeNode.left=root;
            return treeNode;
        }
        return addNode(root,val,depth,1);
    }

    private TreeNode addNode(TreeNode root, int val, int depth, int currentNode) {
        if(root==null){
            return null;
        }
        if(currentNode==depth-1){
            TreeNode tempLeft=root.left;
            TreeNode tempRight=root.right;
            root.left=new TreeNode(val);
            root.right=new TreeNode(val);
            root.left.left=tempLeft;
            root.right.right=tempRight;
            return root;
        }
        root.left=addNode(root.left,val,depth,currentNode+1);
        root.right=addNode(root.right,val,depth,currentNode+1);
        return root;
    }

}
