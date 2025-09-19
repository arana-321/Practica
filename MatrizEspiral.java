
/**
 * Write a description of class cbvdfbg here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatrizEspiral {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("=== MATRIZ ESPIRAL (sentido horario) ===");
        System.out.print("Ingrese n (tamaño de la matriz n x n): ");
        int n = in.nextInt();

        int[][] mat = new int[n][n];
        System.out.println("Ingrese los " + (n * n) + " elementos (fila por fila, separados por espacio o enter):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = in.nextInt();
            }
        }

        List<Integer> spiral = spiralOrder(mat);
        System.out.println("Salida: " + listToBracketsString(spiral));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;

        int n = matrix.length;            
        int m = matrix[0].length;         
        int top = 0, bottom = n - 1;
        int left = 0, right = m - 1;

        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) {
                res.add(matrix[top][j]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    res.add(matrix[bottom][j]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }

        return res;
    }

    private static String listToBracketsString(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
