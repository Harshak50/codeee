package greedy;

import java.util.Arrays;

public class min_absolute_pairs {
    //given 2 arrays A and B of equal length n. Pair each element of array A to an element in array B such that all tha pairs have 
    //minimum absolute difference
    public static void main(String[] args) {
        int A[] = {4,1,8,7};
        int B[] = {2,3,6,5 };

        Arrays.sort(A);
        Arrays.sort(B);
        int min_diff = 0;

        for (int i = 0; i < A.length; i++) {
        min_diff += Math.abs(A[i]-B[i]);    
        }
        System.out.println("minimum absolute difference of pairs = "+min_diff);
    }


     
}
