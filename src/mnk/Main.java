package mnk;

import java.util.Scanner;

/**
 * Created by User on 29.03.2015.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        double[][] A = new double[n][m];
        double[][] b = new double[n][1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                A[i][j] = sc.nextInt();
            }
            b[i][0] = sc.nextInt();
        }


    double[][] x = mnk(A, b, n, m);
    printMatrix(transpon(x, m, 1), 1, m);

    }

    public static void printMatrix(double[][] A, int n, int m){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(A[i][j] +  " ");
            }

            System.out.println();
        }
    }

    public static double[][] transpon (double[][] A, int n, int m){
        double[][] At = new double[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                At[j][i] = A[i][j];
            }
        }
        return At;
    }

    public static double[][] inverse (double[][] A, int n){
        double[][] Ainv = new double[n][n];

        for (int i = 0; i < n; i++) {

            Ainv[i][i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if(A[j][i] != 0) {
                    A = exchangeStrings(A, i, j);
                    Ainv = exchangeStrings(Ainv, i, j);
                    break;
                }
            }

            double s = A[i][i];
            for (int j = 0; j < n; j++) {
                A[i][j] = A[i][j] / s;
                Ainv[i][j] = Ainv[i][j] / s;
            }

            for (int j = 0; j < n; j++) {
                if(i != j){
                    double p = - A[j][i];
                    for (int k = 0; k < n; k++) {
                        A[j][k] = A[j][k] + p * A[i][k];
                        Ainv[j][k] = Ainv[j][k] + p*Ainv[i][k];
                    }
                }
            }
        }

        return Ainv;
    }

    public static double[][] multiply (double[][] A, double[][] B, int m, int n, int q){
        double[][] AB = new double[m][q];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < q; j++) {
                double sum = 0;
                for (int r = 0; r < n; r++) {
                    sum = sum + A[i][r]*B[r][j];
                }
                AB[i][j] = sum;
            }
        }

        return AB;
    }



    public static double[][] exchangeStrings(double[][] matrix, int str1, int str2){
        if(str1 == str2) return matrix;
        int n = matrix.length;
        int m = matrix[0].length;
        double[] line = new double[m];
        for (int i = 0; i < m; i++) {
            line[i] = matrix[str1][i];
            matrix[str1][i] = matrix[str2][i];
            matrix[str2][i] = line[i];
        }

        return matrix;
    }

    public static double[][] mnk(double[][] A, double[][] b, int n, int m){
        double[][] At = transpon(A, n, m);

        double[][] AtA = multiply(At, A, m, n, m);

        double[][] Atb = multiply(At, b, m, n, 1);

        double[][] invAtA = inverse(AtA, m);


        double[][] x = multiply(invAtA, Atb, m, m, 1);

        return x;
    }

}
