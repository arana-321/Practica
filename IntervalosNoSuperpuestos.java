
/**
 * Write a description of class rfgtfh here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class IntervalosNoSuperpuestos {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("=== INTERVALOS NO SUPERPUESTOS ===");
        System.out.print("Ingrese la cantidad de intervalos: ");
        int n = in.nextInt();
        int[][] intervals = new int[n][2];

        System.out.println("Ingrese los intervalos como pares inicio fin (cada par en una linea):");
        for (int i = 0; i < n; i++) {
            intervals[i][0] = in.nextInt(); 
            intervals[i][1] = in.nextInt(); 
        }

        int removals = eraseOverlapIntervals(intervals);
        System.out.println("Minimo numero de intervalos a eliminar: " + removals);

    }

    /**
     * Devuelve el mínimo número de intervalos a eliminar para que no haya solapamientos.
     * Enfoque greedy: ordenar por fin (end) ascendente y seleccionar tantos intervalos
     * no solapados como sea posible.
     */
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });

        int countNonOverlapping = 1;
        int lastEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            
            if (intervals[i][0] >= lastEnd) {
                countNonOverlapping++;
                lastEnd = intervals[i][1];
            }
        }

        return intervals.length - countNonOverlapping;
    }
}
