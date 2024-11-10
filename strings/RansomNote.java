package guru.springframework.spring5webapp.leetcode.strings;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {

        int[] charCount = new int[26];
        for (char ch : magazine.toCharArray()) {
            charCount[ch - 'a']++;
        }

        //check if ransom note can be constructed
        for (char ch : ransomNote.toCharArray()) {
            if (charCount[ch - 'a'] == 0) {
                return false;
            }
            charCount[ch - 'a']--;
        }

        return true;
    }
}
