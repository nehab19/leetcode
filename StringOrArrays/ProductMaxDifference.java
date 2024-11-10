package guru.springframework.spring5webapp.leetcode.StringOrArrays;

import java.util.Arrays;

public class ProductMaxDifference {
    public static int maxProductDifference(int[] nums){
        int n=nums.length;
        Arrays.sort(nums);
        return (nums[n-1]* nums[n-2] - (nums[0] * nums[1]));
    }
    public static void main(String[] args) {
        int[] nums=new int[]{3,7,6,1,2};
        System.out.println(maxProductDifference(nums));
    }
}
