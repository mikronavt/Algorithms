package FindWayToEveryVertix;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by User on 22.10.2014.
 */
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), m = s.nextInt(), vert = s.nextInt();

        Graph g = new Graph(n);

        for (int i = 0; i < m; i++) {
            int v1 = s.nextInt(), v2 = s.nextInt();
            double w = s.nextLong();
            g.addEdge(v1 - 1, v2 - 1, w);
        }

        g.findShortestWays(vert - 1);
    }

    static class Graph{
        private ArrayList<Edge>[] adjacencyList;

        public Graph(int n){
            adjacencyList = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                adjacencyList[i] = new ArrayList<Edge>();
            }
        }

        public void addEdge(int u, int v, double weight){
            Edge e = new Edge(v, weight);
            adjacencyList[u].add(e);
        }

        double[] dist;
        int[] prev;
        int hardcoreCounter;
        boolean doHardcore = true;
        public void findShortestWays(int s){
            dist = new double[adjacencyList.length];
            prev = new int[adjacencyList.length];

            bellmanFordFull(s);
            //double[] distTemp = arrayCopy(dist);
            //for (int i = 0; i < adjacencyList.length; i++) {
             //   bellmanFordIteration();
            //}

            while(doHardcore){
                bellmanFordHardcoreIteration();
            }

            for (int i = 0; i < adjacencyList.length; i++) {
                //if(findCycles(i)) System.out.println("-");

                //else if(dist[i] != distTemp[i] || dist[i] == Double.MIN_VALUE) System.out.println("-");
                if(dist[i] == Double.MIN_VALUE) System.out.println("-");
                else if (prev[i] == -1) System.out.println("*");
                else System.out.println(Math.round(dist[i]));

            }
        }

        private void bellmanFordFull(int s){
            for (int i = 0; i < adjacencyList.length; i++) {
                dist[i] = Double.MAX_VALUE;
                prev[i] = -1;
            }
            dist[s] = 0;
            prev[s] = Integer.MAX_VALUE;
            for (int i = 0; i < adjacencyList.length - 1; i++) {
                bellmanFordIteration();
            }
        }

        private void bellmanFordIteration(){
            for (int i = 0; i < adjacencyList.length; i++) {
                for (int j = 0; j < adjacencyList[i].size(); j++) {
                    relax(i, adjacencyList[i].get(j).vertix, adjacencyList[i].get(j).weight);
                }
            }
        }

        private void bellmanFordHardcoreIteration(){
            hardcoreCounter = 0;
            for (int i = 0; i < adjacencyList.length; i++) {
                for (int j = 0; j < adjacencyList[i].size(); j++) {
                    relaxHardcore(i, adjacencyList[i].get(j).vertix, adjacencyList[i].get(j).weight);
                }
            }
            if(hardcoreCounter == 0) doHardcore = false;
        }

        private void relax(int u, int v, double weight){

            if(dist[u] < 0 && weight < 0 && (dist[u] + weight) > 0){
                dist[v] = Double.MIN_VALUE;
                prev[v] = u;
            }
            else if(dist[u] != Double.MAX_VALUE && dist[v] > dist[u] + weight){
                dist[v] = dist[u] + weight;
                prev[v] = u;
            }

        }

        private void relaxHardcore(int u, int v, double weight){
            if(dist[v] != Double.MIN_VALUE && dist[u] != Double.MAX_VALUE && (dist[v] > dist[u] + weight || dist[u] == Double.MIN_VALUE)){
                dist[v] = Double.MIN_VALUE;
                prev[v] = u;
                hardcoreCounter++;
            }
        }

        private double[] arrayCopy(double[] a){
            double[] cpy = new double[a.length];
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


        private boolean findCycles(int i){
            HashSet<Integer> queue = new HashSet<Integer>();
            int tmp = i;
            while(prev[tmp] != Integer.MAX_VALUE && prev[tmp] != -1){
                if(queue.contains(tmp)) return true;
                queue.add(tmp);
                tmp = prev[tmp];
            }
            return false;
        }

    }

    public static class Edge{
        public int vertix;
        public double weight;

        public Edge(int v, double w){
            this.vertix = v;
            this.weight = w;
        }
    }
}

