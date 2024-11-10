package guru.springframework.spring5webapp.leetcode.StringOrArrays;

import java.util.Arrays;

public class MaxFrequency {

    public static int maxFrequencyElements(int[] nums) {
        int maxFrequency = 0;
        int[] array = new int[101];

        for (int number : nums) {
            array[number]++;
            maxFrequency = Math.max(maxFrequency, array[number]);
        }
        final int maxFreq = maxFrequency;
        long count1 = Arrays.stream(array).filter(count -> count == maxFreq).count();
        return (int) (Arrays.stream(array).filter(count -> count == maxFreq).count() * maxFreq);
    }
    public static int maxFrequencyElementsApproach2(int[] nums) {
        int [] array=new int[101];
        int total=0;
        int maxFrequency=0;
        for(int num: nums){
            array[num]++;

            int frequency=array[num];
            if(frequency> maxFrequency){
                maxFrequency=frequency;
                total=frequency;
            }else if(frequency==maxFrequency){
                total=total+frequency;
            }
        }
        return total;
    }

    public static void main(String[] args) {
       System.out.println(maxFrequencyElements(new int[]{1,2,2,3,4,5}));
        //System.out.println(maxFrequencyElementsApproach2(new int[]{1,2,2,3,1,4}));
    }
}
