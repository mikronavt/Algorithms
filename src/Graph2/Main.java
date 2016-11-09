package Graph2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by User on 14.10.2014.
 */
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), m = s.nextInt();

        Graph g = new Graph(n);

        for (int i = 0; i < m; i++) {
            int v1 = s.nextInt(), v2 = s.nextInt();
            g.addEdge(v1 - 1, v2 - 1);
        }

        int result = g.connectedComponentsCount();
        System.out.println(result);

    }

    public static class Graph{
        private ArrayList<Integer>[] adjacencyList;


        public Graph(int n){
            adjacencyList = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                adjacencyList[i] = new ArrayList<Integer>();
            }


        }

        public void addEdge(int v1, int v2){
            adjacencyList[v1].add(v2);
            adjacencyList[v2].add(v1);
        }

        public int connectedComponentsCount(){
            boolean[] flags = new boolean[adjacencyList.length];
            int ccCount = 0;
            for (int i = 0; i < adjacencyList.length; i++) {
                if(!flags[i]){
                    ccCount++;
                    explore(i, flags);
                }
            }

            return ccCount;
        }

        private void explore(int v, boolean[] flags){
            if(!flags[v]) {
                flags[v] = true;
                for (int i = 0; i < adjacencyList[v].size(); i++) {
                    explore(adjacencyList[v].get(i), flags);
                }
            }
        }
    }

}
