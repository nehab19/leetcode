package guru.springframework.spring5webapp.leetcode.strings;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int number=target- nums[i];
            if(map.containsKey(number)){
                return  new int[]{map.get(number),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}
