package GraphFindWayWithWeights;

import java.util.*;

/**
 * Created by User on 21.10.2014.
 */
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), m = s.nextInt();

        Graph g = new Graph(n);

        for (int i = 0; i < m; i++) {
            int v1 = s.nextInt(), v2 = s.nextInt(), l = s.nextInt();
            g.addEdge(v1 - 1, v2 - 1, l);
        }

        int u = s.nextInt(), v = s.nextInt();
        int result = g.findNearestWay(u - 1, v - 1);
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

        public void addEdge(int v, int u, int length){
            Integer[] edge = new Integer[2];
            edge[0] = u;
            edge[1] = length;
            adjacencyList[v].add(edge);
        }

        private int[] distanceToVertix;
        private int[] previousVertix;
        public int findNearestWay(int u, int v){
            dijkstraSort(u);
            int result = distanceToVertix[v];
            if(result == Integer.MAX_VALUE) return -1;
            return result;
        }

        private void dijkstraSort(int s){
            int length = adjacencyList.length;
            distanceToVertix = new int[length];
            previousVertix = new int[length];
            for (int i = 0; i < length; i++) {
                distanceToVertix[i] = Integer.MAX_VALUE;
                previousVertix[i] = -1;
            }
            distanceToVertix[s] = 0;


            HashMap<Integer, Integer> queue = new HashMap<Integer, Integer>();
            for (int i = 0; i < length; i++) {
                queue.put(i, distanceToVertix[i]);
            }

            while(!queue.isEmpty()){
                int u = extractMin(queue);
                for (int i = 0; i < adjacencyList[u].size(); i++) {
                    if(distanceToVertix[u] != Integer.MAX_VALUE && adjacencyList[u].get(i)[1] != Integer.MAX_VALUE && distanceToVertix[adjacencyList[u].get(i)[0]] > distanceToVertix[u] + adjacencyList[u].get(i)[1]){
                        distanceToVertix[adjacencyList[u].get(i)[0]] = distanceToVertix[u] + adjacencyList[u].get(i)[1];
                        previousVertix[adjacencyList[u].get(i)[0]] = u;
                        queue.remove(adjacencyList[u].get(i)[0]);
                        queue.put(adjacencyList[u].get(i)[0], u);
                    }
                }
            }

        }

        private int extractMin(HashMap<Integer, Integer> queue){

            int minValue = Integer.MAX_VALUE;
            int minElement = 0;
            for (Map.Entry<Integer, Integer> entry: queue.entrySet()) {
                if(minValue >= entry.getValue()){
                    minElement = entry.getKey();
                    minValue = entry.getValue();
                }
            }
            queue.remove(minElement);
            return minElement;
        }
    }
}
