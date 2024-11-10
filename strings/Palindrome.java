package guru.springframework.spring5webapp.leetcode.strings;

public class Palindrome {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            char firstElement = s.charAt(start);
            char lastElement = s.charAt(end);

            if (!Character.isLetterOrDigit(firstElement)) {
                start++;
            } else if (!Character.isLetterOrDigit(lastElement)) {
                end--;
            } else {
                if (Character.toLowerCase(firstElement) != Character.toLowerCase(lastElement)) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }

}
