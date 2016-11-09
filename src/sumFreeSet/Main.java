package sumFreeSet;

import java.util.HashSet;

/**
 * Created by User on 14.05.2015.
 */
public class Main {
    public static void main(String[] args) {
        HashSet<Integer> A = new HashSet<Integer>();
        for (int i = 1; i <= 100; i+= 3) {
            A.add(i);

        }


        HashSet<Integer> aPlusA = new HashSet<Integer>();
        for(int i:A){
            for (int j: A){
                aPlusA.add((i + j)%101);
            }
        }

        System.out.println("A: ");
        System.out.println(A.size() + " размер множества");
        for(int i:A){

            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("A + A:");
        for (int i:aPlusA) {

            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("A intersect (A + A): ");
        for(int i: A){

            if(aPlusA.contains(i)){

                System.out.print(i + " ");
            }
        }
        

    }
}
