package guru.springframework.spring5webapp.leetcode.Arrays;

public class BestTimeToBuyAndSellStock {
    //when only one transaction is allowed
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(solution.maxProfitWithTwoTransaction(prices));  // Output: 5
    }

    // when almost 2 transactions are allowed
    public int maxProfitWithTwoTransaction(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;

        int[] leftPrice = new int[n];
        int[] rightPrice = new int[n];

        int minPrice = prices[0];


        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            leftPrice[i] = Math.max(leftPrice[i - 1], prices[i] - minPrice);
        }
        int maxPrice = prices[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            rightPrice[i] = Math.max(rightPrice[i + 1], maxPrice - prices[i]);
        }
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, leftPrice[i] + rightPrice[i]);
        }
        return maxProfit;
    }
}
