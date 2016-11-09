package disjoint_set;

        import java.io.BufferedReader;
        import java.io.InputStreamReader;

/**
 * Created by User on 02.10.2014.
 */
public class Main {
    static SetsForest forest;

    public static void main(String[] args) throws  Throwable{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n, m;
        String s = reader.readLine();
        n = Integer.parseInt(s.substring(0, s.indexOf(" ")));
        m = Integer.parseInt(s.substring(s.indexOf(" ")+ 1));

        forest = new SetsForest(n);

        for (int i = 0; i < m; i++) {
            parseInput(reader.readLine());
        }


    }

    public static void parseInput(String s){
        if(s.contains("Check")){
            int a, b;
            a = Integer.parseInt(s.substring(6, s.indexOf(" ", 6)));
            b = Integer.parseInt(s.substring(s.indexOf(" ", 6)+ 1));
            forest.check(a - 1, b - 1);

        }
        else if(s.contains("Union")){
            int a, b;
            a = Integer.parseInt(s.substring(6, s.indexOf(" ", 6)));
            b = Integer.parseInt(s.substring(s.indexOf(" ", 6)+ 1));
            forest.union(a - 1, b - 1);
        }
    }

    public static class SetsForest{
        private Set[] sets;
        private int[] p;
        private int[] rank;

        public SetsForest(int n){
            this.sets = new Set[n];
            this.p = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++) {
                this.makeSet(i);
            }
        }

        public void union(int x, int y){
            x = find(x);
            y = find(y);
            if(x == y) return;
            if(rank[x] > rank[y]) p[y] = x;
            else{
                p[x] = y;
                if(rank[x] == rank[y]) rank[x] = rank[y] + 1;
            }

        }

        public void check(int x, int y){
            if(find(x) == find(y)) System.out.println("True");
            else System.out.println("False");
        }

        public void makeSet(int x){
            sets[x] = new Set();
            p[x] = x;
            rank[x] = 0;
        }

        public int find(int x){
            if(x != p[x]) p[x] = find(p[x]);
            return p[x];

        }
    }

    public static class Set{




    }
}
