package sort1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by User on 19.09.2014.
 */
public class Main {

    public static void main(String[] args) throws Throwable{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s, p;
        int n, k = 0;
        int[] a;
        int[] count_of_nums = new int[11];
        int[] b;

        n = Integer.parseInt(reader.readLine());
        a = new int[n];

        s = reader.readLine();

        for (int i = 0; i < n-1; i++) {

            p = s.substring(0, s.indexOf(" "));
            a[i] = Integer.parseInt(p);
            //System.out.println(p);
            s = s.substring(s.indexOf(" ") + 1);
            //System.out.println(s);
        }
        a[n-1] = Integer.parseInt(s);

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < count_of_nums.length; j++) {


                if (a[i] == j) count_of_nums[j]++;
            }
        }


        for (int i = 0; i < count_of_nums.length; i++) {
            for (int j = 0; j < count_of_nums[i]; j++) {
                a[k] = i;
                System.out.print(a[k] + " ");
                k++;
            }
        }
        //System.out.println(a);


    }
}
