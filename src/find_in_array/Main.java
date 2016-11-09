package find_in_array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by User on 23.09.2014.
 */
public class Main {
    public static void main(String[] args) throws Throwable{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int a[] = new int[n];
        String p, s;

        s = reader.readLine();

        for (int i = 0; i < n - 1; i++) {
            p = s.substring(0, s.indexOf(" "));
            a[i] = Integer.parseInt(p);

            s = s.substring(s.indexOf(" ") + 1);
        }
        a[n-1] = Integer.parseInt(s);

        if(find(a) > 0) System.out.println(1);
        else System.out.println(0);

    }

    public static int find(int[] a){
        int[] afirst, alast;
        if(a.length == 1) return a[0];
        int m = a.length, n = m/2;
        afirst = new int[n];
        alast = new int[m - n];
        for (int i = 0; i < n; i++) {
            afirst[i] = a[i];
        }
        for (int i = n; i < m ; i++) {
            alast[i - n] = a[i];
        }

        int k = find(afirst);
        if (k != -1 && count(a, k) > n ) return k;

        k = find(alast);
        if(k != -1 && count(a, k) > n) return k;

        return -1;
    }

    public static int count(int[] a, int n)
    {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == n) sum++;
        }
        return sum;
    }


}
