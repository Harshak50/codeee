package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class max_length_chain {
    // Max Length Chain of Pairs
    // You are given n pair of numbers.In every pair, 1st no < 2nd no
    // pair (c,d) can come after pair (a,b) if b < c
    // find the longest chain formed from the set

    // another model of activities selection
    // Disjoint
    public static void main(String[] args) {
        int pairs [][] = { {5,25} , {39,60}, {5,28}, {27,40}, {50,90}};
        Arrays.sort(pairs,Comparator.comparingDouble(o->o[1]));
        int chianLen = 1;
        int chainEnd = pairs[0][1]; //last end pair that is first pair initially
        for (int i = 0; i < pairs.length; i++) {
            if(pairs[i][0] > chainEnd){
                chianLen++;
                chainEnd = pairs[i][1];
            }
        }
        System.out.println("Max Chain Length = "+chianLen);
    }
}
