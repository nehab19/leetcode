package guru.springframework.spring5webapp.leetcode.StringOrArrays;

import java.util.Arrays;

public class AssignCookies {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int m=g.length;
        int n=s.length;
        int i=0,j=0;

        while(i<m && j<n ){
            if(g[i]<=s[j]){
                i++;
            }
            j++;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(findContentChildren(new int []{1,2,},new int[]{1,2,3}));
    }
}
