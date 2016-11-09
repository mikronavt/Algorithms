package StronglyConnectedComponents;

import java.util.ArrayList;
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
            //g.addEdge(v2 - 1, v1 - 1);
        }

        int result = g.componentsCount();
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

        private Graph tr;
        private int[] transposedVertices;
        private int countOfComponents;
        public int componentsCount(){
            tr = this.transpose();
            transposedVertices = transposedSearchInDeep(tr);
            searchInDeep();
            return countOfComponents;
        }

        private boolean[] visited;
        private void searchInDeep(){
            countOfComponents = 0;
            int length = transposedVertices.length;
            visited = new boolean[length];
            for (int i = 0; i < length; i++) {
                if(!visited[transposedVertices[i]]){
                    search(transposedVertices[i]);
                    countOfComponents++;
                }
            }
        }

        private void search(int v){
            visited[v] = true;
            for (int i = 0; i < adjacencyList[v].size(); i++) {
                int next = adjacencyList[v].get(i);
                if(!visited[next]){
                    search(next);
                }
            }
        }

        private int[] vertices;
        private int lastVertix;
        private boolean[] started, stopped;
        private int[] transposedSearchInDeep(Graph g){
            int length = g.getLength();
            vertices = new int[length];
            lastVertix = length - 1;
            started = new boolean[length];
            stopped = new boolean[length];
            for (int i = 0; i < length; i++) {
                if(!started[i]) explore(g, i);
            }


            return vertices;
        }

        private void explore(Graph g, int v){
            started[v] = true;
            for (int i = 0; i < g.getEdges(v).size(); i++) {
                int next = g.getEdges(v).get(i);
                if(!started[next]){
                    explore(g, next);
                }
            }
            stopped[v] = true;
            vertices[lastVertix] = v;
            lastVertix--;
        }

        public Graph transpose(){
            Graph tr = new Graph(adjacencyList.length);
            for (int i = 0; i < adjacencyList.length; i++) {
                for (int j = 0; j < adjacencyList[i].size(); j++) {
                    tr.addEdge(adjacencyList[i].get(j), i);

                }
            }
            return tr;
        }

        public int getLength(){
            return adjacencyList.length;
        }

        public ArrayList<Integer> getEdges(int v){
            return adjacencyList[v];
        }
    }
}
