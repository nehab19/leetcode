package guru.springframework.spring5webapp.leetcode.Arrays;
//Given an integer array nums and an integer k, return true if there are two distinct
// indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
//Input: nums = [1,2,3,1], k = 3
//Output: true

import java.util.HashMap;
import java.util.Map;

public class ContainDuplicateII {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (map.containsKey(value) && i - map.get(value) <= k) {
                return true;
            }
            map.put(value, i);
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }
}
