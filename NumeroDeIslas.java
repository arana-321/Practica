
/**
 * Write a description of class fhgfh here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class NumeroDeIslas {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("=== NUMERO DE ISLAS ===");
        System.out.print("Ingrese el numero de filas: ");
        int filas = in.nextInt();
        System.out.print("Ingrese el numero de columnas: ");
        int cols = in.nextInt();

        int[][] grid = new int[filas][cols];
        System.out.println("Ingrese los elementos (0 = agua, 1 = tierra), fila por fila, separados por espacio o enter:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = in.nextInt();
            }
        }

        int resultado = numIslands(grid);
        System.out.println("Numero de islas: " + resultado);
    }

    public static int numIslands(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int count = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1 && !visited[r][c]) {
                    
                    dfs(grid, visited, r, c);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int[][] grid, boolean[][] visited, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (r < 0 || r >= rows || c < 0 || c >= cols) return;
        if (visited[r][c]) return;
        if (grid[r][c] == 0) return; 

        visited[r][c] = true;

        dfs(grid, visited, r - 1, c);
        dfs(grid, visited, r + 1, c);
        dfs(grid, visited, r, c - 1);
        dfs(grid, visited, r, c + 1);
    }
}
