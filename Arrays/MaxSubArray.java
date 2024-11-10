package guru.springframework.spring5webapp.leetcode.Arrays;

// int[] arr = {1, 0, 1, 1, 1, 0, 1, 1, 1, 1};
// find the max sub aaray with has 1 surrounded by 0
// eg in this 0,1,1,1,0 -> we have 1 surrounded by 0 then return how many ones -> 3
public class MaxSubArray {
    public static int findMaxSubarrayOfOnes(int[] arr) {
        int size = arr.length;
        int maxLength = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] == 0) {
                int j = i + 1;
                while (j < size && arr[j] == 1) {
                    j++;
                }
                if (j < size && arr[j] == 0) {
                    maxLength = Math.max(maxLength, j - i - 1);
                }
                i = j - 1; // to skip the subarrays formed
            }
        }
        return maxLength;

    }
}
