package guru.springframework.spring5webapp.leetcode.StringOrArrays;

import java.util.ArrayList;
import java.util.List;

public class MaximumCandies {
    static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maximum = 0;
        for (int candy : candies) {
            maximum = Math.max(maximum, candy);
        }
        List<Boolean> result = new ArrayList<>();
        for (int candy : candies) {
            result.add(candy + extraCandies >= maximum);
        }
        return result;
    }

    public static void main(String[] args) {
        int [] array= new int[]{2,3,5,1,3};
        System.out.println(kidsWithCandies(array,3));
    }
}
