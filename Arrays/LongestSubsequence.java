package guru.springframework.spring5webapp.leetcode.Arrays;

import java.util.HashSet;

public class LongestSubsequence {
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longestSubstring = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int length = 1;
                while (set.contains(num + length)) {
                    length++;
                }
                longestSubstring = Math.max(longestSubstring, length);
            }
        }
        return longestSubstring;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
