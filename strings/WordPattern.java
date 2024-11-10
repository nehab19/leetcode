package guru.springframework.spring5webapp.leetcode.strings;

import java.util.HashMap;
import java.util.Objects;

public class WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        int patternLength = pattern.length();
        int stringLength = s.split(" ").length;
        String[] stringSplit = s.split(" ");
        if (patternLength != stringLength) {
            return false;
        }
        int i = 0;
        HashMap<Character, String> map = new HashMap<>();
        for (char ch : pattern.toCharArray()) {
            if (map.containsKey(ch)) {
                if (!Objects.equals(map.get(ch), stringSplit[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(stringSplit[i])) {
                    return false;
                }
                map.put(ch, stringSplit[i]);
            }
            i++;
        }

        return true;

    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
    }
}
