package karatsuba;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by User on 23.09.2014.
 */
public class Main {

    public static void main(String[] args) throws Throwable{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        BigInteger first = new BigInteger(reader.readLine());
        BigInteger second = new BigInteger(reader.readLine());


        BigInteger result = first.multiply(second);
        System.out.println(result);
    }
}
