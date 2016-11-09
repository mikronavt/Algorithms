package segment_tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by User on 01.10.2014.
 */
public class Main {

    public static void main(String[] args) throws Throwable{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm;
        nm = parseArray(reader.readLine(), 2);
        int[] a;
        a = parseArray(reader.readLine(), nm[0]);

        SegmentTree tree = new SegmentTree(a, nm[0]);

        for (int i = 0; i < nm[1]; i++) {
            parseInput(reader.readLine(), tree);
        }

    }

    public static int[] parseArray(String s, int n){
        String p, s1 = s;
        int k = 0, l = s.indexOf(" ");
        int[] a = new int[n];

        for (int i = 0; i < n - 1; i++) {
            p = s1.substring(0, s1.indexOf(" "));
            a[i] = Integer.parseInt(p);

            s1 = s1.substring(s1.indexOf(" ") + 1);
        }
        a[n-1] = Integer.parseInt(s1);

        return a;

    }

    public static void parseInput(String s, SegmentTree tree){

        if(s.contains("Min"))
        {
            int left, right;
            left = Integer.parseInt(s.substring(4, s.indexOf(" ", 4)));
            right = Integer.parseInt(s.substring(s.indexOf(" ", 4) + 1));
            tree.min(left - 1, right - 1);
        }
        else if(s.contains("Set"))
        {
            int index, newValue;
            index = Integer.parseInt(s.substring(4, s.indexOf(" ", 4)));
            newValue = Integer.parseInt(s.substring(s.indexOf(" ", 4) + 1));
            tree.setValue(index - 1, newValue);
        }

    }

    static class SegmentTree{
        private int[] arrayTree, treeIndexes;


        public SegmentTree(int[] a, int n){
            int k = (int) (Math.log(n)/Math.log(2.0));
            int m = (int) Math.pow(2, k);
            if(m != n) m = (int) Math.pow(2, k + 1);

            int[] arr = new int[m];

            for (int i = 0; i < n; i++) {
                arr[i] = a[i];
            }

            for (int i = n; i < m; i++) {
                arr[i] = Integer.MAX_VALUE;
            }

            int treeLength = m * 2 - 1;
            arrayTree = new int[treeLength];
            treeIndexes = new int[treeLength];

            for (int i = 0; i < m; i++) {
                arrayTree[i + m - 1] = arr[i];
                treeIndexes[i + m - 1] = i;
            }

            for (int i = m - 2; i >= 0; i--) {

                if(arrayTree[i*2 + 1] < arrayTree[i*2 + 2])
                {
                    arrayTree[i] = arrayTree[i*2 + 1];
                    treeIndexes[i] = treeIndexes[i*2 + 1];
                }
                else
                {
                    arrayTree[i] = arrayTree[i*2 + 2];
                    treeIndexes[i] = treeIndexes[i*2 + 2];
                }

            }



        }

        public int getArrayLength(){
            return (treeIndexes.length + 1) / 2;
        }

        public void min(int left, int right){
            System.out.println(findMin(left, right, 0, this.getArrayLength() - 1, 0));
        }

        public int findMin(int left, int right, int l, int r, int root) {

            //System.out.println(left + " " +  right + " " + " " + l + " " + r + " "+ root);
            if(l == left && r == right) return arrayTree[root];
            else if(right <= (l + r)/2) return findMin(left, right, l, (l + r) / 2, 2 * root + 1);
            else if(left >= (l + r)/2 + 1) return findMin(left, right, (l + r)/ 2 + 1, r, 2 * root + 2);
            else return Math.min(findMin(left, (l + r)/ 2, l, (l + r)/2, 2 * root + 1), findMin((l + r)/2 + 1, right, (l + r)/2 + 1, r, 2*root + 2));


        }

        public void setValue(int index, int newValue){
            int treeLength = this.arrayTree.length;
            int m = (treeLength + 1)/2;
            int i = m - 1 + index;

            arrayTree[i] = newValue;


            while (i > 0) {
                int j;
                if(i%2 == 0) j = i - 1;
                else j = i + 1;


                if(arrayTree[i] > arrayTree[j]) {
                    arrayTree[(i - 1) / 2] = arrayTree[j];
                    treeIndexes[(i - 1) / 2] = treeIndexes[j];
                }
                else{
                    arrayTree[(i - 1)/ 2] = arrayTree[i];
                    treeIndexes[(i - 1)/ 2] = treeIndexes[i];
                }

                i = (i - 1)/2;
            }




        }
    }
}
