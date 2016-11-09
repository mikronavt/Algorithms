package Euler_Cycle;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by User on 20.04.2015.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        Graph g = new Graph(v);

        for (int i = 0; i < v; i++) {
            int v1 = sc.nextInt(), v2 = sc.nextInt();
            double w = sc.nextLong();
            g.addEdge(v1 - 1, v2 - 1);
            g.addEdge(v2 - 1, v1 - 1);
        }

    }

    public static class Graph{
        private ArrayList<Edge>[] adjacencyList;

        public Graph(int n){
            adjacencyList = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                adjacencyList[i] = new ArrayList<Edge>();
            }
        }

        public void addEdge(int u, int v){
            Edge e = new Edge(v);
            adjacencyList[u].add(e);
        }

        public boolean isEuler(){
            for (int i = 0; i < adjacencyList.length; i++) {

                if (adjacencyList[i].size() % 2 != 0) return false;
            }

            return true;
        }

    }



    public static class Edge{
        public int vertix;
        boolean deleted;

        public Edge(int v){
            this.vertix = v;
            deleted = false;

        }
    }
}
