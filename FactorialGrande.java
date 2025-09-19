
/**
 * Write a description of class wsrfwedgf here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class FactorialGrande {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("=== FACTORIAL DE UN NUMERO GRANDE ===");
        System.out.print("Ingrese un numero n: ");
        int n = in.nextInt();

        String resultado = factorialGrande(n);
        System.out.println("El factorial de " + n + " es:");
        System.out.println(resultado);
    }

    public static String factorialGrande(int n) {
        int[] resultado = new int[5000]; 
        resultado[0] = 1; 
        int tam = 1;

        for (int x = 2; x <= n; x++) {
            tam = multiplicar(x, resultado, tam);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = tam - 1; i >= 0; i--) {
            sb.append(resultado[i]);
        }
        return sb.toString();
    }

    private static int multiplicar(int x, int[] resultado, int tam) {
        int carry = 0;

        for (int i = 0; i < tam; i++) {
            int prod = resultado[i] * x + carry;
            resultado[i] = prod % 10; 
            carry = prod / 10;      
        }

        while (carry > 0) {
            resultado[tam] = carry % 10;
            carry /= 10;
            tam++;
        }

        return tam;
    }
}
