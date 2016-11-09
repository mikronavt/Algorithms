package GraphFindWayWithoutWeight;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by User on 21.10.2014.
 */
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), m = s.nextInt();

        Graph g = new Graph(n);

        for (int i = 0; i < m; i++) {
            int v1 = s.nextInt(), v2 = s.nextInt();
            g.addEdge(v1 - 1,v2 - 1);
        }

        int u = s.nextInt(), v = s.nextInt();
        int result = g.findNearestWay(u - 1, v - 1);
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

        private int[] distanceToVertix;
        //private int[] previousVertix;
        public int findNearestWay(int u, int v){
            sortWays(u);
            int result = distanceToVertix[v];
            if(result == Integer.MAX_VALUE) return -1;
            return result;
        }

        private void sortWays(int s){
            int length = adjacencyList.length;
            distanceToVertix = new int[length];
            for (int i = 0; i < length; i++) {
                distanceToVertix[i] = Integer.MAX_VALUE;
            }
            distanceToVertix[s] = 0;

            LinkedList<Integer> queue = new LinkedList<Integer>();
            queue.add(s);
            while(!queue.isEmpty()){
                int u = queue.get(0);
                queue.removeFirst();
                for (int i = 0; i < adjacencyList[u].size(); i++) {
                    int v = adjacencyList[u].get(i);
                    if(distanceToVertix[v] == Integer.MAX_VALUE){
                        queue.add(v);
                        distanceToVertix[v] = distanceToVertix[u] + 1;
                    }
                }
            }
        }
    }
}
