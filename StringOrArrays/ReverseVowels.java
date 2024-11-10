package guru.springframework.spring5webapp.leetcode.StringOrArrays;

public class ReverseVowels {
    static String reverseVowels(String s){
        char [] word=s.toCharArray();
        String vowels="aeiouAEIOU";
        int start=0;
        int end =s.length()-1;
        while(start<end){
            while (start<end && vowels.indexOf(word[start])==-1){
                start++;
            }
            while (start<end && vowels.indexOf(word[end])==-1){
                end--;
            }
            //swap
            char temp=word[start];
            word[start]=word[end];
            word[end]=temp;
            start++;
            end--;
        }
        return new String(word);
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("Hello"));
    }
}
