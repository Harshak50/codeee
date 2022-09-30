package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class indian_coins {

    /*
     * We are given an infinite supply of demoninations[1,2,5,10,20,50,500,2000]
     * canonical coin/ number systems only where we can apply greedy
     * Min no of coins/notes require to make change or a value V
     * 
     * V = 121
     * ans = 3(100+20+1)
     * 
     * V = 590
     * ans = 4(500+50+20+20)
     */

    /*
     * Approach
     * 1. Sort decending order
     */

    public static void main(String[] args) {
        Integer coins[] = { 1, 2, 5, 10, 20, 50, 500, 2000 };

        // sort in decending order
        Arrays.sort(coins, Comparator.reverseOrder());

        int count = 0;
        int amount = 1050;
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {
                while (coins[i] <= amount) {
                    count++;
                    ans.add(coins[i]);
                    amount -= coins[i];
                }
            }
        }
        System.out.println("Total (min) coins used = " + count);
        System.out.println("Coins used");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }

}
