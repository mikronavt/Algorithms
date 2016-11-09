package GraphFindNegativeCycle;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by User on 22.10.2014.
 */
public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), m = s.nextInt();

        Graph g = new Graph(n);

        for (int i = 0; i < m; i++) {
            int v1 = s.nextInt(), v2 = s.nextInt(), w = s.nextInt();
            g.addEdge(v1 - 1, v2 - 1, w);
        }

        int result = g.findNegativeCycle();
        System.out.println(result);
    }

    static class Graph{
        private ArrayList<Integer[]>[] adjacencyList;

        public Graph(int n){
            adjacencyList = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                adjacencyList[i] = new ArrayList<Integer[]>();
            }
        }

        public void addEdge(int u, int v, int weight){
            Integer[] edge = new Integer[2];
            edge[0] = v;
            edge[1] = weight;
            adjacencyList[u].add(edge);
        }

        int[] dist;
        int[] prev;
        public int findNegativeCycle(){
            dist = new int[adjacencyList.length];
            prev = new int[adjacencyList.length];
            for (int i = 0; i < adjacencyList.length; i++) {
                bellmanFordFull(i);
                int[] distTemp = arrayCopy(dist);
                bellmanFordIteration();
                if(!arraysAreEqual(distTemp, dist)) return 1;
            }
            return 0;
        }

        private void bellmanFordFull(int s){
            for (int i = 0; i < adjacencyList.length; i++) {
                dist[i] = Integer.MAX_VALUE;
                prev[i] = -1;
            }
            dist[s] = 0;
            for (int i = 0; i < adjacencyList.length - 1; i++) {
                bellmanFordIteration();
            }
        }

        private void bellmanFordIteration(){
            for (int i = 0; i < adjacencyList.length; i++) {
                for (int j = 0; j < adjacencyList[i].size(); j++) {
                    relax(i, adjacencyList[i].get(j)[0], adjacencyList[i].get(j)[1]);
                }
            }
        }

        private void relax(int u, int v, int weight){
            if(dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + weight){
                dist[v] = dist[u] + weight;
                prev[v] = u;
            }
        }

        private int[] arrayCopy(int[] a){
            int[] cpy = new int[a.length];
            for (int i = 0; i < a.length; i++) {
                cpy[i] = a[i];
            }
            return cpy;
        }

        private boolean arraysAreEqual(int[] arr1, int[] arr2){
            if(arr1.length != arr2.length) return false;

            for (int i = 0; i < arr1.length; i++) {
                if(arr1[i]!=arr2[i]) return false;
            }

            return true;
        }


    }

}
