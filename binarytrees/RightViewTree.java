package guru.springframework.spring5webapp.leetcode.binarytrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Tree {
    int val;
    Tree left;
    Tree right;

    Tree(int x) {
        val = x;
    }
}

public class RightViewTree {
    public List<Integer> rightSideView(Tree root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Tree> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            Tree rightNode = null;
            for (int i = 0; i < n; i++) {
                rightNode = queue.poll();
                if (rightNode.left != null) {
                    queue.offer(rightNode.left);
                }
                if (rightNode.right != null) {
                    queue.offer(rightNode.right);
                }
            }
            result.add(rightNode.val);
        }
        return result;
    }
    public List<Integer> rightSideViewDFS(Tree root){
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        preOrder(root,1,result);
        return result;
    }
    public void preOrder(Tree root, int level, List<Integer>result){
        if (root==null){
            return;
        }
        if(result.size()<level){
            result.add(root.val);
        }
        preOrder(root.right,level+1,result);
        preOrder(root.left,level+1,result);
    }
}
