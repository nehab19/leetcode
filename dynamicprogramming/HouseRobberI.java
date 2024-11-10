package guru.springframework.spring5webapp.leetcode.dynamicprogramming;

public class HouseRobberI {
    private int[] memo = new int[101];

    public int rob(int[] nums) {
        int n = nums.length;
        return solve(nums, 0, n);
    }

    public int solve(int[] nums, int i, int n) {
        if (i >= n) {
            return 0;
        }
        int steal = nums[i] + solve(nums, i + 2, n);
        int skip = solve(nums, i + 1, n);
        return Math.max(steal, skip);
    }
//approach 2 : memoisation

    public int rob1(int[] nums) {
        for (int i = 0; i < 101; i++) {
            memo[i] = -1;
        }
        int n = nums.length;
        return solve(nums, 0, n);
    }

    public int solve1(int[] nums, int i, int n) {
        if (i >= n) {
            return 0;
        }
        //check if present
        if (memo[i] != -1) {
            return memo[i];
        }
        int steal = nums[i] + solve(nums, i + 2, n);
        int skip = solve(nums, i + 1, n);
        memo[i] = Math.max(steal, skip);
        return memo[i];
    }

    //approach : bottom up
    public int rob2(int[] nums) {
        int n = nums.length;

        //we have only one house to steal
        if(n==1){
            return nums[0];
        }
        int [] memo=new int[n+1];
        //we have no house
        memo[0]=0;
        // we have only one house profit
        memo[1]=nums[0];

        for(int i=2;i<=n;i++){
            //if we steal get the profit of i-1 and get stored array of i-2 that is not adjacent
            int steal=nums[i-1] + memo[i-2];
            int skip= memo[i-1];
            memo[i]=Math.max(steal,skip);
        }
        return memo[n];
    }
}
