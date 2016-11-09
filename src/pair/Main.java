package pair;

/**
 * Created by User on 28.10.2015.
 */


public class Main {
    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(null, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"

        Pair<Integer, String> pair2 = Pair.of(null, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode();

    }
}
