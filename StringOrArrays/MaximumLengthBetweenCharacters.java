package guru.springframework.spring5webapp.leetcode.StringOrArrays;

import java.util.HashMap;

public class MaximumLengthBetweenCharacters {
    static int maxLengthBetweenEqualCharactersApproach1(String s) {
        int result = -1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    result = Math.max(result, j - i - 1);
                }
            }
        }
        return result;
    }

    static int maxLengthBetweenEqualCharactersApproach2(String s) {
        int result = -1;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!hashMap.containsKey(ch)) {
                hashMap.put(ch, i);
            } else {
                result = Math.max(result, i - hashMap.get(ch) - 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxLengthBetweenEqualCharactersApproach1("abcda"));
        System.out.println(maxLengthBetweenEqualCharactersApproach2("abcda"));
    }
}
