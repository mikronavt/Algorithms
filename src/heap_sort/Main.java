package heap_sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by User on 07.10.2014.
 */
public class Main {

    public static void main(String[] args) throws Throwable {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String s = reader.readLine();

        String p;
        int[] a = new int[n];
        for (int i = 0; i < n - 1; i++) {
            p = s.substring(0, s.indexOf(" "));
            a[i] = Integer.parseInt(p);

            s = s.substring(s.indexOf(" ") + 1);
        }
        a[n-1] = Integer.parseInt(s);

        heapSort(a);
        for (int i = 0; i < n; i++) {


            System.out.print(a[i] + " ");
        }
    }

    public static void heapSort(int[] a) {
        int size = a.length;
        buildMaxHeap(a, size);

        for (int i = size - 1; i >= 1; i--) {
            exchange(a, 0, i);
            siftDown(a, 0, i);

        }
    }

    public static void buildMaxHeap(int[] a, int size){
        for (int i = (size - 1)/2 ; i >= 0 ; i--) {
            siftDown(a, i, size);

        }
    }

    public static void siftDown(int[] a, int i, int size){
         if(2*i + 1 > size - 1) return;
         else if(2*i + 2 > size - 1 && a[i] >= a[2*i + 1]) return;
         else if(2*i + 2 > size - 1 && a[i] < a[2*i + 1]) {
             exchange(a, i, 2*i + 1);
             siftDown(a, 2*i + 1, size);
         }
         else if(2*i + 2 <= size - 1){
            if(a[i] >= a[2*i + 1] && a[i] >= a[2*i + 2]) return;
             else if(a[i] >= a[2*i + 1] && a[i] < a[2*i + 2]){
                exchange(a, i, 2*i + 2);
                siftDown(a, 2*i + 2, size);
            }
             else if(a[i] >= a[2*i + 2] && a[i] < a[2*i + 1]){
                exchange(a, i, 2*i + 1);
                siftDown(a, 2*i + 1, size);
            }
             else{
                if(a[2*i + 1] >= a[2*i + 2]){
                    exchange(a, i, 2*i + 1);
                    siftDown(a, 2*i + 1, size);
                }
                else{
                    exchange(a, i, 2*i + 2);
                    siftDown(a, 2*i + 2, size);
                }
            }
         }
    }

    public static void exchange(int[] a, int x, int y){
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }
}
