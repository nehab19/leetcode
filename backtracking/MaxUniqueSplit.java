package guru.springframework.spring5webapp.leetcode.backtracking;

import java.util.HashSet;

public class MaxUniqueSplit {

    private static int split(String s){
        return backtrackSplit(0,s,new HashSet<>());
    }
    private static int backtrackSplit(int start, String s,HashSet<String>subStringVisited) {
        if (start == s.length()) {
            return 0;
        }
        int maxSplits = 0;
        for (int end = start + 1; end <=s.length(); end++) {
            String subString = s.substring(start, end);
            if (!subStringVisited.contains(subString)) {
                subStringVisited.add(subString);
                maxSplits = Math.max(maxSplits, 1 + backtrackSplit(end, s,subStringVisited));
                subStringVisited.remove(subString);
            }
        }
        return maxSplits;

    }

    public static void main(String[] args) {
        System.out.println(split("ababccc"));
    }
}
