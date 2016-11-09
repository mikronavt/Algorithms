package parse_double;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by User on 22.10.2015.
 */
public class Main {
    public static void main(String[] args) throws Throwable{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double d = 0.0;
        while (reader.ready()){
            String s = reader.readLine();
            String[] strings = s.split(" ");
            for(String str: strings){
                try {
                    d = d + Double.parseDouble(str);
                }
                catch(NumberFormatException e){}
            }
        }
        System.out.format("%g", d);

    }
}
