package guru.springframework.spring5webapp.leetcode.StringOrArrays;

import java.util.Arrays;

public class DivideArray {
    public static int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int[][] result = new int[n / 3][3];
        int index=0;
        for (int i = 0; i <= n - 3; i = i + 3) {
            if(nums[i+2]-nums[i]<=k){
                result[index]=new int[]{nums[i],nums[i+1],nums[i+2]};
                index++;

            }else{
                return new int[0][0];
            }
        }
        return result;

    }

    public static void main(String[] args) {
        // Example 1
        int[] nums = {1, 3, 4, 8, 7, 9, 3, 5, 1};
        int k = 2;

        // Call the divideArray method
        int[][] result = divideArray(nums, k);

        // Print the result
        if (result.length == 0) {
            System.out.println("[]");
        } else {
            System.out.println(Arrays.deepToString(result));
        }
    }
}
