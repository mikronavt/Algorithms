package fibonachi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by User on 18.09.2014.
 */

public class Solution {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        long n = 0, m = 10, a = 0, b = 1, c = 0;
        String s, p;
        long period = 0;

        try {
            s = reader.readLine();
            reader.close();
            p = s.substring(0, s.indexOf(" "));
            n = Long.parseLong(p);
            p = s.substring(s.indexOf(" ") + 1);
            m = Long.parseLong(p);
        }
        catch (IOException e){
            System.out.println("aaaaaaaaaaaaaa");
        }


        for (int i = 2; i <= 6 * m; i++) {
            c = (a + b) % m;
            a = b;
            b = c;

            if(a == 0 && b == 1) {
                period = i - 1;
                break;
            }
        }

        a = 0;
        b = 1;
        if(n == 1) c =1;
        else {
            for (int i = 2; i <= (n % period); i++) {
                c = (a + b) % m;
                a = b;
                b = c;

            }
        }

        System.out.println(c);

    }

}
