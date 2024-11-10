package guru.springframework.spring5webapp.leetcode.StringOrArrays;

public class BuyTickets {
    public static int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                time = time + Math.min(tickets[k], tickets[i]);
            } else {
                time = time + Math.min(tickets[k]-1,tickets[i]);
            }
        }
        return time;
    }


    public static void main(String[] args) {
        System.out.println(timeRequiredToBuy(new int[]{1,2,4,6},2));
    }
}

