package guru.springframework.spring5webapp.leetcode.StringOrArrays;

import java.util.HashMap;

public class FindDifference {

    public static char findTheDifference(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : t.toCharArray()) {
            if (!map.containsKey(ch)) {
                return ch;
            }
           /* map.put(ch, map.getOrDefault(ch,0)-1);
            if(map.get(ch) ==map.){
                return ch;
            }*/
        }
        return 'X';
    }

    public static char findTheDifference1(String s, String t) {
        int sum_s = 0;
        for (char ch : s.toCharArray()) {
            sum_s = sum_s + ch;
        }
        int sum_t = 0;
        for (char ch : t.toCharArray()) {
            sum_t = sum_t + ch;
        }
        return (char) ((char) sum_t - sum_s);
    }

    public static char findTheDifference3(String s, String t) {
        int xor = 0;
        for (char ch : s.toCharArray()) {
            xor = xor ^ ch;
            System.out.println(xor);
        }
        for (char ch : t.toCharArray()) {
           xor=xor ^ ch;
        }
        return (char)xor;
    }


    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        // System.out.println(findTheDifference(s,t));
        //System.out.println(findTheDifference1(s, t));
        System.out.println(findTheDifference3(s,t));
       /* List<String> collect = Arrays.stream(s.split("")).collect(Collectors.toList());
        List<String> collect1 = Arrays.stream(t.split("")).collect(Collectors.toList());
        List<String> collect2 = collect1.stream().filter(element -> !collect.contains(element)).collect(Collectors.toList());
        String element=collect2.get(0);
        char ch = element.substring(0, 1).charAt(0);
        System.out.println(ch);*/

    }
}
