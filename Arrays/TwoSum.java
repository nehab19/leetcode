package guru.springframework.spring5webapp.leetcode.Arrays;

import java.util.HashMap;

public class TwoSum {
    public static int[] findTwoSum(int[] arr, int target) {
        // Create a hash map to store numbers and their indices
        HashMap<Integer, Integer> map = new HashMap<>();

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];

            // If the complement exists in the map, return the indices
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // Add the current number to the map
            map.put(arr[i], i);
        }

        // If no solution is found, return an empty array
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] arr = { 2, 7, 11, 15 };
        int target = 9;

        int[] result = findTwoSum(arr, target);

        if (result.length > 0) {
            System.out.println("Indices of the two numbers whose sum is " + target + " are: " + result[0] + " and " + result[1]);
        } else {
            System.out.println("No two numbers found with the given sum.");
        }
    }
}
