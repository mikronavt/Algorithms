package find;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by User on 22.09.2014.
 */
public class Main {

    public static void main(String[] args) throws Throwable{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] a, b, result;
        int A, B;
        String s1, p1, s2, p2;

        s1 = reader.readLine();
        s2 = reader.readLine();

        p1 = s1.substring(0, s1.indexOf(" "));
        A = Integer.parseInt(p1);
        s1 = s1.substring(s1.indexOf(" ") + 1);

        p2 = s2.substring(0, s2.indexOf(" "));
        B = Integer.parseInt(p2);
        s2 = s2.substring(s2.indexOf(" ") + 1);


        a = new int[A];
        b = new int[B];
        result = new int[B];

        for (int i = 0; i < A - 1; i++) {
            p1 = s1.substring(0, s1.indexOf(" "));
            a[i] = Integer.parseInt(p1);

            s1 = s1.substring(s1.indexOf(" ") + 1);
        }
        a[A-1] = Integer.parseInt(s1);

        for (int i = 0; i < B - 1; i++) {
            p2 = s2.substring(0, s2.indexOf(" "));
            b[i] = Integer.parseInt(p2);

            s2 = s2.substring(s2.indexOf(" ") + 1);
        }
        b[B-1] = Integer.parseInt(s2);


        for (int i = 0; i < B; i++) {
            result[i] = find(b[i], a, 0, a.length - 1);
            System.out.print(result[i] + " ");
        }


    }

    public static int find(int k, int[] a, int first, int last){
        //System.out.println(k + " " + first + " " + last + " " + (first + last)/ 2);
        if(first == last && a[first] == k) return first + 1;
        else if(first == last && a[first] != k) return -1;
        else if(a[(first + last)/2] == k) return (first + last)/2 + 1;
        else if(a[(first + last)/2] > k && (first + last)/2 - 1 >= first) return find(k, a, first, (first + last)/2 - 1);
        else if(a[(first + last)/2] < k && (first + last)/2 + 1 <= last) return find(k, a, (first + last)/2 + 1, last);
        else return -1;


    }
}
