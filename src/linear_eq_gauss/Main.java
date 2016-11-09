package linear_eq_gauss;

import java.util.Scanner;

/**
 * Created by User on 23.03.2015.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        double matrix[][] = new double[n][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m + 1; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }




        gauss(matrix, n, m);

    }

    static void gauss(double[][] matrix, int n, int m){
        boolean zeroStrings = false;

        //to upper triangular matrix


        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                
            }
            
        }
        
        /*
        int upperString = 0;
        for (int i = 0; i < m; i++) {
            int currentString = upperString;
            for (int j = currentString; j < n; j++) {

                if (matrix[j][i] != 0) {
                    matrix = exchangeStrings(matrix, j, currentString);
                    upperString++;
                    break;
                }
                if((j == n - 1) && (matrix[j][i] == 0)){
                    zeroStrings = true;
                    break;

                }
            }



            double p = matrix[currentString][i];

            System.out.println(p);

            for (int j = i; j < m + 1; j++) {
                matrix[currentString][j] = matrix[currentString][j] / p;
            }

            if(currentString < n - 1) {
                for (int j = currentString + 1; j < n; j++) {
                    double s = -matrix[j][i];
                    for (int k = i; k < m + 1; k++) {
                        matrix[j][k] = matrix[j][k] + s*matrix[currentString][k];
                    }
                }
            }

            printMatrix(matrix, n, m + 1);

        }
*/
        if(zeroStrings){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    //if()
                }
            }
        }

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

    public static void printMatrix(double[][] matrix, int n, int m){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();

        }
    }
}


