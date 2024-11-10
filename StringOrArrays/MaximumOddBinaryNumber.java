package guru.springframework.spring5webapp.leetcode.StringOrArrays;

public class MaximumOddBinaryNumber {
    public static String maximumOddBinaryNumberApproach1(String s) {
        int n = s.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int k = 0; k < n; k++) {
            stringBuilder.append('0');
        }
        int i = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                if (stringBuilder.charAt(n - 1) == '1') {
                    stringBuilder.setCharAt(i, '1');
                    i++;
                } else {
                    stringBuilder.setCharAt(n - 1, '1');
                }
            }
        }
        return stringBuilder.toString();
    }

    public static String maximumOddBinaryNumberApproach2(String s) {
        int n = s.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int k = 0; k < n; k++) {
            stringBuilder.append('0');
        }
        int countOnes = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                countOnes++;
            }
        }

        int j = 0;
        while (countOnes > 1) {
            stringBuilder.setCharAt(j, '1');
            j++;
            countOnes--;
        }
        stringBuilder.setCharAt(n - 1, '1');
        return stringBuilder.toString();

    }

    public static void main(String[] args) {
        System.out.println(maximumOddBinaryNumberApproach1("0101"));
        //System.out.println(maximumOddBinaryNumberApproach2("0101"));
    }
}
