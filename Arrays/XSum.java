package guru.springframework.spring5webapp.leetcode.Arrays;

import java.util.*;

public class XSum {

    // Method to find the x-sum for each subarray of length k
    public static int[] findXSum(int[] nums, int k, int x) {
        int size = nums.length;
        int result[] = new int[size - k + 1]; // Result array for the x-sum of each subarray

        // Iterate over each subarray of length k
        for (int i = 0; i <= size - k; i++) {
            Map<Integer, Integer> frequencyMap = new HashMap<>();

            // Count the frequency of elements in the subarray
            for (int j = i; j < i + k; j++) {
                frequencyMap.put(nums[j], frequencyMap.getOrDefault(nums[j], 0) + 1);
            }

            // Create a list from the frequency map and sort it by frequency (and value if needed)
            List<Map.Entry<Integer, Integer>> frequencyList = new ArrayList<>(frequencyMap.entrySet());
            frequencyList.sort((a, b) -> {
                int compare = b.getValue().compareTo(a.getValue());
                return compare != 0 ? compare : b.getKey().compareTo(a.getKey());
            });

            // Select the top x elements
            int xSum = 0;
            for (int j = 0; j < Math.min(x, frequencyList.size()); j++) {
                int element = frequencyList.get(j).getKey();
                int frequency = frequencyList.get(j).getValue();
                xSum += element * frequency; // Add element value multiplied by its frequency
            }


            // Store the result for the current subarray
            result[i] = xSum;
        }

        return result;
    }

    public static void main(String[] args) {
        // Test case
        int nums[] = {1, 1, 2, 2, 3, 4, 2, 3};
        int k = 6;
        int x = 2;

        // Find and print the x-sum for each subarray
        int[] result = findXSum(nums, k, x);
        System.out.println(Arrays.toString(result)); // Expected Output: [6, 10, 12]
    }
}
