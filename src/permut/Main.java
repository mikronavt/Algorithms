package permut;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by User on 06.04.2015.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        generatePermutation(n, k);

    }

    public static List<int[]> generatePermutation(int n, int k){
        int position = k - 1;
        int[] arr = new int[k];

        for (int i = 0; i < k; i++) {
            arr[i] = i;
        }

        List<int[]> list = new ArrayList<int[]>();
        list.add(arr);

        while(true){
            if(arr[position] == n - 1){
                arr[position] = 0;
                position--;

                if(position < 0) return list;;
            }
            else{
                position++;
                for (int i = 0; i < n; i++) {


                    arr[position]++;
                    boolean flag = true;
                    for (int j = 0; j < k; j++) {
                        if (arr[j] == arr[position]) {
                            flag = false;
                            break;
                        }


                    }
                    if (flag) list.add(arr);
                }
            }
        }

    }


}
