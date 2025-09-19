
/**
 * Write a description of class gfgf here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.HashSet;
import java.util.Scanner;
import java.util.Arrays;

public class SumaParesUnicos {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("=== SUMA DE PARES UNICOS ===");
        System.out.print("Ingrese la cantidad de elementos del array: ");
        int n = in.nextInt();
        int[] nums = new int[n];

        System.out.println("Ingrese los " + n + " elementos (separados por espacio o enter):");
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        System.out.print("Ingrese el target: ");
        int target = in.nextInt();

        String resultado = twoSumDetalle(nums, target);
        System.out.println("¿Existe un par que sume " + target + "? -> " + resultado);
    }

    /**
     * Devuelve un String con el detalle del resultado:
     * - "true (a + b = target)" si encuentra par
     * - "false" si no existe
     */
    public static String twoSumDetalle(int[] nums, int target) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            int complement = target - num;
            if (seen.contains(complement)) {
                return "true (" + complement + " + " + num + " = " + target + ")";
            }
            seen.add(num);
        }
        return "false";
    }
}
