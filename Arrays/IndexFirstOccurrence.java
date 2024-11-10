package guru.springframework.spring5webapp.leetcode.Arrays;

//Input: haystack = "sadbutsad", needle = "sad"
//Output: 0
//Explanation: "sad" occurs at index 0 and 6.
//The first occurrence is at index 0, so we return 0.
public class IndexFirstOccurrence {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }
        for (int i = 0; i < haystack.length() - needle.length(); i++) {
           if(haystack.substring(i,i+needle.length()).equals(needle)){
               return i;
           }
        }
        return -1;
    }
}
