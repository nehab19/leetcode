package guru.springframework.spring5webapp.leetcode.binarytrees;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MinDepth {
    int minDepthBFS(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return 1;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int depth=1;

        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode currentNode=queue.poll();

                if(currentNode.left==null && currentNode.right==null){
                    return depth;
                }
                if(currentNode.left!=null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.offer(currentNode.right);
                }
            }
            depth++;
        }
        return -1;
    }
    int minDepthDFS(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return 1;
        }
        int left=root.left!=null ? minDepthDFS(root.left) : Integer.MAX_VALUE;
        int right=minDepthDFS(root.right);

        return 1 + Math.min(left,right);
    }
}




