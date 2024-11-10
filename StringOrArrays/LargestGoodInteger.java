package guru.springframework.spring5webapp.leetcode.StringOrArrays;

public class LargestGoodInteger {

    static String goodInteger(String num) {
        char maxCharacter = ' ';
        for (int i = 2; i < num.length(); i++) {
            if (num.charAt(i) == num.charAt(i - 1) && num.charAt(i) == num.charAt(i - 2)) {
                maxCharacter = (char) Math.max(maxCharacter, num.charAt(i));
            }
        }
        return maxCharacter == ' ' ? " " : new String(new char[]{maxCharacter, maxCharacter, maxCharacter});
    }

    public static void main(String[] args) {
        String num = "6777133339";
        System.out.println(goodInteger(num));
    }
}
