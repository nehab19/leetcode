package guru.springframework.spring5webapp.leetcode.StringOrArrays;

public class ReverseSubString {
    public static String reversePrefix(String word, char ch){
        int index=word.indexOf(ch);
        if(index!=-1){
          return new StringBuilder(word.substring(0,index+1)).reverse().toString() + word.substring(index+1);
        }
        return word;
    }

    public static void main(String[] args) {
        System.out.println(reversePrefix("abcdefgd",'d'));
    }
}
