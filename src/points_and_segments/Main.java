package points_and_segments;

import java.util.Scanner;

/**
 * Created by User on 09.10.2014.
 */
public class Main {
    public static void main(String[] args) {


        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();

        int[][] segments = new int[2][n];
        for (int i = 0; i < n; i++) {
            segments[0][i] = s.nextInt();
            segments[1][i] = s.nextInt();
        }

        int[] points = new int[m];

        for (int i = 0; i < m; i++) {
            points[i] = s.nextInt();
        }

        int[] result = findBelonging(segments, points);

        for (int i = 0; i < m; i++) {
            System.out.print(result[i] + " ");
        }

    }

    public static int[] findBelonging(int[][] segments, int[] points){
        int[][] minMax = new int[2][200001];


        for (int i = 0; i < segments[0].length; i++) {
            minMax[0][segments[0][i] + 100000]++;
            minMax[1][segments[1][i] + 100000]++;

        }

        int[] belonging = new int[200001];
        belonging[0] = minMax[0][0];
        for (int i = 1; i < minMax[0].length; i++) {
            belonging[i] = belonging[i - 1] + minMax[0][i] - minMax[1][i-1];
        }

        int[] result = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            result[i] = belonging[points[i] + 100000];
        }
        return result;
    }

}
