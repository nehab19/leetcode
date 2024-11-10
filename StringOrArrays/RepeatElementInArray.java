package guru.springframework.spring5webapp.leetcode.StringOrArrays;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RepeatElementInArray {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5, 6, 3, 2, 7, 8, 9, 1};
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> integerList=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println(list.stream().distinct().sorted((a,b)->(b-a)).skip(1).findFirst().get());
        Map<Integer, Long> collect = Arrays.stream(array).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
       collect.entrySet().stream().filter(number->number.getValue() > 1).forEach(System.out::println);
    }
}
