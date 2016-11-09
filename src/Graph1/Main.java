package Graph1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by User on 14.10.2014.
 */
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n, m;
        n = s.nextInt();
        m = s.nextInt();

        Graph g = new Graph(n);

        for (int i = 0; i < m; i++) {
            int v1, v2;
            v1 = s.nextInt();
            v2 = s.nextInt();
            g.addEdge(v1 - 1, v2 - 1);
        }

        int u, v;
        u = s.nextInt();
        v = s.nextInt();

        int result = g.reachability(u - 1, v - 1);
        System.out.println(result);
    }

    public static class Graph{
        private ArrayList<Integer>[] adjacencyList;
        private boolean[] flags;

        public Graph(int n){
            adjacencyList = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                adjacencyList[i] = new ArrayList<Integer>();
            }
            flags = new boolean[n];
        }

        public void addEdge(int v1, int v2){
            adjacencyList[v1].add(v2);
            adjacencyList[v2].add(v1);
        }

        public int reachability(int u, int v){
            int result = findLinks(u, v);
            flags = new boolean[flags.length];
            return result;
        }

        private int findLinks(int u, int v){
            if(!flags[u]){
                flags[u] = true;
                for (int i = 0; i < adjacencyList[u].size(); i++) {
                    if(adjacencyList[u].get(i) == v) return 1;
                    else {
                        int result = findLinks(adjacencyList[u].get(i), v);
                        if(result == 1) return 1;
                    }
                }
            }

            return 0;
        }

    }
}
