package GraphCycle;

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

        int result = g.findCycles();
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
        }

        public int findCycles(){
            boolean[] started = new boolean[adjacencyList.length], stopped = new boolean[adjacencyList.length];

            for (int i = 0; i < adjacencyList.length; i++) {

                if(!started[i]) {
                    int result = explore(i, started, stopped);
                    if (result == 1) return 1;
                }
            }
            return 0;
        }

        public int explore(int v, boolean[] started, boolean[] stopped){
            started[v] = true;
            for (int i = 0; i < adjacencyList[v].size(); i++) {
                int next = adjacencyList[v].get(i);
                if(started[next] && !stopped[next]) return 1;
                else if(!started[next]){
                    int result = explore(next, started, stopped);
                    if(result == 1) return 1;
                }
            }
            stopped[v] = true;
            return 0;
        }
    }
}
