package guru.springframework.spring5webapp.leetcode.binarytrees;

public class PreInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int start=0;
        int end=inorder.length;
        int [] index={0};
        return solve(preorder,inorder,start,end-1,index);
    }
    public TreeNode solve(int[] preorder, int[] inorder,int start,int end,int[] index){
        if(start>end){
            return null;
        }
        int rootValue=preorder[index[0]];
        int i=start;
        for(;i<=end;i++){
            if(rootValue==inorder[i]){
                break;
            }
        }
        index[0]++;
        TreeNode root=new TreeNode(rootValue);
        root.left=solve(preorder,inorder,start,i-1,index);
        root.right=solve(preorder,inorder,i+1,end,index);
        return root;
    }
}
