package guru.springframework.spring5webapp.leetcode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
            int j=i+1;
            int k=nums.length-1;

            while(j<k){
                int total= nums[i] + nums[j] + nums[k];

                if(total > 0){
                    k--;
                }else if(total < 0){
                    j++;
                }else{
                    result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    // as to not get the repeat element again
                    while(nums[j]==nums[j-1]){
                        j++;
                    }
                }
            }
        }
        return result;
    }
}
