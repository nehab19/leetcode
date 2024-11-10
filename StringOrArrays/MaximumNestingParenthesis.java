package guru.springframework.spring5webapp.leetcode.StringOrArrays;

public class MaximumNestingParenthesis {
    public static int maxDepth(String s){
        int openBrackets=0;
        int result=0;
        for(char ch : s.toCharArray()){
            if(ch=='('){
                openBrackets++;
            }else if(ch==')'){
                openBrackets--;
            }
            result=Math.max(result,openBrackets);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));
    }
}
