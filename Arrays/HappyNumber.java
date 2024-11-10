package guru.springframework.spring5webapp.leetcode.Arrays;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }

    private static int getNextNumber(int n) {
        int totalSum = 0;
        while (n > 0) {
            int digit = n % 10;
            totalSum = totalSum + (digit * digit);
            n = n / 10;
        }
        return totalSum;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}
