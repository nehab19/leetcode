package guru.springframework.spring5webapp.leetcode.StringOrArrays;

import java.util.HashSet;
import java.util.Set;

public class MinimumCommonValue {
    public static int getCommon(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int i = 0;
        int j = 0;

        while (i < m && j < n) {
            if (nums1[i] == nums2[j]) {
                return nums1[i];
            } else if (nums1[i]> nums2[j]) {
                j++;
            }else{
                i++;
            }
        }
        return -1;
    }
    public static int get(int [] nums1,int []nums2){
        Set<Integer> set=new HashSet<>();
        for(int num : nums1){
            set.add(num);
        }
        int result=-1;
        for(int num :nums2){
            if(set.contains(num)){
                result=Math.min(result, num);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getCommon(new int[]{1,2,3}, new int[]{1,2,4}));
    }
}
