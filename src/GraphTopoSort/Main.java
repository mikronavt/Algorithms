package GraphTopoSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by User on 15.10.2014.
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

        g.topologicalSort();

        g.printTopologicalList();


    }

    public static class Graph{
        private ArrayList<Integer>[] adjacencyList;
        private int topologicalVertices[];

        public Graph(int n){
            adjacencyList = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                adjacencyList[i] = new ArrayList<Integer>();
            }
            topologicalVertices = new int[n];
            for (int i = 0; i < n; i++) {
                topologicalVertices[i] = i;
            }
        }

        public void addEdge(int v1, int v2){
            adjacencyList[v1].add(v2);
        }

        private boolean[] started;
        private boolean[] stopped;
        private int lastTopologicalVertex;

        public void topologicalSort(){
            started = new boolean[adjacencyList.length];
            stopped = new boolean[adjacencyList.length];
            lastTopologicalVertex = topologicalVertices.length - 1;
            for (int i = 0; i < adjacencyList.length; i++) {
                if(!started[i]){
                    explore(i);
                }
            }


        }

        private void explore(int v){
            started[v] = true;
            for (int i = 0; i < adjacencyList[v].size(); i++) {
                int next = adjacencyList[v].get(i);
                if(!started[next]){
                    explore(next);
                }
            }
            stopped[v] = true;
            topologicalVertices[lastTopologicalVertex] = v;
            lastTopologicalVertex--;
        }

        public void printTopologicalList(){
            for (int i = 0; i < topologicalVertices.length; i++) {


                System.out.print((topologicalVertices[i] + 1) + " ");
            }
        }


    }
}
