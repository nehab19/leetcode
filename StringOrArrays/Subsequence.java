package guru.springframework.spring5webapp.leetcode.StringOrArrays;

public class Subsequence {
    public static boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        if (t.isEmpty()) {
            return false;
        }
        if (s.length() == t.length() && !s.equals(t)) {
            return false;
        }

        int i=0,j=0;
        while(i<s.length()){
           if(j==t.length()){
               return false;
           }
           while(j<t.length()){
               if(s.charAt(i)==t.charAt(j)){
                   j++;
                   break;
               }
               j++;
               if(j==t.length()){
                   return false;
               }
           }
           i++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgd"));
    }
}
