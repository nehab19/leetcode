package guru.springframework.spring5webapp.leetcode.dynamicprogramming;

import java.util.Arrays;

public class HouseRobberII {
    private int[] memo = new int[101];

    //recusrion  memoisation
    public int rob(int[] nums) {
       /* for(int i=0;i<101;i++){
            memo[i]=-1;
        }*/
        Arrays.fill(memo, -1);
        int size = nums.length;
        if (size == 1) {
            return nums[0];
        }
        //case: when we take 0th index and can't take last one
        int take_first_index_house = solve(nums, 0, size - 2);
        //case : when we don't take 1st index and proceed
        Arrays.fill(memo, -1);
        int not_take_first_index_house = solve(nums, 1, size - 1);
        return Math.max(take_first_index_house, not_take_first_index_house);
    }

    private int solve(int[] nums, int i, int size) {
        if (i >= size) {
            return 0;
        }
        //check if present
        if (memo[i] != -1) {
            return memo[i];
        }
        //if they can steal the ith position
        int steal = nums[i] + solve(nums, i + 2, size);
        int skip = solve(nums, i + 1, size);
        memo[i] = Math.max(steal, skip);
        return memo[i];
    }
}
