package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class fractional_knapsack {
    /*
     * Given weights and N items
     * put items in knapsack of capacity w such that value is maximal
     * 
     * 
     * value = [60,100,120]  ans = 240
     * weight=[10,20,30]
     * W = 50
     */

     public static void main(String[] args) {
        int weight[] = {10,20,30};
        int value[]= {60,100,120};
        int W = 50;

        double ratio [][] = new double[value.length][2];
        for (int i = 0; i < value.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = value[i]/(double) weight[i];
        }
        int capacity = W;
        int finalvalue = 0;
        Arrays.sort(ratio,Comparator.comparingDouble(o->o[1]));

        for (int i =ratio.length-1; i >= 0; i--) {
            int idx = (int)ratio[i][0];
            if(capacity >= weight[idx]){
                //include full item
            finalvalue += value[idx];
            capacity -= weight[idx];
            }
            else{
                finalvalue += (ratio[i][1]*capacity); //include fractional item
                capacity = 0;
                break;
            }
        }
        System.out.println(finalvalue);

     }

}

