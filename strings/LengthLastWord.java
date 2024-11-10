package guru.springframework.spring5webapp.leetcode.strings;

public class LengthLastWord {
    public static int lengthOfLastWord(String s) {
        if(s.isEmpty()){
            return 0;
        }
        String[] split = s.split(" ");
        return split[split.length-1].length();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
    }
}
