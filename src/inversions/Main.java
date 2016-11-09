package inversions;

import java.util.Scanner;

/**
 * Created by User on 08.10.2014.
 */
public class Main {

    public static void main(String[] args) throws Throwable{


        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();
        //String p;
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }

        long[] inv = new long[1];
        arrayInversions(a, inv, 0, n - 1);

        System.out.println(inv[0]);
    }

    public static void arrayInversions(int[] a, long[] inv, int left, int right){
        int m = (left + right)/2;
        if(left >= right) return;
        else{
            arrayInversions(a, inv, left, m);
            arrayInversions(a, inv, m + 1, right);
            merge(a, inv, left, right);
        }
    }

    public static void merge(int[] a, long[] inv, int left, int right){

        int m = (left + right)/2;
        int[] temp = new int[a.length];
        for (int i = left; i <= right; i++) {
            temp[i] = a[i];
        }

        int i = left, j = m + 1, k = left;
        while(k <= right){
            if(i > m){
                a[k] = temp[j];
                k++;
                j++;
            }
            else if(j > right){
                a[k] = temp[i];
                k++;
                i++;
            }
            else if(temp[i] > temp[j]) {
                a[k] = temp[j];
                inv[0] = inv[0] + m + 1 - i;

                k++;
                j++;
            }
            else{
                a[k] = temp[i];
                i++;
                k++;
            }
        }


    }

}
