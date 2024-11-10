package guru.springframework.spring5webapp.leetcode.strings;

public class DeleteCharacters {
    public static String makeFancyString(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s.charAt(0));
        int count = 1;
        int size = s.length();
        for (int i = 1; i < size; i++) {
            if(s.charAt(i)==stringBuilder.charAt(stringBuilder.length()-1)){
                count++;
                if(count < 3){
                    stringBuilder.append(s.charAt(i));
                }
            }else{
                count=1;
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(makeFancyString("leeetcode"));
    }
}
