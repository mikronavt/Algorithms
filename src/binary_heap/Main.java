package binary_heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by User on 01.10.2014.
 */
public class Main {


    public static void main(String[] args) throws Throwable{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        BinaryHeap heap = new BinaryHeap(n);
        for (int i = 0; i < n; i++) {
            String s = reader.readLine();
            parseInput(s, heap);
        }

    }

    public static void parseInput (String s, BinaryHeap heap) {
        if(s.contains("Insert")) heap.add(Integer.parseInt(s.substring(7)));
        else if(s.contains("Extract")) heap.extract();

    }

    static class BinaryHeap{
        private int[] a;
        private int maxSize;
        private int heapSize;

        public BinaryHeap(int n){
            a = new int[n];
            maxSize = n;
            heapSize = 0;
        }

        public void add(int i){
            int index = heapSize;
            heapSize++;
            a[index] = i;
            shiftUp(index, i);


        }

        public void extract(){
            System.out.println(a[0]);
            a[0] = a[heapSize - 1];
            a[heapSize - 1] = 0;
            heapSize--;
            shiftDown(0,a[0]);

        }

        private void shiftUp(int index, int i){
            if(index != 0 && i > a[(index - 1)/2])
            {
                a[index] = a[(index-1)/2];
                a[(index-1)/2] = i;
                index = (index - 1)/2;
                shiftUp(index, i);
            }
        }

        private void shiftDown(int index, int i){
            if(index == heapSize - 1 || (i >= a[2*index + 1] && i >= a[2*index + 2])){}
            else if(a[2*index + 1] >= a[2*index + 2])
            {
                a[index] = a[2*index + 1];
                a[2*index + 1] = i;
                shiftDown(2*index + 1, i);
            }
            else if(a[2*index + 2] > a[2*index + 1])
            {
                a[index] = a[2*index + 2];
                a[2*index + 2] = i;
                shiftDown(2*index + 2, i);
            }
        }


    }
}
