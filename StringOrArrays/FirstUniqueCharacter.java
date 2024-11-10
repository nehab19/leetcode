package guru.springframework.spring5webapp.leetcode.StringOrArrays;

public class FirstUniqueCharacter {
    public static int firstUniqChar(String s) {
        int[] array = new int[26];
        for (char ch : s.toCharArray()) {
            array[ch - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (array[s.charAt(i) - 'a'] == 1) {
                return i;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }

}
