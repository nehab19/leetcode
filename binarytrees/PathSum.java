package guru.springframework.spring5webapp.leetcode.binarytrees;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result =new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        collectPath(root,targetSum,0,temp,result);
        return result;
    }

    private void collectPath(TreeNode root, int targetSum,int sum, List<Integer> temp, List<List<Integer>> result) {
        if(root==null){
            return;
        }
        temp.add(root.val);
        sum=sum+root.val;

        if(root.left==null && root.right==null && targetSum==sum){
            result.add(new ArrayList<>(temp));
        }
        collectPath(root.left,targetSum,sum,temp,result);
        collectPath(root.right,targetSum,sum,temp,result);
        temp.remove(temp.size()-1);
    }
}

