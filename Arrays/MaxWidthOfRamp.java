package guru.springframework.spring5webapp.leetcode.Arrays;

import java.util.Stack;

public class MaxWidthOfRamp {
        public int maxWidthRamp(int[] nums) {
            int n = nums.length;
            Stack<Integer> stack = new Stack<>();

            // Step 1: Build a stack with decreasing values' indices
            for (int i = 0; i < n; i++) {
                if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                    stack.push(i);
                }
            }

            int maxWidth = 0;

            // Step 2: Traverse from right to left to find the maximum ramp
            for (int j = n - 1; j >= 0; j--) {
                while (!stack.isEmpty() && nums[stack.peek()] <= nums[j]) {
                    // Calculate the width of the ramp and update maxWidth
                    maxWidth = Math.max(maxWidth, j - stack.pop());
                }
            }

            return maxWidth;
        }

        public static void main(String[] args) {
            MaxWidthOfRamp maxWidthOfRamp = new MaxWidthOfRamp();

          /*  int[] nums1 = {6, 0, 8, 2, 1, 5};
            System.out.println("Maximum Width of Ramp: " + maxWidthOfRamp.maxWidthRamp(nums1));  // Output: 4*/

            int[] nums2 = {9, 8, 1, 0, 1, 9, 4, 0, 4, 1};
            System.out.println("Maximum Width of Ramp: " + maxWidthOfRamp.maxWidthRamp(nums2));  // Output: 7
        }
    }

