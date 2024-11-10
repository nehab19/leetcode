package guru.springframework.spring5webapp.leetcode.StringOrArrays;

public class GCDStrings {
    static String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int gcd = gcd(str1.length(), str2.length());
        System.out.println(gcd);
        return str1.substring(0, gcd);
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        String string1 = "ABCABC";
        String string2 = "ABC";
        System.out.println(gcdOfStrings(string1, string2));
    }
}
