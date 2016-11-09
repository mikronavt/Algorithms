package generate_combinations_n_k;

import java.util.Scanner;

/**
 * Created by User on 30.03.2015.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();

        generateCombinationsNK(n, k);
    }

    public static void generateCombinationsNK(int n, int k){
        int[] A = new int[k];
        for (int i = 0; i < k; i++) {
            A[i] = i;

        }

        int p = k;
        while( p > 0 ){
            printArr(A);
            if(A[k - 1] == n - 1) p = p - 1;
            else p = k;
            if(p > 0 ){
                for (int i = k - 1; i >= p - 1 ; i--) {
                    A[i] = A[p - 1] + i - p + 2;
                }
            }

        }
    }

    public static void printArr(int[] A){
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
    }
}
