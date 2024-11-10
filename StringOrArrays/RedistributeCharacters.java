package guru.springframework.spring5webapp.leetcode.StringOrArrays;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RedistributeCharacters {
    public static boolean makeEqual(String[] words) {
        int frequency = words.length;
        System.out.println(frequency);
        Map<String, Long> collect = Arrays.stream(words).flatMap(character -> character.chars().mapToObj(c -> String.valueOf((char) c))).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);
        return collect.entrySet().stream().allMatch(character -> character.getValue() % frequency == 0);

    }

    public static void main(String[] args) {
        System.out.println(makeEqual(new String[]{"abc", "bc", "abc"}));
    }
}
