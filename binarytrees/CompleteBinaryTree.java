package guru.springframework.spring5webapp.leetcode.binarytrees;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        boolean hasPastNull=false;
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(node==null){
                hasPastNull=true;
            }else{
                if(hasPastNull){
                    return false;
                }
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return true;

    }
}
