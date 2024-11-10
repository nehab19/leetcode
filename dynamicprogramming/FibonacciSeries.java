package guru.springframework.spring5webapp.leetcode.dynamicprogramming;

public class FibonacciSeries {
    private int[] memo = new int[31];

    //using recursion + memoization
    private int fibonacci(int n) {
        for (int i = 0; i < 31; i++) {
            memo[i] = -1;
        }
        return solve(n);
    }

    private int solve(int n) {
        //base case, if n=0 return 0 if n=1 return 1
        if (n <= 1) {
            return n;
        }
        //check if result is stored in memo
        if (memo[n] != -1) {
            return memo[n];
        }
        memo[n] = solve(n - 1) + solve(n - 2);
        return memo[n];
    }

    //using bottom up approach
    private int fibonacciSeries(int n){
        if(n<=1){
            return n;
        }
        memo[0]=0;
        memo[1]=1;

        for(int i=2;i<=n;i++){
            memo[i]=memo[i-1] + memo[i-2];
        }
        return memo[n];
    }
}
